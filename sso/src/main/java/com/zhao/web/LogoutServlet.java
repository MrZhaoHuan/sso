package com.zhao.web;

import com.zhao.pojo.User;
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
 * @创建时间 2018-06-17 17:19
 * @描述  注销
 */
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            System.out.println("注销的用户："+user);

            //清除session 和  客户端cookie
             //todo:这样做不到多个子系统同时注销,因为没法清除其他子系统的服务器session或客户端cookie(比如：JSESSIONID)
            session.removeAttribute("user");
            CookieUtil.clearUserCookie(request,response);
    }
}