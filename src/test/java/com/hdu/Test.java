package com.hdu;

import com.hdu.mapper.UserMapper;
import com.hdu.pojo.User;
import com.hdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @org.junit.jupiter.api.Test
    void test01(){
//        User user = userMapper.selectById(2);
//        System.out.println(user);
//        User user1 = userMapper.selectOneByUserEmail("hhhhhh");
//        System.out.println(user1);
        Boolean resuly = userService.isExsitUserByEmail("hhhhhh");
        Boolean result2 = userService.isExsitUserByEmail("2222222");
        System.out.println(resuly+"------"+result2);
    }



}
