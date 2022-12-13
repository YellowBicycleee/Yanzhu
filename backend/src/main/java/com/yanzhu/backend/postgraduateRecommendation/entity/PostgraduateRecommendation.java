package com.yanzhu.backend.postgraduateRecommendation.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_postgraduate_recommendation")
public class PostgraduateRecommendation {
    private String cname;
    private String sname;
    private int rate;
    @TableField("_year")
    private int year;
    // private String date;
    @TableField("instructor")
    private String date;  // 删除导师信息
    private String uri;
    // private String info;
}
