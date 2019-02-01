package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(filterName = "URLFilter",urlPatterns = "/*")
public class URLFilter extends HttpServlet implements Filter{//记得集成和声明
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(true);

        String username= (String) session.getAttribute("username");//获取登录时存放的session
        System.out.print(username+"::::");
        if (username== null) {
            String location = "/login.jsp";//定义当访客非法访问不被允许的地址时跳转的界面
            request.getRequestDispatcher(location).forward(request, response);//跳转至指定界面
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
}
