<<<<<<< HEAD
package com.yanzhu.backend.postgraduateTest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_postgraduate_test")
public class PostgraduateTest {
    // 科目  政治/管综 外国语 业务课1 业务课2
    private String cname;
    private String sname;
    private String dname;
    private String drank;   // 学科评估等级
    int year;               // 年份
    // private String class1Name;
    private int class1Grade;
    // private String class2Name;
    private int class2Grade;
   // private String class3Name;
    private int class3Grade;
    // private String class4Name;
    private int class4Grade;
    private int total;
    private String info;
    // private String interview;
}
=======
package com.yanzhu.backend.postgraduateTest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_postgraduate_test")
public class PostgraduateTest {
    // 科目  政治/管综 外国语 业务课1 业务课2
    private String cname;
    private String sname;
    private String dname;
    private String drank;   // 学科评估等级
    int year;               // 年份
    // private String class1Name;
    private int class1Grade;
    // private String class2Name;
    private int class2Grade;
   // private String class3Name;
    private int class3Grade;
    // private String class4Name;
    private int class4Grade;
    private int total;
    private String info;
    // private String interview;
}
>>>>>>> 3739fd99e7bbe78766a12ae0ef221333d09f7a55
