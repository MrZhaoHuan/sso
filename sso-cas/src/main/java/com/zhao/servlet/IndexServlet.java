package com.zhao.servlet;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-18 11:07
 * @描述  获取cas登录的用户名
 */
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out  = response.getWriter();
        if(null!=assertion.getPrincipal()) {
            out.println("欢迎您：" + assertion.getPrincipal().getName());
        }
        out.println("<br>");
        if(null!=request.getUserPrincipal() && request.getUserPrincipal() instanceof AttributePrincipal ){
            out.println("欢迎您：" + ((AttributePrincipal) request.getUserPrincipal()).getName());
        }
    }
}