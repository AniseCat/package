package service;

import Message.AuthCodeException;
import Model.*;

import java.util.ArrayList;

public interface TeacherService {

    public boolean modifyInformation(Student student);

    public boolean addLecture(Lecture lecture);

    public boolean addCourse(Course course);

    public ArrayList getNotice(String teacherId);

    public boolean uploadCourseware(String courseId, String coursewareUrl);

    public boolean uploadExercise(String courseId, String exerciseUrl);

    public boolean downloadExercise(String courseId, String exerciseUrl);

    public boolean publishMark(String courseId);

    public boolean addPost(Post p);

    public boolean remarkPost(PostItem item);

    //查看课程信息 作业信息等(可以按照学期、课程、学生类型查找/排列)
    public ArrayList getStudyInformation();
}
