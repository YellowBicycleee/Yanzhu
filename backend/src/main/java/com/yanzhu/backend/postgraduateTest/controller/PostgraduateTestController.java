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
    @ApiOperation(value = "查往年分数线", notes = "查往年分数线---汇总版")
    @GetMapping("/all")
    public String queryInformation(@RequestParam(name = "cname", required = false) String cname,
                                   @RequestParam(name = "sname", required = false)String sname,
                                   @RequestParam(name = "dname", required = false)  String dname,
                                   @RequestParam(name = "year", required = false)  Integer year){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = postgraduateTestService.queryInformation(cname, sname, dname, year);
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
        }catch (Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }


}
