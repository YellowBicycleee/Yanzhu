package com.yanzhu.backend.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("t_user")
public class User { //implements Serializable {

    //private static final long serialVersionUID = 7170208165661686035L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String account;
    private String password;
}