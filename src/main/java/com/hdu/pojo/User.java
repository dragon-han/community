package com.hdu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 用户性别
     */
    private Integer userSex;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户地址
     */
    private String userUrl;

    /**
     * 账户创建时间
     */
    private Date userCreated;

    /**
     * 是否被删除
     */
    private Integer isDeleted;

    /**
     * 用户最近登录时间
     */
    private Date userActivated;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}