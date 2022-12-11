<<<<<<< HEAD
package com.yanzhu.backend.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanzhu.backend.course.entity.Course;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface ICourseService extends IService<Course> {
    public Map<String, Object> getCourseByDepartment(String department);
}
=======
package com.yanzhu.backend.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanzhu.backend.course.entity.Course;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface ICourseService extends IService<Course> {
    public Map<String, Object> getCourseByDepartment(String department);
}
>>>>>>> 3739fd99e7bbe78766a12ae0ef221333d09f7a55
