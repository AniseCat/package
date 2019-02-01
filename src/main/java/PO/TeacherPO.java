package PO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher", schema = "j2ee", catalog = "")
public class TeacherPO implements Serializable {
    private String mail;
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

        TeacherPO teacherPO = (TeacherPO) o;

        if (mail != null ? !mail.equals(teacherPO.mail) : teacherPO.mail != null) return false;
        if (username != null ? !username.equals(teacherPO.username) : teacherPO.username != null) return false;
        if (iconUrl != null ? !iconUrl.equals(teacherPO.iconUrl) : teacherPO.iconUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mail != null ? mail.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        return result;
    }
}
