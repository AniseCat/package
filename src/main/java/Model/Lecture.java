package Model;

public class Lecture {

    //课程号
    int lectureid;
    //课名
    String name;
    //课程内容
    String content;
    //老师
    String teacherId;
    //年级
    Grade grade;

    public int getLectureid() {
        return lectureid;
    }

    public void setLectureid(int lectureid) {
        this.lectureid = lectureid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureid=" + lectureid +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", grade=" + grade +
                '}';
    }
}
