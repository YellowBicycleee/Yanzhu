package com.yanzhu.backend.course.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhu.backend.course.entity.Course;
import com.yanzhu.backend.course.service.ICourseService;
import net.sf.jsqlparser.statement.select.ExceptOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yanzhu.backend.util.Constant.DEVELOP_ORIGIN;
import static com.yanzhu.backend.util.Constant.PRODUCE_ORIGIN;

@RestController
@CrossOrigin(origins={DEVELOP_ORIGIN, PRODUCE_ORIGIN}, allowCredentials="true")
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    //@PostMapping ("/getCourseByDepartment")
    @GetMapping("/{department}")
    public String getCourseByDepartment(@PathVariable("department") String department){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = courseService.getCourseByDepartment(department);
            int total = (int) map1.get("total");
            List<Course> courses =(List<Course>) map1.get("courses");
            if (courses != null){
                map.put("status", "200");
                map.put("total", total);
                map.put("data", courses);
            }
            else{
                map.put("status", "500");
                map.put("errorMsg", "Fail");
            }

        }catch (Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}
