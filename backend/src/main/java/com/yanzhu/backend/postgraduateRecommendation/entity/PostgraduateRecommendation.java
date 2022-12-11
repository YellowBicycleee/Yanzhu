<<<<<<< HEAD
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
    private String instructor;
    private String uri;
    // private String info;
}
=======
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
    private String instructor;
    private String uri;
    // private String info;
}
>>>>>>> 3739fd99e7bbe78766a12ae0ef221333d09f7a55
