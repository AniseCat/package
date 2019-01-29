package service;

import Message.AuthCodeException;
import dao.MailDao;
import dao.MailDaoImpl;
import util.MailUtil;

import javax.mail.MessagingException;

public class StudentServiceImpl implements StudentService {

    MailDaoImpl mailDao = new MailDaoImpl();
    MailUtil mailUtil = new MailUtil();
    public AuthCodeException sendAuthCode(String mail){
        AuthCodeException result = AuthCodeException.成功;
        //如果有正在生效的验证码
        if(mailDao.hasValidAuthCode(mail)){
            return AuthCodeException.正在生效的验证码;
        }
        //生成并发送验证码
        int authCode = mailDao.getAuthCode(mail);
        try {
            mailUtil.send_mail(mail, String.valueOf(authCode));
        }catch (MessagingException e){
            e.printStackTrace();
            System.out.print("邮件未能成功发送");
            result = AuthCodeException.邮件发送失败;
        }
        return result;
    }

}
