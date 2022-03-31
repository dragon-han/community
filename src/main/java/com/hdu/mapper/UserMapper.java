package com.hdu.mapper;

import com.hdu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-03-29 20:52:53
* @Entity com.hdu.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     *
     * 根据邮箱查找
     * */
    User selectOneByUserEmail(@Param("userEmail") String userEmail);
    /**
     * 根据用户名查询
     * */
    User selectOneByUserName(@Param("userName") String userName);
}




