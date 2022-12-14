package com.yanzhu.backend.contest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanzhu.backend.contest.entity.Contest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public interface IContestService extends IService<Contest> {
    Map<String, Object> queryAllContest();
}
