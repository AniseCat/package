package Model;

public class Mark {
    String mail;
    double mark;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "mail='" + mail + '\'' +
                ", mark=" + mark +
                '}';
    }
}
