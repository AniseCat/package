package service;

import Message.AuthCodeException;
import Model.Course;
import Model.Post;
import Model.PostItem;
import Model.Student;

import java.util.ArrayList;

public interface StudentService {

    public boolean modifyInformation(Student student);

    //如果比开课时间早，则加入待选；否则，如果有空缺，直接选入
    public boolean selectCourse(String studentId, String courseId);

    public boolean cancelCourse(String studentId, String courseId);

    public boolean addIntoCourse(ArrayList studentList, String courseId);

    public boolean downloadCourseware(String courseId, String coursewareUrl);

    public boolean uploadExercise(String courseId, String studentId, String exerciseUrl);

    public boolean downloadExercise(String courseId, String studentId, String exerciseUrl);

    public boolean getCourseInformation(String courseId, String studentId);

    //查看退选课信息，成绩信息等(可以按照学期 课程 老师来查询/排列)
    public ArrayList getStudyInformation();

}
