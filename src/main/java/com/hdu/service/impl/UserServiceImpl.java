package com.hdu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.pojo.User;
import com.hdu.service.UserService;
import com.hdu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-03-29 20:52:53
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private  UserService userService;
    public User getUserById(Integer id){
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public Boolean userRegisiterByNameAndEmail(String username, String useremail, String userpassword) {

    }
}




