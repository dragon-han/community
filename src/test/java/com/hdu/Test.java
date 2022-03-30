package com.hdu;

import com.hdu.pojo.User;
import com.hdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {
    @Autowired
    private UserService userService;
    @org.junit.jupiter.api.Test
    void test01(){
        User user = userService.getUserById(2);
        System.out.println(user);

    }
}
