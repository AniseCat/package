package service;

import Message.AuthCodeException;
import Model.UserType;

public interface UserService {

    public boolean login(String userId,String password);

    public UserType getUserType(String userId);

    public AuthCodeException sendAuthCode(String mail);

    public boolean register(String mail, String password, int authCode, UserType userType);

    public boolean cancelUser(String mail);
}
