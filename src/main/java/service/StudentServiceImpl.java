package service;

import Model.SelectCourse;
import Model.Student;
import dao.StudentDaoImpl;
import util.CourseUtil;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {

    StudentDaoImpl studentDao = new StudentDaoImpl();

    public boolean modifyInformation(Student student){
        return studentDao.updateStudent(student);
    }

    public boolean selectCourse(String studentId, int courseId){
        return studentDao.selectCourse(courseId,studentId);
    }

    public boolean cancelCourse(String studentId, int courseId){
        return studentDao.deleteFromCourse(courseId,studentId);
    }

    public boolean addIntoCourse(ArrayList studentList, int courseId){
        //根据算法，将学生名单分配进课程，并对每一个学生生成一条选课记录
        boolean success = true;
        int selectNum = studentDao.getCourse(courseId).getStudentNum();
        ArrayList list = new CourseUtil().addIntoCourse(studentList.size(),selectNum);
        for(int i = 0; i < list.size(); i++){
            success = studentDao.addIntoCourse(courseId,(String) studentList.get((Integer)(list.get(i))));
        }
        success = studentDao.clearPreSelect(courseId);
        return success;
    }

    public SelectCourse getCourseInformation(int courseId, String studentId){
        return studentDao.getSelectCourse(courseId,studentId);
    }

    public ArrayList getCourseList(String studentId){
        return studentDao.getCourseList(studentId);
    }

    public ArrayList getSelectList(String studentId){
        return studentDao.getSelectList(studentId);
    }

    //TODO
    public boolean downloadCourseware(int courseId, String coursewareUrl){
        return  true;
    }

    public boolean uploadExercise(int courseId, String studentId, String exerciseUrl){
        return  true;
    }

    public boolean downloadExercise(int courseId, String studentId, String exerciseUrl){
        return  true;
    }

}
