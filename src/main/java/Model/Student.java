package Model;

public class Student {

    String mail;
    String id;
    String name;
    String iconUrl;

    public Student(){

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mail='" + mail + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }
}
