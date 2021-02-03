package com.example.demo.dao;

import com.example.demo.entity.User;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class UserDaoTest {

    //通过spring容器注入Dao的实现类
    @Autowired
    private UserDao userDao;

    @Test
    //@Ignore
    public void testAQueryUser() {
        List<User> userList = userDao.queryUser();
        // 验证预期值和实际值是否相符
        assertEquals(2, userList.size());
    }


    @Test
    //@Ignore
    public void testCQueryUserById() {
        User user = userDao.queryUserById(1);
        assertEquals("admin", user.getUserName());
    }

    @Test
    //@Ignore
    public void testBInsertUser() {
        //创建一个用户对象
        User user = new User();
        user.setUserName("测试用户");
        user.setAge(20);
        //将该对象实例添加入库
        int effectedNum = userDao.insertUser(user);
        //检测影响行数
        assertEquals(1, effectedNum);
        //校验总数是否+1
        List<User> userList = userDao.queryUser();
        assertEquals(3, userList.size());
    }

    @Test
    //@Ignore
    public void testDUpateUser() {
        List<User> userList = userDao.queryUser();
        for (User user : userList) {
            if ("测试用户".equals(user.getUserName())) {
                // 对比之前的age值
                assertEquals(20, user.getAge().intValue());
                user.setAge(24);
                int effectedNum = userDao.updateUser(user);
                assertEquals(1, effectedNum);
            }
        }
    }

    @Test
    //@Ignore
    public void testEDeleteUser() {
        List<User> userList = userDao.queryUser();
        for (User user : userList) {
            if ("测试用户".equals(user.getUserName())) {
                int effectedNum = userDao.deleteUser(user.getUserId());
                assertEquals(1, effectedNum);
            }
        }
        // 重新获取一次列表，看看总数是否少1
        userList = userDao.queryUser();
        assertEquals(2, userList.size());
    }
}
