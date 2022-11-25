package com.yanzhu.backend.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanzhu.backend.user.entity.User;

public interface IUserService extends IService<User> {
    // 登录验证
    User loginCheck(String account, String password);
    // 注册用户
    int regAdd(String account, String password);
    // 获取用户
    User getUser(String account);
    // 重置密码
    int resetPass(String account, String oldPassword, String newPassword);
    // 删除用户
    int delUserByAccount(String account);

}