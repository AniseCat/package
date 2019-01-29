package dao;

import Model.UserType;

public interface UserDao {

    public int getAuthCode(String mail);

    public boolean hasValidAuthCode(String mail);

    public boolean addUser(String mail, String password, int authCode, UserType userType);

    public String getPassword(String mail);

    public UserType getUserType(String mail);

    public boolean cancelUser(String mail);

}
