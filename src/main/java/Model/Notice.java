package Model;

public class Notice {
    String mail;
    String content;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "mail='" + mail + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
