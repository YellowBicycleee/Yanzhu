package com.yanzhu.backend.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user")
public class User implements Serializable {


    private static final long serialVersionUID = -4153122506606284443L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String account;
    private String password;
}