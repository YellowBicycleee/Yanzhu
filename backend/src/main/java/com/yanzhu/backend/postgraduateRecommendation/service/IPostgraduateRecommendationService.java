package com.yanzhu.backend.postgraduateRecommendation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanzhu.backend.postgraduateRecommendation.entity.PostgraduateRecommendation;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface IPostgraduateRecommendationService extends IService<PostgraduateRecommendation> {
<<<<<<< HEAD
    public Map<String, Object> queryInformationByCSY(String cname, String sname, int year);
=======
    public Map<String, Object> queryInformationByCSY(String cname, String sname, Integer year);
>>>>>>> 3739fd99e7bbe78766a12ae0ef221333d09f7a55
}
