package service;

import Message.AuthCodeException;
import Model.*;

import java.util.ArrayList;

public interface TeacherService {

    public boolean modifyInformation(Teacher teacher);

    public boolean addLecture(Lecture lecture);

    public boolean addCourse(Course course);

    public boolean uploadCourseware(int courseId, String coursewareUrl);

    public boolean uploadExercise(int courseId, String exerciseUrl);

    public boolean downloadExercise(int courseId, String exerciseUrl);

    public boolean publishMark(int courseId,ArrayList markList);

    public boolean startCourse(int courseId);

    //查看课程信息 作业信息等(可以按照学期、课程、学生类型查找/排列)
    public ArrayList getCourseList(String mail);

    public ArrayList getLectureList(String mail);

    public ArrayList getExerciseList();


}
