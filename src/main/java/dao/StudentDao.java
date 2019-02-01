package dao;

import Model.Course;
import Model.SelectCourse;
import Model.Student;

import java.util.ArrayList;

public interface StudentDao {

    public boolean updateStudent(Student student);

    public SelectCourse getSelectCourse(int courseid, String mail);

    public ArrayList getCourseList(String mail);

    public ArrayList getSelectList(String mail);

    public Course getCourse(int courseId);

    public boolean selectCourse(int courseId,String mail);

    public boolean addIntoCourse(int courseId,String mail);

    public boolean deleteFromCourse(int courseId,String mail);

    public boolean clearPreSelect(int courseId);
}
