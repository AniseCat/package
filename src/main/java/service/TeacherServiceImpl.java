package service;

import Model.Course;
import Model.Lecture;
import Model.Teacher;
import dao.TeacherDaoImpl;

import java.util.ArrayList;

public class TeacherServiceImpl implements TeacherService {

    TeacherDaoImpl teacherDao = new TeacherDaoImpl();

    public boolean modifyInformation(Teacher teacher) { return teacherDao.updateTeacher(teacher); }

    public boolean addLecture(Lecture lecture){
        return teacherDao.addLecture(lecture);
    }

    public boolean addCourse(Course course){
        return teacherDao.addCourse(course);
    }

    public boolean publishMark(int courseId, ArrayList markList){
        return teacherDao.updateMark(courseId,markList);
    }
}
