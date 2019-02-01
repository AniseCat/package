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

    public boolean startCourse(int courseId){
        boolean successs = true;
        ArrayList studentList = teacherDao.getPreSelectList(courseId);
        successs = teacherDao.startCourse(courseId) &&
                new StudentServiceImpl().addIntoCourse(studentList,courseId);
        return successs;
    }

    public ArrayList getCourseList(String mail){
        return teacherDao.getCourseList(mail);
    }

    public ArrayList getLectureList(String mail){
        return teacherDao.getLectureList(mail);
    }

    //TODO
    public boolean uploadCourseware(int courseId, String coursewareUrl){
        return  true;
    }

    public boolean uploadExercise(int courseId, String exerciseUrl){
        return  true;
    }

    public boolean downloadExercise(int courseId, String exerciseUrl){
        return  true;
    }

    public ArrayList getExerciseList(){
        ArrayList list = new ArrayList();
        return list;
    }
}
