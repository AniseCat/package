package PO;

import Model.UserType;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "j2ee", catalog = "")
public class UserPO {
    private int id;
    private String mail;
    private String password;
    private Integer isvalid;
    private UserType usertype;


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
    @Column(name = "password", nullable = false, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "isvalid", nullable = true)
    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    @Basic
    @Column(name = "usertype", nullable = true)
    @Enumerated(EnumType.STRING)
    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPO userPO = (UserPO) o;

        if (id != userPO.id) return false;
        if (mail != null ? !mail.equals(userPO.mail) : userPO.mail != null) return false;
        if (password != null ? !password.equals(userPO.password) : userPO.password != null) return false;
        if (isvalid != null ? !isvalid.equals(userPO.isvalid) : userPO.isvalid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isvalid != null ? isvalid.hashCode() : 0);
        return result;
    }

    }
