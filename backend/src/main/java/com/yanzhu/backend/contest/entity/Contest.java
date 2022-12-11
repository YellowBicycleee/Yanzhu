<<<<<<< HEAD
package com.yanzhu.backend.contest.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_contest")
@Data
public class Contest {
    private String name;    // 竞赛名称
    @TableField("number")
    private int rank1;       // 推荐指数
}
=======
package com.yanzhu.backend.contest.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_contest")
@Data
public class Contest {
    private String name;    // 竞赛名称
    @TableField("number")
    private int rank1;       // 推荐指数
}
>>>>>>> 3739fd99e7bbe78766a12ae0ef221333d09f7a55
