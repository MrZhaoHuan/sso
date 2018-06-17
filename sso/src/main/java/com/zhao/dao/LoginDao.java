package com.zhao.dao;

import com.zhao.utils.DbUser;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-17 14:52
 * @描述
 */
public class LoginDao {

    public String selectPwdByName(String name) {
       return  DbUser.selectPwdByName(name);
    }
}
