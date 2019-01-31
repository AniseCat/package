package dao;

import Model.*;
import PO.CoursePO;
import PO.LecturePO;
import PO.NoticePO;
import PO.TeacherPO;
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
            CourselistPO courselistPO = (CourselistPO)session.createQuery(
                    "from CourselistPO where courseid = ?1 and mail = ?2 order by term desc")
                    .setParameter(1,courseId).setParameter(2,mail).setMaxResults(1).uniqueResult();
            courselistPO.setMark(mark);
            session.update(mark);
            tx.commit();
            session.close();
        }
        return success;
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
