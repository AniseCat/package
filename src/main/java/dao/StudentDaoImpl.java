package dao;

import Model.Student;
import PO.StudentPO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

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

    public StudentPO getStudentPO(Student student){
        StudentPO studentPO = new StudentPO();
        studentPO.setMail(student.getMail());
        studentPO.setStudentId(student.getId());
        studentPO.setUsername(student.getName());
        studentPO.setIconUrl(student.getIconUrl());
        return studentPO;
    }
}
