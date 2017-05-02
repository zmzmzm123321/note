package cn.tedu.note.web;

import cn.tedu.note.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by TM on 2017-4-18.
 */
@Component("accessInterceptor")
public class AccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        //查询session中是否保存了登录用户信息
        //如果没有登录，返回一个JSON，包含“需要登录”的消息
        //如果已经登录，则通过返回true。
        User user = (User) req.getSession().getAttribute("loginUser");
        System.out.println("user:" + user);
        if (user == null) {
            String json = "{\"state\":1,message:\"需要登录\"}";
            res.setContentType("text/html;charset=utf-8");
            res.getWriter().print(json);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
