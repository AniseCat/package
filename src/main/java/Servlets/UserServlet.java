package Servlets;

import Message.AuthCodeException;
import Model.Admin;
import Model.UserType;
import bean.AdminBean;
import bean.MessageBean;
import bean.StudentBean;
import bean.TeacherBean;
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

    private void Login(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String login = req.getParameter("login");
        String toRegister = req.getParameter("toRegister");
        if (login != null) {
            login(req, resp);
        }
        if (toRegister != null) {
            toRegister(req, resp);
        }

    }

    private void Register(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String toLogin = req.getParameter("toLogin");
        String register = req.getParameter("register");
        String getAuthcode = req.getParameter("getAuthcode");
        if (toLogin != null) {
            toLogin(req, resp);
        }
        if (register != null) {
            register(req, resp);
        }
        if (getAuthcode != null) {
            getAuthcode(req, resp);
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
        int authcode = Integer.parseInt(req.getParameter("authcode"));
        String userType = req.getParameter("userType");
        UserType user;
        if(userType.equals("老师"))
            user = UserType.Teacher;
        else
            user = UserType.Student;
        boolean success = userService.register(mail,password,authcode,user);
        MessageBean messageBean = new MessageBean();
        if(success){
            messageBean.setMessage("注册成功!");
            req.setAttribute("messageBean",messageBean);
            req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req,resp);
        }
        else{
            messageBean.setMessage(null);
            req.setAttribute("messageBean",messageBean);
            req.getRequestDispatcher(req.getContextPath()+"/register.jsp").forward(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        if(userService.login(mail,password)){
            UserType userType = userService.getUserType(mail);
            if(userType == UserType.Admin){
                AdminBean adminBean = new AdminBean();
                adminBean.setMail(mail);
                req.setAttribute("adminBean",adminBean);
                req.getRequestDispatcher(req.getContextPath()+"/admin.jsp").forward(req,resp);
            }else if(userType == UserType.Student){
                StudentBean studentBean = new StudentBean();
                ??
                req.setAttribute("studentBean",studentBean);
                req.getRequestDispatcher(req.getContextPath()+"/student.jsp").forward(req,resp);
            }else if(userType == UserType.Teacher){
                TeacherBean teacherBean = new TeacherBean();
                ??
                req.setAttribute("teacherBean",teacherBean);
                req.getRequestDispatcher(req.getContextPath()+"/teacher.jsp").forward(req,resp);
            }
        }
        else{
            MessageBean messageBean = new MessageBean();
            messageBean.setMessage(null);
            req.setAttribute("messageBean",messageBean);
            req.getRequestDispatcher(req.getContextPath()+"/register.jsp").forward(req,resp);
        }
    }

    private void getAuthcode(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String mail = req.getParameter("mail");
        System.out.print(mail);
        AuthCodeException authCodeException = userService.sendAuthCode(mail);
        MessageBean messageBean = new MessageBean();
        if(authCodeException == AuthCodeException.成功){
            messageBean.setMessage("验证码已发送，请查看邮箱并在5min内使用");
        } else if(authCodeException == AuthCodeException.正在生效的验证码){
            messageBean.setMessage("有正在生效的验证码，请稍后再试");
        } else{
            messageBean.setMessage("邮件发送失败");
        }
        req.setAttribute("messageBean",messageBean);
        req.getRequestDispatcher(req.getContextPath()+"/register.jsp").forward(req,resp);

    }

}
