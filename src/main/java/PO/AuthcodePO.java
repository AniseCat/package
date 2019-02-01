package PO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "authcode", schema = "j2ee", catalog = "")
public class AuthcodePO implements Serializable {
    private int id;
    private String mail;
    private Timestamp vaildTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 128)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "vaildTime", nullable = false)
    public Timestamp getVaildTime() {
        return vaildTime;
    }

    public void setVaildTime(Timestamp vaildTime) {
        this.vaildTime = vaildTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthcodePO that = (AuthcodePO) o;

        if (id != that.id) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (vaildTime != null ? !vaildTime.equals(that.vaildTime) : that.vaildTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (vaildTime != null ? vaildTime.hashCode() : 0);
        return result;
    }
}
