package com.yanzhu.backend.college.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhu.backend.college.entity.College;
import com.yanzhu.backend.college.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private ICollegeService collegeService;

    @GetMapping("all")
    public String queryAllCollege(){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = collegeService.getAllCollege();
            // System.out.println(map1);
            // Long total = (Long) map1.get("total");
            int total = (int)map1.get("total");
            List<College> colleges = (List<College>) map1.get("colleges");
            if (colleges != null){
                map.put("status", "200");
                map.put("total", total);
                map.put("data", colleges);
            }
            else{
                map.put("status", "500");
                map.put("errorMsg", "Fail");
            }
        }catch (Exception ex){
            map.put("status", "500");
            map.put("errorMsg", "Error: " + ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
    @GetMapping("/{province}")
    public String queryCollegeByCity(@PathVariable("province") String city) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = collegeService.getCollegeByCity(city);
            //Long total = (Long) map1.get("total");
            int total = (int) map1.get("total");
            List<College> colleges = (List<College>) map1.get("colleges");
            if (colleges != null){
                map.put("status", "200");
                map.put("total", total);
                map.put("data", colleges);
            }
            else{
                map.put("status", "500");
                map.put("errorMsg", "Fail");
            }
        }catch (Exception ex){
            map.put("status", "500");
            map.put("errorMsg", "Error: " + ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}
