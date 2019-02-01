package Model;

public class SelectCourse {
    private Course course;
    private String mail;
    private Double mark;
    private String type;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SelectCourse{" +
                "course=" + course +
                ", mail='" + mail + '\'' +
                ", mark=" + mark +
                ", type='" + type + '\'' +
                '}';
    }
}
