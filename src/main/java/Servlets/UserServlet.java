package Servlets;

import Message.AuthCodeException;
import service.UserServiceImpl;
import util.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("*.do")
public class UserServlet extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                 doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1.获取servletPath：/add.do 或者 query.do
        String serveltPath = req.getServletPath();
        System.out.println(serveltPath);
        //2.去除/ 和 .do 得到对应的方法，如 add  query
        String methodName = serveltPath.substring(1);
        methodName = methodName.substring(0, methodName.length() - 3);
        // System.out.println(methodName);35
        try {
            //3.利用反射获取methodName对应的方法
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            //4.利用反射调用方法
            method.invoke(this, req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private void toRegister(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        req.getRequestDispatcher(req.getContextPath()+"/register.jsp").forward(req,resp);
    }

    private void toLogin(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req,resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        if(userService.login(mail,password)){
            System.out.print("success");
        }
        else{
            System.out.print("fail");
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

    }

    private void getAuthcode(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String mail = req.getParameter("mail");
        AuthCodeException authCodeException = userService.sendAuthCode(mail);
        if(authCodeException == AuthCodeException.成功){
            int authcode = userService.getAuthcode(mail);
            try {
                new MailUtil().send_mail(mail, "验证码是" + authcode);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
