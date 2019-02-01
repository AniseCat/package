package PO;

import javax.persistence.*;

@Entity
@Table(name = "preselect", schema = "j2ee", catalog = "")
public class PreselectPO {
    private int id;
    private int courseid;
    private String mail;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "courseid", nullable = false)
    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 128)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreselectPO that = (PreselectPO) o;

        if (id != that.id) return false;
        if (courseid != that.courseid) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + courseid;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
    }
}
