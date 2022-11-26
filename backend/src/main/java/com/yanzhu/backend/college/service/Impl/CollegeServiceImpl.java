package com.yanzhu.backend.college.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanzhu.backend.college.entity.College;
import com.yanzhu.backend.college.mapper.CollegeMapper;
import com.yanzhu.backend.college.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements ICollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public Map<String, Object> getAllCollege() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<College> colleges = collegeMapper.selectList(null);
        //System.out.println(colleges);
        map.put("total", colleges.size());
        map.put("colleges", colleges);
        return map;
    }

    @Override
    public Map<String, Object> getCollegeByCity(String city) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("city", city);
        List<College> colleges = collegeMapper.selectList(queryWrapper);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", colleges.size());
        map.put("colleges", colleges);
        return map;
    }
}
