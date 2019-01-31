package dao;

import java.util.ArrayList;

public interface AdminDao {

    public boolean setLectureValid(int lectureId);

    public boolean setCourseValid(int courseId);

    public boolean deleteLecture(int lectureId);

    public boolean deleteCourse(int courseId);

    public ArrayList getLectureApply();

    public ArrayList getCourseApply();

    public ArrayList getTeacherList();

    public ArrayList getStudentList();

}
