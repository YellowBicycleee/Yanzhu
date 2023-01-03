package com.yanzhu.backend.contest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanzhu.backend.contest.entity.Contest;
import com.yanzhu.backend.contest.mapper.ContestMapper;
import com.yanzhu.backend.contest.service.IContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ContestServiceImpl extends ServiceImpl<ContestMapper, Contest> implements IContestService {
    @Autowired
    private ContestMapper contestMapper;
    @Override
    public Map<String, Object> queryAllContest() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contest> contests = contestMapper.selectList(null);
        int total = contests.size();
        map.put("total", total);
        map.put("contests", contests);
        //System.out.println("#########################"+contests);
        return map;
    }
}
