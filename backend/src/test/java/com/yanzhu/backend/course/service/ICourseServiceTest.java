package com.yanzhu.backend.course.service;

import com.yanzhu.backend.contest.entity.Contest;
import com.yanzhu.backend.contest.service.IContestService;
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
public class ICourseServiceTest {
    @Autowired
    ICourseService courseService;
    @Test
    public void getCourseByDepartmentTest(){

        Map<String,Object> map = courseService.getCourseByDepartment("计算机类");
        Integer total = (Integer) map.get("total");
        List<Contest> postgraduateTests = (List<Contest>) map.get("courses");
        assertNotNull(postgraduateTests);

    }
}
