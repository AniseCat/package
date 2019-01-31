package Model;

public class Teacher {

    String mail;
    String name;
    String iconUrl;

    public Teacher(){

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        return "Teacher{" +
                "mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }
}
