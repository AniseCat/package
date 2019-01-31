package PO;

import Model.Grade;

import javax.persistence.*;

@Entity
@Table(name = "lecture", schema = "j2ee", catalog = "")
public class LecturePO {
    private int id;
    private String name;
    private String content;
    private String teacherId;
    private Grade grade;
    private int isvalid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 256)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "teacherId", nullable = false, length = 128)
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "grade", nullable = true)
    @Enumerated(EnumType.STRING)
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "isvalid", nullable = false)
    public int getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(int isvalid) {
        this.isvalid = isvalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LecturePO lecturePO = (LecturePO) o;

        if (id != lecturePO.id) return false;
        if (isvalid != lecturePO.isvalid) return false;
        if (name != null ? !name.equals(lecturePO.name) : lecturePO.name != null) return false;
        if (content != null ? !content.equals(lecturePO.content) : lecturePO.content != null) return false;
        if (teacherId != null ? !teacherId.equals(lecturePO.teacherId) : lecturePO.teacherId != null) return false;
        if (grade != null ? !grade.equals(lecturePO.grade) : lecturePO.grade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + isvalid;
        return result;
    }
}
