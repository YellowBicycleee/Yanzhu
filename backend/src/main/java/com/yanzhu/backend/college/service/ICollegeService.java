package com.yanzhu.backend.college.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanzhu.backend.college.entity.College;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ICollegeService extends IService<College> {
    Map<String, Object> getAllCollege();
    Map<String, Object> getCollegeByCity(String city);
}
