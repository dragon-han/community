package com.hdu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hdu.mapper.UserMapper;
import com.hdu.pojo.User;
import com.hdu.service.impl.UserServiceImpl;
import com.hdu.vo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;

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
     * 用户登录
     * */
    @RequestMapping("/login")
    public Result login(@RequestBody User user){

        User one = userService.getOne(new QueryWrapper<User>()
                .eq("user_email", user.getUserEmail())
                .eq("user_password", user.getUserPassword()));
        if(one!=null){
           return Result.success("登录成功","");
        }
        else
            return Result.error("登录失败","");

    }

    /**
     *注册用户
     * */
    @RequestMapping("/register")
    public Result userRegisiter(@Param("userName") String userName,@Param("userPassword") String userPassword,@Param("userEmail") String userEmail){

        if(userService.isExsitUserByEmail(userEmail)){
            //存在该账户，注册失败
            return Result.error("该用户已存在！","");
        }
        else
        {
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setUserEmail(userEmail);
            userService.save(user);
            return Result.success("注册成功！","");
        }
    }
    /**
     * 用户根据邮箱，修改密码
     * */
    @RequestMapping("/update")
    public Result updateUserPassword(@Param("userEmail") String userEmail,@Param("userNewPassword") String userNewPassword){
        if(!userService.isExsitUserByEmail(userEmail))
        {
            //用户不存在，修改失败
            return Result.error("用户不存在，修改失败","");

        }
        else
        {
            User user = userMapper.selectOneByUserEmail(userEmail);
            user.setUserPassword(userNewPassword);
            userService.updateById(user);
            return Result.success("密码修改成功","");
        }
    }
    /**
     * 删除用户信息
     * @Param("userEmail")
     * @Param("userPassword")
     * */
    @RequestMapping("/delete")
    public Result deleteUser(@Param("userEmail") String userEmail,@Param("userPassword") String userPassword){
        if (!userService.isExsitUserByEmail(userEmail)){
            return Result.error("该用户不存在，注销错误","");
        }else{
            User user = userMapper.selectOneByUserEmail(userEmail);
            userService.removeById(user);
            return Result.success("注销成功","");
        }

    }



}
