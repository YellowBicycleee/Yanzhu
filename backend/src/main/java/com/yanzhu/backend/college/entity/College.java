package com.yanzhu.backend.college.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_college")
public class College {
    @TableId("cname")
    private String cname;   // college name
    private String sname;   // school name
    //private String dname;   // department name
    private String city;    // city
    private boolean is985;
    private boolean is211;
    private String url;
}
