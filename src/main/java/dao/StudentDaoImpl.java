package dao;

import Model.Course;
import Model.SelectCourse;
import Model.Student;
import PO.CoursePO;
import PO.PreselectPO;
import PO.SelectcoursePO;
import PO.StudentPO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao{

    public boolean updateStudent(Student student){
        boolean success = true;
        StudentPO studentPO = getStudentPO(student);
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        int num = (Integer) session.createQuery("select count(*) from StudentPO where mail = ?1")
                .setParameter(1,studentPO.getMail()).uniqueResult();
        if(num == 0)
            session.save(studentPO);
        else if(num == 1)
            session.update(studentPO);
        tx.commit();
        session.close();
        return success;
    }

    public boolean selectCourse(int courseId,String mail){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        CoursePO coursePO = (CoursePO) session.createQuery("from CoursePO where id = ?1")
                .setParameter(1,courseId).uniqueResult();
        if(coursePO.getStart() == 0){
            PreselectPO preselectPO = new PreselectPO();
            preselectPO.setCourseid(courseId);
            preselectPO.setMail(mail);
            session.save(preselectPO);
        }
        else if(coursePO.getStart() == 1){
            int num = (Integer) session.createQuery("select count(*) from SelectcoursePO where id = ?1")
                    .setParameter(1,courseId).uniqueResult();
            if (num < coursePO.getStudentNum()){
                SelectcoursePO selectcoursePO = new SelectcoursePO();
                selectcoursePO.setType("已选");
                selectcoursePO.setMark(null);
                selectcoursePO.setMail(mail);
                selectcoursePO.setCourseid(courseId);
                session.save(selectcoursePO);
            }
        }
        tx.commit();
        session.close();
        return success;
    }


    public SelectCourse getSelectCourse(int courseid, String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        SelectcoursePO selectcoursePO = (SelectcoursePO)session.createQuery(
                "from SelectcoursePO where courseid = ?1 and mail = ?2")
                .setParameter(1,courseid).setParameter(2,mail).uniqueResult();
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setMail(mail);
        selectCourse.setMark(selectcoursePO.getMark());
        CoursePO coursePO = (CoursePO)session.createQuery("from CoursePO " +
                "where id = ?1").setParameter(1,courseid).uniqueResult();
        Course course = new AdminDaoImpl().getCourse(coursePO);
        selectCourse.setCourse(course);
        tx.commit();
        session.close();
        return selectCourse;
    }

    public StudentPO getStudentPO(Student student){
        StudentPO studentPO = new StudentPO();
        studentPO.setMail(student.getMail());
        studentPO.setStudentId(student.getId());
        studentPO.setUsername(student.getName());
        studentPO.setIconUrl(student.getIconUrl());
        return studentPO;
    }

    public ArrayList getCourseList(String mail){
        ArrayList list = new ArrayList();
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList selectcoursePOList = (ArrayList) session.createQuery(
                "from SelectcoursePO where mail = ?1")
                .setParameter(1,mail).list();
        tx.commit();
        session.close();
        for(int i = 0; i < selectcoursePOList.size();i++) {
            list.add(getSelectCourse((SelectcoursePO) selectcoursePOList.get(i)));
        }
        return list;
    }

    public boolean clearPreSelect(int courseId){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        session.createQuery("delete from PreselectPO where courseid = ?1")
                .setParameter(1,courseId).executeUpdate();
        tx.commit();
        session.close();
        return success;
    }

    public ArrayList getSelectList(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList selectsPOList = (ArrayList)session.createQuery("from SelectcoursePO where mail = ?1")
        .setParameter(1,mail).list();
        ArrayList list = new ArrayList();
        for(int i = 0; i < selectsPOList.size(); i++){
            list.add(getSelectCourse((SelectcoursePO)selectsPOList.get(i)));
        }
        tx.commit();
        session.close();
        return list;
    }

    public Course getCourse(int courseId){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        CoursePO coursePO = (CoursePO) session.createQuery("from CoursePO " +
                "where id = ?1").setParameter(1,courseId).uniqueResult();
        Course course = new AdminDaoImpl().getCourse(coursePO);
        tx.commit();
        session.close();
        return course;
    }

    public boolean addIntoCourse(int courseId,String mail){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();

        SelectcoursePO selectcoursePO = new SelectcoursePO();
        selectcoursePO.setCourseid(courseId);
        selectcoursePO.setMail(mail);
        selectcoursePO.setMark(null);
        selectcoursePO.setType("已选");
        session.save(selectcoursePO);

        tx.commit();
        session.close();
        return success;
    }

    public SelectCourse getSelectCourse(SelectcoursePO selectcoursePO){
        SelectCourse selectCourse = new SelectCourse();
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        CoursePO coursePO = (CoursePO) session.createQuery("from CoursePO " +
                "where id = ?1").setParameter(1, selectcoursePO.getCourseid()).uniqueResult();
        Course course = new AdminDaoImpl().getCourse(coursePO);
        tx.commit();
        session.close();
        selectCourse.setCourse(course);
        selectCourse.setMark(selectcoursePO.getMark());
        selectCourse.setMail(selectcoursePO.getMail());
        selectCourse.setType(selectcoursePO.getType());
        return selectCourse;
    }

    public boolean deleteFromCourse(int courseId,String mail){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        session.createQuery("delete from PreselectPO where courseid = ?1 and mail = ?2")
                .setParameter(1,courseId).setParameter(2,mail).executeUpdate();
        session.createQuery("update SelectcoursePO set type = ?1 where courseid = ?2 and mail = ?3")
                .setParameter(1,"退选").setParameter(2,courseId).setParameter(3,mail);
        tx.commit();
        session.close();
        return success;
    }


}
