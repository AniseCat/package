package dao;

import PO.AuthcodePO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MailDaoImpl implements MailDao{

    public int getAuthCode(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        //插入一条新记录
        AuthcodePO po = new AuthcodePO();
        po.setMail(mail);
        //设置有效期为当前时间+5分钟
        po.setVaildTime(new Timestamp(System.currentTimeMillis() + 5*60*1000));
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

}
