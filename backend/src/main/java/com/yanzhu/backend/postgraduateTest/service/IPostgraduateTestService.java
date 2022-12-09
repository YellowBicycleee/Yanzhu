package com.yanzhu.backend.postgraduateTest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanzhu.backend.postgraduateTest.entity.PostgraduateTest;

import java.util.Map;

public interface IPostgraduateTestService extends IService<PostgraduateTest> {
    public Map<String, Object> queryInformationByCSDY(String cname, String sname, String dname, int year);
    public Map<String, Object> queryInformationByCSD(String cname, String sname, String dname);
    public Map<String, Object> queryInformationByCSY(String cname, String sname, int year);
}
