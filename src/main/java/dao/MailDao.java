package dao;

public interface MailDao {

    public int getAuthCode(String mail);

    public boolean hasValidAuthCode(String mail);

}
