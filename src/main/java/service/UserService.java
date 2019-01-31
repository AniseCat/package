package service;

import Message.AuthCodeException;
import Model.Post;
import Model.PostItem;
import Model.UserType;

import java.util.ArrayList;

public interface UserService {

    public boolean login(String mail,String password);

    public UserType getUserType(String mail);

    public AuthCodeException sendAuthCode(String mail);

    public boolean register(String mail, String password, int authCode, UserType userType);

    public boolean cancelUser(String mail);

    public boolean addPost(Post p);

    public boolean remarkPost(PostItem item);

    public ArrayList getNotice(String mail);
}
