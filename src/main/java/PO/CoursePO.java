package PO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course", schema = "j2ee", catalog = "")
public class CoursePO implements Serializable {
    private int id;
    private int lectureid;
    private String term;
    private int studentNum;
    private Integer start;
    private Integer isvalid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lectureid", nullable = false)
    public int getLectureid() {
        return lectureid;
    }

    public void setLectureid(int lectureid) {
        this.lectureid = lectureid;
    }

    @Basic
    @Column(name = "term", nullable = false, length = 32)
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Basic
    @Column(name = "studentNum", nullable = false)
    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Basic
    @Column(name = "start", nullable = true)
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    @Basic
    @Column(name = "isvalid", nullable = true)
    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursePO coursePO = (CoursePO) o;

        if (id != coursePO.id) return false;
        if (lectureid != coursePO.lectureid) return false;
        if (studentNum != coursePO.studentNum) return false;
        if (term != null ? !term.equals(coursePO.term) : coursePO.term != null) return false;
        if (start != null ? !start.equals(coursePO.start) : coursePO.start != null) return false;
        if (isvalid != null ? !isvalid.equals(coursePO.isvalid) : coursePO.isvalid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + lectureid;
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + studentNum;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (isvalid != null ? isvalid.hashCode() : 0);
        return result;
    }
}
