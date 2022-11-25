package com.yanzhu.backend.user.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhu.backend.user.entity.User;
import com.yanzhu.backend.user.mapper.UserMapper;
import com.yanzhu.backend.user.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    // @ApiOperation(value = "登录验证", notes = "账户密码必须对应")
    @RequestMapping(value="/loginCheck",method = RequestMethod.POST)
    public String loginCheck(String account, String password){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            User user=userService.loginCheck(account,password);
            if(user!=null){
                map.put("status","200");
                map.put("data",user);
            }
            else {
                map.put("status","500");
                map.put("errorMsg","Fail");
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
    @RequestMapping(value="/regAdd",method = RequestMethod.POST)
    public String regAdd(String account,String password){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            int flag=userService.regAdd(account,password);
            if(flag==1){
                map.put("status","200");
                map.put("data","Success");
            }
            else if(flag==0){
                map.put("status","200");
                map.put("errorMsg","Fail,userName has existed");
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value="/getUser",method = RequestMethod.POST)
    public String getUser(String account){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            User user=userService.getUser(account);
            map.put("status","200");
            if(user!=null){
                map.put("data",user);
            }
            else {
                map.put("errorMsg","Fail,can't find user "+account);
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
    @RequestMapping(value="/resetPass",method = RequestMethod.POST)
    public String resetPass(String account,String oldPassword, String newPassword){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            int flag=userService.resetPass(account,oldPassword,newPassword);
            if(flag==1){
                map.put("status","200");
                map.put("msg","Success");
            }
            else if(flag==0){
                map.put("status","200");
                map.put("errorMsg","Fail,error password");
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
    @RequestMapping(value="/delUser",method = RequestMethod.POST)
    public String delUser(String account){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            int i=userService.delUserByAccount(account);
            if(i==1){
                map.put("status","200");
                map.put("msg","Success");
            }
            else {
                map.put("status","500");
                map.put("errorMsg","Fail,can't find user "+account);
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}
