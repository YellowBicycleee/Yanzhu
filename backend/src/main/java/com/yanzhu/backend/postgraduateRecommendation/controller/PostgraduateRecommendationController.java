package com.yanzhu.backend.postgraduateRecommendation.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhu.backend.postgraduateRecommendation.service.IPostgraduateRecommendationService;
import com.yanzhu.backend.postgraduateTest.entity.PostgraduateTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yanzhu.backend.util.Constant.DEVELOP_ORIGIN;
import static com.yanzhu.backend.util.Constant.PRODUCE_ORIGIN;

@Api(value = "学校保送信息获取接口", tags = "学校保送信息获取接口说明")
@CrossOrigin(origins={DEVELOP_ORIGIN, PRODUCE_ORIGIN}, allowCredentials="true")
@RestController
@RequestMapping("/postgraduateRecommendation")
public class PostgraduateRecommendationController {
    @Autowired
    private IPostgraduateRecommendationService postgraduateRecommendationService;

    @ApiOperation(value = "根据学校、学院、年份查保研政策", notes = "根据学校、学院、年份查询保研政策")
    @PostMapping("/CSY")
    public String queryInformationByCSD(String cname, String sname, int year){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = postgraduateRecommendationService.queryInformationByCSY(cname, sname, year);
            int total = (int) map1.get("total");
            List<PostgraduateTest> postgraduateTests = (List<PostgraduateTest>) map1.get("postgraduateRecommendation");
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
