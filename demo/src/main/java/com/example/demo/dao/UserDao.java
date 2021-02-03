package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper       //标识这个类是一个数据访问层的bean，由spring容器管理
@Repository   //将这个mapper的bean注册到spring容器，不加也行
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryUser();

    /**
     * 根据用户Id查询用户
     * @param userId
     * @return
     */
    User queryUserById(int userId);

    /**
     * 增加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteUser(int userId);

}
