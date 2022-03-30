package com.hdu.service;

import com.hdu.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-03-29 20:52:53
*/
public interface UserService extends IService<User> {
    User getUserById(Integer id);

    Boolean userRegisiterByNameAndEmail(String username,String useremail,String userpassword);

}
