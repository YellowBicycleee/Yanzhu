package com.yanzhu.backend.contest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhu.backend.contest.entity.Contest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContestMapper extends BaseMapper<Contest> {
}
