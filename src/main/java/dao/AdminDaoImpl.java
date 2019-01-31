package dao;

import Model.Course;
import Model.Lecture;
import Model.Teacher;
import Model.Student;
import PO.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;

public class AdminDaoImpl implements AdminDao {

    public boolean setLectureValid(int lectureId){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        LecturePO lecturePO = session.get(LecturePO.class,lectureId);
        lecturePO.setIsvalid(1);
        session.update(lecturePO);
        NoticePO noticePO = new NoticePO();
        noticePO.setMail(lecturePO.getTeacherId());
        noticePO.setContent("Lecture:"+lecturePO.getName()+"批准通过");
        session.save(noticePO);
        tx.commit();
        session.close();
        return success;
    }

    public boolean setCourseValid(int courseId){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        CoursePO coursePO = session.get(CoursePO.class,courseId);
        coursePO.setIsvalid(1);
        session.update(coursePO);
        NoticePO noticePO = new NoticePO();
        noticePO.setMail(getCourse(coursePO).getLecture().getTeacherId());
        noticePO.setContent("Course:"+getCourse(coursePO).getLecture().getName()
                +"-"+coursePO.getTerm()+"批准通过");
        session.save(noticePO);
        tx.commit();
        session.close();
        return success;
    }

    public boolean deleteLecture(int lectureId){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        LecturePO lecturePO = session.get(LecturePO.class,lectureId);
        session.delete(lecturePO);
        NoticePO noticePO = new NoticePO();
        noticePO.setMail(lecturePO.getTeacherId());
        noticePO.setContent("Lecture:"+lecturePO.getName()+"申请被拒");
        session.save(noticePO);
        tx.commit();
        session.close();
        return success;
    }

    public boolean deleteCourse(int courseId){
        boolean success = true;
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        CoursePO coursePO = session.get(CoursePO.class,courseId);
        session.delete(coursePO);
        NoticePO noticePO = new NoticePO();
        noticePO.setMail(getCourse(coursePO).getLecture().getTeacherId());
        noticePO.setContent("Course:"+getCourse(coursePO).getLecture().getName()
                +"-"+coursePO.getTerm()+"批准被拒");
        session.save(noticePO);
        tx.commit();
        session.close();
        return success;
    }

    public ArrayList getLectureApply(){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList lecturePOList = (ArrayList)session.createQuery(
                "from LecturePO where isvalid = ?1"
        ).setParameter(1,0).list();
        tx.commit();
        session.close();
        ArrayList list = new ArrayList();
        for(int i = 0; i < lecturePOList.size(); i++){
            list.add(getLecture((LecturePO)lecturePOList.get(i)));
        }
        return list;
    }

    public ArrayList getCourseApply(){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList coursePOList = (ArrayList)session.createQuery(
                "from CoursePO where isvalid = ?1"
        ).setParameter(1,0).list();
        tx.commit();
        session.close();
        ArrayList list = new ArrayList();
        for(int i = 0; i < coursePOList.size(); i++){
            list.add(getCourse((CoursePO)coursePOList.get(i)));
        }
        return list;
    }

    public ArrayList getTeacherList(){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList teacherPOList = (ArrayList)session.createQuery(
                "from TeacherPO").list();
        tx.commit();
        session.close();
        ArrayList list = new ArrayList();
        for(int i = 0; i < teacherPOList.size(); i++){
            list.add(getTeacher((TeacherPO)teacherPOList.get(i)));
        }
        return list;
    }

    public ArrayList getStudentList(){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        ArrayList studentPOList = (ArrayList)session.createQuery(
                "from StudentPO").list();
        tx.commit();
        session.close();
        ArrayList list = new ArrayList();
        for(int i = 0; i < studentPOList.size(); i++){
            list.add(getStudent((StudentPO)studentPOList.get(i)));
        }
        return list;
    }

    public Lecture getLecture(LecturePO lecturePO){
        Lecture lecture = new Lecture();
        lecture.setLectureid(lecturePO.getId());
        lecture.setTeacherId(lecturePO.getTeacherId());
        lecture.setName(lecturePO.getName());
        lecture.setContent(lecturePO.getContent());
        lecture.setGrade(lecturePO.getGrade());
        return lecture;
    }

    public  LecturePO getLecturePO(int lectureId){
        Session session = HibernateUtil.getSession() ;
        Transaction tx=session.beginTransaction();
        LecturePO lecturePO = session.get(LecturePO.class,lectureId);
        tx.commit();
        session.close();
        return lecturePO;
    }

    public Course getCourse(CoursePO coursePO){
        Course course = new Course();
        course.setCourseId(coursePO.getId());
        course.setLecture(getLecture(getLecturePO(coursePO.getLectureid())));
        course.setTerm(coursePO.getTerm());
        course.setStudentNum(coursePO.getStudentNum());
        return course;
    }

    public Teacher getTeacher(TeacherPO teacherPO){
        Teacher teacher = new Teacher();
        teacher.setMail(teacherPO.getMail());
        teacher.setName(teacherPO.getUsername());
        teacher.setIconUrl(teacherPO.getIconUrl());
        return teacher;
    }

    public Student getStudent(StudentPO studentPO){
        Student student = new Student();
        student.setMail(studentPO.getMail());
        student.setId(studentPO.getStudentId());
        student.setName(studentPO.getUsername());
        student.setIconUrl(studentPO.getIconUrl());
        return student;
    }

}
