package PO;

import javax.persistence.*;

@Entity
@Table(name = "student", schema = "j2ee", catalog = "")
public class StudentPO {
    private String mail;
    private String studentId;
    private String username;
    private String iconUrl;

    @Id
    @Column(name = "mail", nullable = false, length = 128)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "studentId", nullable = false, length = 16)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 32)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "iconUrl", nullable = true, length = 128)
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentPO studentPO = (StudentPO) o;

        if (mail != null ? !mail.equals(studentPO.mail) : studentPO.mail != null) return false;
        if (studentId != null ? !studentId.equals(studentPO.studentId) : studentPO.studentId != null) return false;
        if (username != null ? !username.equals(studentPO.username) : studentPO.username != null) return false;
        if (iconUrl != null ? !iconUrl.equals(studentPO.iconUrl) : studentPO.iconUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mail != null ? mail.hashCode() : 0;
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        return result;
    }
}
