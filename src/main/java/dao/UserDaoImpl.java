package dao;

import Model.Notice;
import Model.Post;
import Model.PostItem;
import Model.UserType;
import PO.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    public boolean insertAuthCode(String mail){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        //插入一条新记录
        AuthcodePO po = new AuthcodePO();
        po.setMail(mail);
        //设置有效期为当前时间+5分钟
        po.setVaildTime(new Timestamp(System.currentTimeMillis() + 5*60*1000));
        session.save(po);
        tx.commit();
        session.close();
        //返回验证码
        return success;
    }

    public int getAuthCode(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        int authCode = (Integer) session.createQuery(
                "select id from AuthcodePO order by id desc").setMaxResults(1).uniqueResult();
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
        long num = (Long)session.createQuery(
                "select count(*) from AuthcodePO where mail = ?1 " +
                        "and vaildTime > ?2").setParameter(1,mail).
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
                        "and vaildTime > ?2").setParameter(1,mail).
                setParameter(2,now).uniqueResult();
        if(id == authCode){
            UserPO userPO = new UserPO();
            userPO.setMail(mail);
            userPO.setPassword(password);
            userPO.setUsertype(userType);
            userPO.setIsvalid(1);
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
                setParameter(2,1).uniqueResult();
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

    public boolean addPost(Post post){
        boolean success =true;
        PostPO postPO = getPostPO(post);
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        session.save(postPO);
        tx.commit();
        session.close();
        return success;
    }

    public boolean addRemark(PostItem postItem){
        boolean success =true;
        PostitemPO postitemPO = getPostitemPO(postItem);
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        session.save(postitemPO);
        tx.commit();
        session.close();
        return success;
    }

    public ArrayList getNotice(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList noticePOlist = (ArrayList)session.createQuery("from NoticePO " +
                "where mail = ?1").setParameter(1,mail);
        session.createQuery("delete  NoticePO ").executeUpdate();
        tx.commit();
        session.close();
        ArrayList list = new ArrayList();
        for(int i = 0; i < noticePOlist.size();i++){
            list.add(getNotice((NoticePO)noticePOlist.get(i)));
        }
        return list;
    }

    public PostPO getPostPO(Post post){
        PostPO postPO = new PostPO();
        postPO.setUsername(post.getUsername());
        postPO.setTitle(post.getTitle());
        postPO.setTime(post.getTime());
        postPO.setContent(post.getContent());
        return postPO;
    }

    public PostitemPO getPostitemPO(PostItem postItem){
        PostitemPO postitemPO = new PostitemPO();
        postitemPO.setPostid(postItem.getPostId());
        postitemPO.setParentid(postItem.getParentId());
        postitemPO.setUsername(postItem.getUsername());
        postitemPO.setTime(postItem.getTime());
        postitemPO.setContent(postItem.getContent());
        return postitemPO;
    }

    public Notice getNotice(NoticePO noticePO){
        Notice notice = new Notice();
        notice.setMail(noticePO.getMail());
        notice.setContent(noticePO.getContent());
        return notice;
    }

}
