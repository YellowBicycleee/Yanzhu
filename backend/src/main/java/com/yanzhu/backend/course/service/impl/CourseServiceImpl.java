package com.yanzhu.backend.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanzhu.backend.course.entity.Course;
import com.yanzhu.backend.course.mapper.CourseMapper;
import com.yanzhu.backend.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;

    public Map<String, Object> getCourseByDepartment(String department){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("department", department);
        List<Course> courses = courseMapper.selectList(queryWrapper);
        int total = courses.size();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("courses", courses);
        return map;
    }
}
