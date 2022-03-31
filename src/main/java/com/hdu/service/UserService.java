package com.hdu.service;

import com.hdu.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-03-29 20:52:53
*/
@Service
public interface UserService extends IService<User> {
    Boolean isExsitUserByEmail(@Param("userEmail") String userEmail);

}
