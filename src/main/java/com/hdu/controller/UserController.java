package com.hdu.controller;


import com.hdu.pojo.User;
import com.hdu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        System.out.println(user);
        return user;
    }

    /**
     *
     * */
    public void userRegisiter(String username,String useremail,String userpassword){

    }


}
