package com.yanzhu.backend.postgraduateTest.service;

import com.yanzhu.backend.postgraduateTest.entity.PostgraduateTest;
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
public class IPostgraduateTestServiceTest {
    @Autowired
    IPostgraduateTestService postgraduateTestService;
    // 测试数据
    //insert into t_postgraduate_test values('testCollege', 'testSchool', 'testDepartment', '', 2022, 0,0,0,0,0,'');
    @Test
    public void queryInformationTest(){//(String cname, String sname, String dname, Integer year){
        Map<String,Object> map = postgraduateTestService.queryInformation("testCollege",
                    "testSchool", "testDepartment", 2022); // collegeService.getAllCollege(1);
        Integer total = (Integer) map.get("total");
        assertNotNull(total);
        List<PostgraduateTest> postgraduateTests = (List<PostgraduateTest>) map.get("postgraduateTests");
        assertNotNull(postgraduateTests);
    }

}
