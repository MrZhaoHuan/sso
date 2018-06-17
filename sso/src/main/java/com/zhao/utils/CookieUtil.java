package com.zhao.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zhao.pojo.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-17 15:56
 * @描述
 */
public class CookieUtil {
    private static String userCookieKey = "user";

    public static  void addLoginCookie(HttpServletRequest req,HttpServletResponse response,User user){
         addLoginCookie(req,response,user,3600*24*7); //一周
    }

    //添加cookie
    private static  void addLoginCookie(HttpServletRequest req,HttpServletResponse response,User user,int cookieAge){
        Cookie cookie = new Cookie(userCookieKey,user==null?"":JSONObject.toJSONString(user));
        cookie.setPath("/");
        System.out.println(req.getLocalName().substring(req.getLocalName().indexOf(".") + 1, req.getLocalName().length()));
        cookie.setDomain(req.getLocalName().substring(req.getLocalName().indexOf(".") + 1, req.getLocalName().length()));
        cookie.setMaxAge(cookieAge);
        response.addCookie(cookie);
    }

    //清空登录cookie
    public static  void clearUserCookie(HttpServletRequest req,HttpServletResponse response){
        addLoginCookie(req,response,null,0);
    }

    //查找cookie
    public static User getLoginCookie(HttpServletRequest req){
         User user = null;
         Cookie[] cookies = req.getCookies();
        if(null!=cookies){
            for(Cookie c:cookies){
                if(c.getName().equals(userCookieKey)){
                    user = JSONObject.parseObject(c.getValue(),new TypeReference<User>(){});
                    break;
                }
            }
        }
        return  user;
    }

}
