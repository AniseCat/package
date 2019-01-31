package service;

import Model.Lecture;
import dao.TeacherDao;
import dao.TeacherDaoImpl;

public class TeacherServiceImpl implements TeacherService {

    TeacherDaoImpl teacherDao = new TeacherDaoImpl();

    public boolean addLecture(Lecture lecture){

        return true;
    }

}
