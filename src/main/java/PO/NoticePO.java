package PO;

import javax.persistence.*;

@Entity
@Table(name = "notice", schema = "j2ee", catalog = "")
public class NoticePO {
    private int id;
    private String mail;
    private String content;

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
    @Column(name = "content", nullable = false, length = 64)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoticePO noticePO = (NoticePO) o;

        if (id != noticePO.id) return false;
        if (mail != null ? !mail.equals(noticePO.mail) : noticePO.mail != null) return false;
        if (content != null ? !content.equals(noticePO.content) : noticePO.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
