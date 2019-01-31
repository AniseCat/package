package PO;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "j2ee", catalog = "")
public class CoursePO {
    private int id;
    private int lectureid;
    private String term;
    private int studentNum;
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

        CoursePO coursePO = (CoursePO) o;

        if (id != coursePO.id) return false;
        if (lectureid != coursePO.lectureid) return false;
        if (studentNum != coursePO.studentNum) return false;
        if (isvalid != coursePO.isvalid) return false;
        if (term != null ? !term.equals(coursePO.term) : coursePO.term != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + lectureid;
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + studentNum;
        result = 31 * result + isvalid;
        return result;
    }
}
