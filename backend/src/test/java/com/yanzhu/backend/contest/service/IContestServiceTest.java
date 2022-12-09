package com.yanzhu.backend.contest.service;


import com.yanzhu.backend.contest.entity.Contest;
import com.yanzhu.backend.contest.service.IContestService;
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
public class IContestServiceTest {
    @Autowired
    IContestService contestService;
    @Test
    public void queryAllContestTest(){

        Map<String,Object> map = contestService.queryAllContest();
        Integer total = (Integer) map.get("total");
        List<Contest> postgraduateTests = (List<Contest>) map.get("contests");
        assertNotNull(postgraduateTests);

    }
}
