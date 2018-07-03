package com.zhao.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-18 17:27
 * @描述
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    private int count =0;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //禁用缓存
        //Date date = new Date();
        //response.setHeader("Cache-Control", "public");
        //response.setHeader("Pragma", "Pragma");
        //response.setDateHeader("Expires", date.getTime()+1000*60);
        //response.setDateHeader("Last-Modified",date.getTime());

        response.getWriter().println("document.getElementById(\"nameSpan\").innerHTML= "+(count++)+";");
    }
}