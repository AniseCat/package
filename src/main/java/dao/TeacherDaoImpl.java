package dao;

import Model.*;
import PO.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;

public class TeacherDaoImpl implements TeacherDao {

    public boolean addLecture(Lecture lecture){
        boolean success = true;
        LecturePO lecturePO = getLecturePO(lecture);
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        session.save(lecturePO);
        tx.commit();
        session.close();
        return success;
    }

    public boolean addCourse(Course course){
        boolean success = true;
        CoursePO coursePO = getCoursePO(course);
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        session.save(coursePO);
        tx.commit();
        session.close();
        return success;
    }

    public boolean updateTeacher(Teacher teacher){
        boolean success = true;
        TeacherPO teacherPO = getTeacherPO(teacher);
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        int num = (Integer) session.createQuery("select count(*) from TeacherPO where mail = ?1")
                .setParameter(1,teacherPO.getMail()).uniqueResult();
        if(num == 0)
            session.save(teacherPO);
        else if(num == 1)
            session.update(teacherPO);
        tx.commit();
        session.close();
        return success;
    }

    public boolean updateMark(int courseId, ArrayList markList){
        boolean success = true;
        for(int i = 0 ; i < markList.size(); i++){
            String mail = ((Mark)markList.get(i)).getMail();
            double mark = ((Mark)markList.get(i)).getMark();
            Session session = HibernateUtil.getSession() ;
            Transaction tx=session.beginTransaction();
            SelectcoursePO courselistPO = (SelectcoursePO)session.createQuery(
                    "from SelectcoursePO where courseid = ?1 and mail = ?2")
                    .setParameter(1,courseId).setParameter(2,mail).uniqueResult();
            courselistPO.setMark(mark);
            session.update(mark);
            tx.commit();
            session.close();
        }
        return success;
    }

    public boolean startCourse(int courseId){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        session.createQuery("update CoursePO set start = ?1 where id = ?2")
                .setParameter(1,1).setParameter(2,courseId).executeUpdate();
        tx.commit();
        session.close();
        return success;
    }

    public ArrayList getPreSelectList(int courseId){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList coursePOList = (ArrayList)session.createQuery(
                "from PreselectPO where courseid = ?1"
        ).setParameter(1,courseId).list();
        tx.commit();
        session.close();
        ArrayList list = new ArrayList();
        for(int i = 0; i < coursePOList.size(); i++){
            list.add(((PreselectPO)coursePOList.get(i)).getMail());
        }
        return list;
    }

    public ArrayList getCourseList(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList coursePOList = (ArrayList)session.createQuery(
                "from CoursePO c, LecturePO l where c.lectureid = l.id and l.teacherId = ?1"
        ).setParameter(1,mail).list();
        tx.commit();
        session.close();
        ArrayList list = new ArrayList();
        for(int i = 0; i < coursePOList.size(); i++){
            list.add(new AdminDaoImpl().getCourse((CoursePO)coursePOList.get(i)));
        }
        return list;
    }

    public ArrayList getLectureList(String mail){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList lecturePOList = (ArrayList)session.createQuery(
                "from LecturePO where teacherId = ?1"
        ).setParameter(1,mail).list();
        tx.commit();
        session.close();
        ArrayList list = new ArrayList();
        for(int i = 0; i < lecturePOList.size(); i++){
            list.add(new AdminDaoImpl().getLecture((LecturePO)lecturePOList.get(i)));
        }
        return list;
    }

    public LecturePO getLecturePO(Lecture lecture){
        LecturePO lecturePO = new LecturePO();
        lecturePO.setTeacherId(lecture.getTeacherId());
        lecturePO.setName(lecture.getName());
        lecturePO.setContent(lecture.getContent());
        lecturePO.setGrade(lecture.getGrade());
        return lecturePO;
    }

    public CoursePO getCoursePO(Course course){
        CoursePO coursePO = new CoursePO();
        coursePO.setLectureid(course.getLecture().getLectureid());
        coursePO.setTerm(course.getTerm());
        coursePO.setStudentNum(course.getStudentNum());
        return coursePO;
    }

    public TeacherPO getTeacherPO(Teacher teacher){
        TeacherPO teacherPO = new TeacherPO();
        teacherPO.setMail(teacher.getMail());
        teacherPO.setUsername(teacher.getName());
        teacherPO.setIconUrl(teacher.getIconUrl());
        return teacherPO;
    }

}
