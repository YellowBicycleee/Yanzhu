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
    protected boolean isEmptyString(String string) {
        if (string == null )
            return true;
        else if (string.trim().isEmpty()){
            return true;
        } else
            return false;
    }
    @Override
    public Map<String, Object> queryInformationByCSY(String cname, String sname, Integer year) {
        Map<String, Object> map = new HashMap<String, Object>();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        //if (sname != null) {
        if (isEmptyString(sname)){
            queryWrapper.eq("sname", sname);
        }
        //if (cname != null) {
        if (isEmptyString(cname)){
            queryWrapper.eq("cname", cname);
        }
        if (year != null) {
            queryWrapper.eq("_year", year);
        }
        //if (cname == null && sname == null &&  year == null){
        if (isEmptyString(sname) && isEmptyString(cname) && year == null){
            queryWrapper.last("limit 2000");
        }
        List<PostgraduateTest> postgraduateTests = postgraduateRecommendationMapper.selectList(queryWrapper);
        int total = postgraduateTests.size();
        map.put("total", total);
        map.put("postgraduateRecommendation", postgraduateTests);
        return map;
    }
}
