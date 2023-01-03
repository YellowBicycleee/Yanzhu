package com.yanzhu.backend.user.service;

import com.yanzhu.backend.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.yanzhu.backend.user.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserServiceTest {
    @Autowired
    IUserService userService;

    @Test
    public void loginCheck() {
        User admin = userService.loginCheck("admin", "password");
        assertNotNull(admin);
    }

    @Test
    public void regAdd() {
        int i = userService.regAdd("testAccount", "testPassword");
        assertEquals(1,i);
        i = userService.regAdd("testAccount", "testPassword");
        assertEquals(0,i);
        i = userService.delUserByAccount("testAccount");
        assertEquals(1,i);
        i = userService.delUserByAccount("unExistUser");
        assertEquals(0,i);
    }


    @Test
    public void resetPass() {
        int i = userService.resetPass("admin","password","newPassword");
        assertEquals(1,i);
        i = userService.resetPass("admin","newPassword","password");
        assertEquals(1,i);
        i = userService.resetPass("unExistUser","password","newPassword");
        assertEquals(0,i);
    }
}