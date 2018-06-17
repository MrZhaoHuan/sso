package com.zhao.utils;

import com.zhao.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-17 14:53
 * @描述  数据库的用户信息
 */
public class DbUser{
    private  Map<String,User> userMap = new HashMap<>();
    private static final DbUser DB_USER = new DbUser();

    private DbUser(){
        User xiaoli = new User("xiaoli","123456");
        User root = new User("root","123");
        userMap.put("xiaoli",xiaoli);
        userMap.put("root",root);
    }

     /*
      *@描述  查找用户密码
      **/
    public static String selectPwdByName(String name){
         String dbPwd = null;
         User dbUser = null;
         if( (dbUser=DB_USER.userMap.get(name) )!=null){
               dbPwd = dbUser.getPwd();
         }
         return  dbPwd;
    }

}
