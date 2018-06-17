package com.zhao.service;

import com.zhao.dao.LoginDao;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-17 14:52
 * @描述
 */
public class LoginService {
    private LoginDao loginDao;
    public  LoginService(){
        loginDao = new LoginDao();
    }

    public String getPwdByName(String name) {
         return loginDao.selectPwdByName(name);
    }
}
