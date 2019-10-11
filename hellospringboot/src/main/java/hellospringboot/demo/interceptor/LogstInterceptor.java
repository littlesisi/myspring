package hellospringboot.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2019/3/13 0013.
 */
public class LogstInterceptor implements HandlerInterceptor {
    //long start = System.currentTimeMillis();
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //start = System.currentTimeMillis();
        String basePath = httpServletRequest.getContextPath();
        String path = httpServletRequest.getRequestURI();
        if(!doLoginInterceptor(path, basePath) ){//是否进行登陆拦截
            return true;
        }
        if(getCookie(httpServletRequest))
            return true;
        else
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/user/login");


        return true;
    }

    private boolean getCookie(HttpServletRequest httpServletRequest)
    {

        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")){
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("Interceptor cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

    private boolean doLoginInterceptor(String path,String basePath){
        path = path.substring(basePath.length());
        Set<String> notLoginPaths = new HashSet<>();
        notLoginPaths.add("/user/login");
        notLoginPaths.add("/user/register");
        if(notLoginPaths.contains(path))
            return false;
        return true;
    }

}
