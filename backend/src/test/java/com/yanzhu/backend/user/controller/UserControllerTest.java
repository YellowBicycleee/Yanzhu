package com.yanzhu.backend.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void init(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void loginCheck() throws Exception {
        String response = mvc.perform(MockMvcRequestBuilders.post("/user/loginCheck")
                        .param("account","admin").param("password","password")
                        .characterEncoding(StandardCharsets.UTF_8))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        JSONObject map = (JSONObject) JSON.parse(response);
        String status = map.get("status").toString();
        JSONObject user = map.getJSONObject("data");
        assertEquals("200", status);
        assertNotNull(user);
        assertEquals("admin",user.getString("account"));
        assertEquals("password",user.getString("password"));
    }

    @Test
    public void regAdd_resetPass_delUser() throws Exception {
        //regAdd
        String response = mvc.perform(MockMvcRequestBuilders.post("/user/regAdd")
                        .param("account", "testAccount").param("password", "testPassword")
                        .characterEncoding(StandardCharsets.UTF_8))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        JSONObject map = (JSONObject) JSON.parse(response);
        String status = map.get("status").toString();
        String success = map.getString("data");
        assertEquals("200", status);
        // System.out.println("@@@@@@@@@@@@@" + map.toString());
        assertEquals("Success", success);
        //resetPass
        response = mvc.perform(MockMvcRequestBuilders.post("/user/resetPass")
                        .param("account", "testAccount")
                        .param("oldPassword", "testPassword")
                        .param("newPassword", "newPassword")
                        .characterEncoding(StandardCharsets.UTF_8))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        map = (JSONObject) JSON.parse(response);
        status = map.get("status").toString();
        success = map.getString("msg");
        assertEquals("200", status);
        assertEquals("Success", success);

        //delUser
        response = mvc.perform(MockMvcRequestBuilders.post("/user/delUser")
                        .param("account", "testAccount")
                        .characterEncoding(StandardCharsets.UTF_8))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        map = (JSONObject) JSON.parse(response);
        status = map.get("status").toString();
        assertEquals("200", status);
    }
}
