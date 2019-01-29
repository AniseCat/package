package dao;

import Model.UserType;
import PO.AuthcodePO;
import PO.UserPO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Timestamp;

public class UserDaoImpl implements UserDao {

    public int getAuthCode(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        //插入一条新记录
        AuthcodePO po = new AuthcodePO();
        po.setMail(mail);
        //设置有效期为当前时间+5分钟
        po.setVaildTime(new Timestamp(System.currentTimeMillis() + 5*60*1000));
        session.save(po);
        //获取最大值(即刚插入的值)
        int authCode = (Integer) session.createQuery(
                "select max(id) from AuthcodePO").uniqueResult();
        tx.commit();
        session.close();
        //返回验证码
        return authCode;
    }

    public boolean hasValidAuthCode(String mail){
        boolean inDatabase = false;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        //查找与当前用户的mail相同且仍在生效的验证码
        int num = (Integer)session.createQuery(
                "select count(*) from AuthcodePO where mail = ?1 " +
                        "and vaildTime < ?2").setParameter(1,mail).
                setParameter(2,now).uniqueResult();
        if(num > 0)
            inDatabase = true;
        tx.commit();
        session.close();
        return inDatabase;
    }

    public boolean addUser(String mail, String password, int authCode, UserType userType){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        //查找与当前用户的mail相同且仍在生效的验证码
        int id = (Integer)session.createQuery(
                "select id from AuthcodePO where mail = ?1 " +
                        "and vaildTime < ?2").setParameter(1,mail).
                setParameter(2,now).uniqueResult();
        if(id == authCode){
            UserPO userPO = new UserPO();
            userPO.setMail(mail);
            userPO.setPassword(password);
            userPO.setUsertype(userType);
            session.save(userPO);
            tx.commit();
            session.close();
            return true;
        }
        else{
            return false;
        }
    }

    public String getPassword(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        String password = (String)session.createQuery(
                "select password from UserPO where mail = ?1 " +
                        "and isvalid = ?2").setParameter(1,mail).
                setParameter(2,true).uniqueResult();
        tx.commit();
        session.close();
        return password;
    }

    public UserType getUserType(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        UserType userType = (UserType) session.createQuery(
                "select usertype from UserPO where mail = ?1 " +
                        "and isvalid = ?2").setParameter(1,mail).
                setParameter(2,1).uniqueResult();
        tx.commit();
        session.close();
        return userType;
    }

    public boolean cancelUser(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        UserPO userPO = (UserPO) session.createQuery(
                "from UserPO where mail = ?1 " +
                        "and isvalid = ?2").setParameter(1,mail).
                setParameter(2,1).uniqueResult();
        userPO.setIsvalid(0);
        session.update(userPO);
        tx.commit();
        session.close();
        return true;
    }

}
