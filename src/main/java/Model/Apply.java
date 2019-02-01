package Model;

public class Apply {
    //开课申请还是建课申请
    String type;
    //老师
    String mail;
    //课程Id
    int id;
    //课程名
    String name;
    //学期
    String term;
    //人数
    int studentNum;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "type='" + type + '\'' +
                ", mail='" + mail + '\'' +
                ", id=" + id +
                ", name=" + name +
                ", term='" + term + '\'' +
                ", studentNum=" + studentNum +
                '}';
    }
}
