package dao;

import Model.Course;
import Model.Lecture;
import Model.Teacher;

import java.util.ArrayList;

public interface TeacherDao {

    public boolean addLecture(Lecture lecture);

    public boolean addCourse(Course course);

    public boolean updateTeacher(Teacher teacher);

    public boolean updateMark(int courseId, ArrayList markList);

    public boolean startCourse(int courseId);

    public ArrayList getPreSelectList(int courseId);

    public ArrayList getCourseList(String mail);

    public ArrayList getLectureList(String mail);

}