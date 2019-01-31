package Model;

public class Course {

    //课程Id
    int courseId;
    //从属的课程
    Lecture lecture;
    //学期
    String term;
    //班级人数
    int studentNum;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", lecture=" + lecture +
                ", term='" + term + '\'' +
                ", studentNum=" + studentNum +
                '}';
    }
}
