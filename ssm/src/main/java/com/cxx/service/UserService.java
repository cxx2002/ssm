package com.cxx.service;

import com.cxx.pojo.User;

import java.util.List;

/**
 * @author 陈喜喜
 * @date 2022-08-02 21:31
 */
public interface UserService {
    /**
     * url: /user/ selectUserPage?userName=z&userSex=男&page=null
     */
    List<User> selectUserPage(String userName, String userSex, int startRow);
    /**
     * url /user/createUser
     */
    int createUser(User user);
    /**
     * url /user/deleteUserById?userId=15968162087363060
     */
    int deleteUserById(String userId);
    /**
     * url /user/getRowCount?userName=&userSex=男
     */
    int getRowCount(String userName, String userSex);

}
