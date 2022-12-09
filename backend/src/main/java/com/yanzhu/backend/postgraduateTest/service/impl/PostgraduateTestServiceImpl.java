package com.yanzhu.backend.postgraduateTest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanzhu.backend.postgraduateTest.entity.PostgraduateTest;
import com.yanzhu.backend.postgraduateTest.mapper.PostgraduateTestMapper;
import com.yanzhu.backend.postgraduateTest.service.IPostgraduateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostgraduateTestServiceImpl extends ServiceImpl<PostgraduateTestMapper, PostgraduateTest>
        implements IPostgraduateTestService {

    @Autowired
    private PostgraduateTestMapper postgraduateTestMapper;
    @Override
    public Map<String, Object> queryInformation(String cname, String sname, String dname, Integer year){
        Map<String, Object> map = new HashMap<String, Object>();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sname", sname);
        queryWrapper.eq("cname", cname);
        if (dname != null) {
            queryWrapper.eq("dname", dname);
        }
        if (year != null) {
            queryWrapper.eq("year", year);
        }
        List<PostgraduateTest> postgraduateTests = postgraduateTestMapper.selectList(queryWrapper);
        int total = postgraduateTests.size();
        map.put("total", total);
        map.put("postgraduateTests", postgraduateTests);
        return map;
    }


//    @Override
//    public Map<String, Object> queryInformationByCSDY(String cname, String sname, String dname, int year){
//        Map<String, Object> map = new HashMap<String, Object>();
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("sname", sname);
//        queryWrapper.eq("cname", cname);
//        queryWrapper.eq("dname", dname);
//        queryWrapper.eq("year", year);
//        List<PostgraduateTest> postgraduateTests = postgraduateTestMapper.selectList(queryWrapper);
//        int total = postgraduateTests.size();
//        map.put("total", total);
//        map.put("postgraduateTests", postgraduateTests);
//        return map;
//    }
//    @Override
//    public Map<String, Object> queryInformationByCSD(String cname, String sname, String dname){
//        Map<String, Object> map = new HashMap<String, Object>();
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("sname", sname);
//        queryWrapper.eq("cname", cname);
//        queryWrapper.eq("dname", dname);
//        List<PostgraduateTest> postgraduateTests = postgraduateTestMapper.selectList(queryWrapper);
//        int total = postgraduateTests.size();
//        map.put("total", total);
//        map.put("postgraduateTests", postgraduateTests);
//        return map;
//    }
//    @Override
//    public Map<String, Object> queryInformationByCSY(String cname, String sname, int year){
//        Map<String, Object> map = new HashMap<String, Object>();
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("sname", sname);
//        queryWrapper.eq("cname", cname);
//        queryWrapper.eq("year", year);
//        List<PostgraduateTest> postgraduateTests = postgraduateTestMapper.selectList(queryWrapper);
//        int total = postgraduateTests.size();
//        map.put("total", total);
//        map.put("postgraduateTests", postgraduateTests);
//        return map;
//    }
}
