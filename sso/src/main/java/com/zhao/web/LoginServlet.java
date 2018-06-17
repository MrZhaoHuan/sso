package com.zhao.web;

import com.zhao.pojo.User;
import com.zhao.service.LoginService;
import com.zhao.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-17 14:41
 * @描述  有相同父级域名(.com .net等顶级域名除外)情况下的单点登录
 */
public class LoginServlet  extends HttpServlet{
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            //客户端参数
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            String isAutoLogin = req.getParameter("isAutoLogin");

            String dbPwd = loginService.getPwdByName(name);
            if(dbPwd==null){
                //用户名不存在
                req.setAttribute("error","用户名"+name+"不存在");
            }else if(!dbPwd.equals(pwd)){
                //密码不正确
                req.setAttribute("name",name);
                req.setAttribute("error","用户名或密码不正确");
           }else{
                //登录成功
                User user = new User(name,pwd);
                session.setAttribute("user",user);
                if(isAutoLogin!=null){
                    //添加cookie
                    CookieUtil.addLoginCookie(req,resp,user);
                }
                //跳到成功页面
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
           }

          req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}