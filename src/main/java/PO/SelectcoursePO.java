package PO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "selectcourse", schema = "j2ee", catalog = "")
public class SelectcoursePO implements Serializable {
    private int courseid;
    private String mail;
    private Double mark;
    private int id;
    private String type;

    @Basic
    @Column(name = "courseid", nullable = false)
    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Basic
    @Id
    @Column(name = "mail", nullable = false, length = 128)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "mark", nullable = true, precision = 0)
    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectcoursePO that = (SelectcoursePO) o;

        if (courseid != that.courseid) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseid;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 8)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
