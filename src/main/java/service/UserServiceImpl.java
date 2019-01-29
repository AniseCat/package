package service;

import Message.AuthCodeException;
import Model.UserType;
import dao.UserDaoImpl;
import util.MailUtil;

import javax.mail.MessagingException;

public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();
    MailUtil mailUtil = new MailUtil();

    public boolean login(String userId,String password){
        if(password .equals(userDao.getPassword(userId)))
            return true;
        else
            return false;
    }

    public UserType getUserType(String userId){
        return userDao.getUserType(userId);
    }

    public AuthCodeException sendAuthCode(String mail){
        AuthCodeException result = AuthCodeException.成功;
        //如果有正在生效的验证码
        if(userDao.hasValidAuthCode(mail)){
            return AuthCodeException.正在生效的验证码;
        }
        //生成并发送验证码
        int authCode = userDao.getAuthCode(mail);
        try {
            mailUtil.send_mail(mail, String.valueOf(authCode));
        }catch (MessagingException e){
            e.printStackTrace();
            System.out.print("邮件未能成功发送");
            result = AuthCodeException.邮件发送失败;
        }
        return result;
    }

    public boolean register(String mail, String password, int authCode, UserType userType){
        return userDao.addUser(mail,password,authCode,userType);
    }

    public boolean cancelUser(String mail){
        return userDao.cancelUser(mail);
    }

}
