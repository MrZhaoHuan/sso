package com.zhao.web.filter;

import com.zhao.pojo.User;
import com.zhao.utils.CookieUtil;
import com.zhao.utils.DbUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-17 14:45
 * @描述  登录过滤器
 */
public class LoginFilter  implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    @SuppressWarnings("all")
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req  = (HttpServletRequest) request;
        HttpServletResponse resp  = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        String sendRedirectPage = "";
        try{
            if(null==session.getAttribute("user")){
                //没有登录情况下,解析cookie
                User loginUser = CookieUtil.getLoginCookie(req);
                if(null==loginUser){
                    //没登录
                    if(!isLoginReq(req)){
                        sendRedirectPage = "/login.jsp";
                        return;
                    }
                }else{
                    //自动登录
                    String dbPwd = DbUser.selectPwdByName(loginUser.getName());
                    if(dbPwd!=null && dbPwd.equals(loginUser.getPwd())){
                        //登录成功
                        session.setAttribute("user",loginUser);
                        if(isLoginReq(req)){
                            sendRedirectPage = "/index.jsp";
                            return;
                        }
                    }else{
                        //自动登录失败，清除浏览器cookie
                        CookieUtil.clearUserCookie(req,resp);
                        if(!isLoginReq(req)){
                            sendRedirectPage = "/login.jsp";
                            return;
                        }
                    }
                }
            }else{
                //登录情况下,如果请求登录相关资源，则重定向到默认首页
                if(isLoginReq(req)){
                    sendRedirectPage = "/index.jsp";
                    return;
                }
            }
        }finally {
            if(!sendRedirectPage.equals("")){
                resp.sendRedirect(req.getContextPath()+sendRedirectPage);
            }
        }

        chain.doFilter(request,response);
    }

    private boolean isLoginReq(HttpServletRequest request){
        String servletPath = request.getServletPath();
        if(servletPath.equals("/login") || servletPath.equals("/login.jsp")){
            return  true;
        }
        return  false;
    }
    @Override
    public void destroy() {

    }
}