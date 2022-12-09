package com.yanzhu.backend.postgraduateRecommendation.service;

import com.yanzhu.backend.postgraduateRecommendation.entity.PostgraduateRecommendation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@RunWith(SpringRunner.class)
@SpringBootTest
public class IPostgraduateRecommendationServiceTest {
    @Autowired
    IPostgraduateRecommendationService postgraduateRecommendationService;
    // 测试数据 testCollege testSchool, 2022
    @Test
    public void queryInformationByCSYTest(){
        Map<String,Object> map = postgraduateRecommendationService.queryInformationByCSY("testCollege",
                "testSchool",  2022); // collegeService.getAllCollege(1);
        Integer total = (Integer) map.get("total");
        List<PostgraduateRecommendation> postgraduateTests = (List<PostgraduateRecommendation>) map.get("postgraduateRecommendation");
        assertNotNull(postgraduateTests);
    }
}
