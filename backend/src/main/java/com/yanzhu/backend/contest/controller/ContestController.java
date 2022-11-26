package com.yanzhu.backend.contest.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhu.backend.contest.entity.Contest;
import com.yanzhu.backend.contest.service.IContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contest")
public class ContestController {
    @Autowired
    private IContestService contestService;
    @GetMapping("/all")
    public String queryAllContest(){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Map<String, Object> map1 = contestService.queryAllContest();
            int total = (int) map1.get("total");
            List<Contest> contests = (List<Contest>) map1.get("contests");

            if (contests != null){
                map.put("status", "200");
                map.put("total", total);
                map.put("data", contests);
            } else {
                map.put("status", "500");
                map.put("errorMsg", "Fail");
            }

        } catch (Exception ex){
            map.put("status", "500");
            map.put("errorMsg", "Error: " + ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}
