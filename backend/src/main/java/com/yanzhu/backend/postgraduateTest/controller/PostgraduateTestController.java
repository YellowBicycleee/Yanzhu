package com.yanzhu.backend.postgraduateTest.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhu.backend.postgraduateTest.entity.PostgraduateTest;
import com.yanzhu.backend.postgraduateTest.service.IPostgraduateTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yanzhu.backend.util.Constant.DEVELOP_ORIGIN;
import static com.yanzhu.backend.util.Constant.PRODUCE_ORIGIN;

@Api(value = "考研信息接口",tags = "考研信息接口说明")
@CrossOrigin(origins={DEVELOP_ORIGIN, PRODUCE_ORIGIN}, allowCredentials="true")
@RestController
@RequestMapping("/postgraduateTest")
public class PostgraduateTestController {
    @Autowired
    private IPostgraduateTestService postgraduateTestService;
    @ApiOperation(value = "根据学校、学院、系、年份查往年分数线", notes = "查某年，某学校某院系分数线")
    @PostMapping("/CSDY")
    public String queryInformationByCSDY(String cname, String sname, String dname, int year){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = postgraduateTestService.queryInformationByCSDY(cname, sname, dname, year);
            int total = (int) map1.get("total");
            List<PostgraduateTest> postgraduateTests = (List<PostgraduateTest>) map1.get("postgraduateTests");
            if (postgraduateTests != null){
                map.put("status","200");
                map.put("total", total);
                map.put("data", postgraduateTests);
                //System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@" + postgraduateTests);
//                for (PostgraduateTest t: postgraduateTests
//                     ) {
//                    System.out.println("@@@@@@@@@" + t);
//                }
            }else {
                map.put("status","500");
                map.put("errorMsg","Fail");
            }
        } catch (Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
    @ApiOperation(value = "根据学校、学院、系查往年分数线", notes = "查某学校某院系分数线（不含单一年份）")
    @PostMapping("/CSD")
    public String queryInformationByCSD(String cname, String sname, String dname){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = postgraduateTestService.queryInformationByCSD(cname, sname, dname);
            int total = (int) map1.get("total");
            List<PostgraduateTest> postgraduateTests = (List<PostgraduateTest>) map1.get("postgraduateTests");
            if (postgraduateTests != null){
                map.put("status","200");
                map.put("total", total);
                map.put("data", postgraduateTests);
            }else {
                map.put("status","500");
                map.put("errorMsg","Fail");
            }
        } catch (Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
    @ApiOperation(value = "根据学校、学院、年份查往年分数线", notes = "查某年，某学校某院分数线（不含系、专业)")
    @PostMapping("/CSY")
    public String queryInformationByCSY(String cname, String sname, int year){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = postgraduateTestService.queryInformationByCSY(cname, sname, year);
            int total = (int) map1.get("total");
            List<PostgraduateTest> postgraduateTests = (List<PostgraduateTest>) map1.get("postgraduateTests");
            if (postgraduateTests != null){
                map.put("status","200");
                map.put("total", total);
                map.put("data", postgraduateTests);
            }else {
                map.put("status","500");
                map.put("errorMsg","Fail");
            }
        } catch (Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}
