package service;

import Message.AuthCodeException;
import Model.*;

import java.util.ArrayList;

public interface StudentService {

    public boolean modifyInformation(Student student);

    //如果比开课时间早，则加入待选；否则，如果有空缺，直接选入
    public boolean selectCourse(String studentId, int courseId);

    public boolean cancelCourse(String studentId, int courseId);

    public boolean addIntoCourse(ArrayList studentList, int courseId);

    public boolean downloadCourseware(int courseId, String coursewareUrl);

    public boolean uploadExercise(int courseId, String studentId, String exerciseUrl);

    public boolean downloadExercise(int courseId, String studentId, String exerciseUrl);

    public SelectCourse getCourseInformation(int courseId, String studentId);

    public ArrayList getCourseList(String studentId);

    public ArrayList getSelectList(String studentId);

}
