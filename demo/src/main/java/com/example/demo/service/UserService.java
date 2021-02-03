package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;


public interface UserService {

    /**
     *
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 根据用户Id获取用户信息
     * @param userId
     * @return
     */
    User getUserById(int userId);

    /**
     * 增加用户信息
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean modifyUser(User user);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    boolean deleteUser(int userId);

}
