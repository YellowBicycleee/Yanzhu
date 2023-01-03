package com.yanzhu.backend.postgraduateTest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanzhu.backend.postgraduateTest.entity.PostgraduateTest;
import com.yanzhu.backend.postgraduateTest.mapper.PostgraduateTestMapper;
import com.yanzhu.backend.postgraduateTest.service.IPostgraduateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostgraduateTestServiceImpl extends ServiceImpl<PostgraduateTestMapper, PostgraduateTest>
        implements IPostgraduateTestService {

    @Autowired
    private PostgraduateTestMapper postgraduateTestMapper;
    protected boolean isEmptyString(String string) {
        if (string == null )
            return true;
        else if (string.trim().isEmpty()){
            return true;
        } else
            return false;
    }
    @Override
    public Map<String, Object> queryInformation(String cname, String sname, String dname, Integer year) {
        Map<String, Object> map = new HashMap<String, Object>();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        if (!isEmptyString(sname)) {
            queryWrapper.eq("sname", sname);
        }
        if (!isEmptyString(cname)) {
            queryWrapper.eq("cname", cname);
        }

        if (!isEmptyString(dname)){
            queryWrapper.eq("dname", dname);
        }

        if (year != null) {
            try {
                int __year = year.intValue();
                queryWrapper.eq("year", year);
            }
            catch (Exception ex){}  // 不是整形，什么也不做
        }
        //if (cname == null && sname == null && dname == null && year == null){
        if (isEmptyString(sname) && isEmptyString(cname) && isEmptyString(dname)){
            queryWrapper.last("limit 2000");
        }
        List<PostgraduateTest> postgraduateTests = postgraduateTestMapper.selectList(queryWrapper);
        int total = postgraduateTests.size();
        map.put("total", total);
        map.put("postgraduateTests", postgraduateTests);
        return map;
    }
}
