package filter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*")
public class EncodingFilter implements  Filter{

    public void init(FilterConfig filterConfig) throws  ServletException{

    }

    public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)throws IOException,ServletException{
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(new MyRequest(request),response);
    }

}

class MyRequest extends HttpServletRequestWrapper{
    private  HttpServletRequest req;
    private  boolean flag = true;

    public  MyRequest(HttpServletRequest req){
        super(req);
        this.req = req;
    }

    @Override
    public String getParameter(String name){
        if(name==null || name.trim().length()==0){
            return null;
        }
        String[] values = getParameterValues(name);
        if(values==null || values.length==0){
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name){
        if(name==null || name.trim().length()==0){
            return null;
        }
        Map<String,String[]> map = getParameterMap();
        if(map==null || map.size()==0){
            return null;
        }
        return map.get(name);
    }

    @Override
    public Map<String,String[]> getParameterMap() {

        /**
         * 首先判断请求方式
         * 若为post  request.setchar...(utf-8)
         * 若为get 将map中的值遍历编码就可以了
         */
        String method = req.getMethod();
        if("post".equalsIgnoreCase(method)){
            try {
                req.setCharacterEncoding("utf-8");
                return req.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if("get".equalsIgnoreCase(method)){
            Map<String,String[]> map = req.getParameterMap();
            if(flag){
                for (String key:map.keySet()) {
                    String[] arr = map.get(key);
                    for(int i=0;i<arr.length;i++){
                        try {
                            arr[i]=new String(arr[i].getBytes("iso8859-1"),"utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                flag=false;
            }
            return map;
        }
        return super.getParameterMap();
    }
























}
