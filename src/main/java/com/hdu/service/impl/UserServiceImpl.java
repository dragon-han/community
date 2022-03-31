package com.hdu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.pojo.User;
import com.hdu.service.UserService;
import com.hdu.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    /**
     * 根据email查看用户是否存在
     * */
    public Boolean isExsitUserByEmail(@Param("userEmail") String userEmail){
        User user = userMapper.selectOneByUserEmail(userEmail);
        if (user==null)
            return Boolean.FALSE;
        return Boolean.TRUE;
    }



}




