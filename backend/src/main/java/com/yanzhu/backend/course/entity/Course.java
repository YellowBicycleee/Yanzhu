package com.yanzhu.backend.course.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_course")
public class Course {
    String department;      // 专业大类
    String course;          // 专业课
}
