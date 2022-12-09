package com.yanzhu.backend.postgraduateRecommendation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanzhu.backend.postgraduateRecommendation.entity.PostgraduateRecommendation;
import com.yanzhu.backend.postgraduateRecommendation.mapper.PostgraduateRecommendationMapper;
import com.yanzhu.backend.postgraduateRecommendation.service.IPostgraduateRecommendationService;
import com.yanzhu.backend.postgraduateTest.entity.PostgraduateTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostgraduateRecommendationServiceImpl extends ServiceImpl<PostgraduateRecommendationMapper, PostgraduateRecommendation>
    implements IPostgraduateRecommendationService {
    @Autowired
    private PostgraduateRecommendationMapper postgraduateRecommendationMapper;
    @Override
    public Map<String, Object> queryInformationByCSY(String cname, String sname, int year) {
        Map<String, Object> map = new HashMap<String, Object>();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sname", sname);
        queryWrapper.eq("cname", cname);
        queryWrapper.eq("_year", year);
        List<PostgraduateTest> postgraduateTests = postgraduateRecommendationMapper.selectList(queryWrapper);
        int total = postgraduateTests.size();
        map.put("total", total);
        map.put("postgraduateRecommendation", postgraduateTests);
        return map;
    }
}
