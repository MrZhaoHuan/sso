package com.zhao.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-18 17:04
 * @描述
 */
public class ResouceAddFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        String path = request.getServletPath();
        if(path.equals("/a.html")){
            String realPath = context.getRealPath("a.html");
            System.out.println(realPath );
            FileOutputStream outputStream = new FileOutputStream(new File(realPath));
            outputStream.write("add-content".getBytes());
            outputStream.close();
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
       context  =   config.getServletContext();

    }
    ServletContext context;
}