package dao;

import Model.Post;
import Model.PostItem;
import Model.UserType;

import java.util.ArrayList;

public interface UserDao {

    public int getAuthCode(String mail);

    public boolean hasValidAuthCode(String mail);

    public boolean addUser(String mail, String password, int authCode, UserType userType);

    public String getPassword(String mail);

    public UserType getUserType(String mail);

    public boolean cancelUser(String mail);

    public boolean addPost(Post post);

    public boolean addRemark(PostItem postItem);

    public ArrayList getNotice(String mail);

}
