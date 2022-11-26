package com.yanzhu.backend.college.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhu.backend.college.entity.College;
import com.yanzhu.backend.college.service.ICollegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yanzhu.backend.util.Constant.DEVELOP_ORIGIN;
import static com.yanzhu.backend.util.Constant.PRODUCE_ORIGIN;

@Api(value = "学校院系信息获取接口", tags = "学校院系信息获取接口说明")
@CrossOrigin(origins={DEVELOP_ORIGIN, PRODUCE_ORIGIN}, allowCredentials="true")
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private ICollegeService collegeService;

    @GetMapping("all")
    @ApiOperation(value = "返回所有学校")
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
    @ApiOperation(value = "按省份返回学校")
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
