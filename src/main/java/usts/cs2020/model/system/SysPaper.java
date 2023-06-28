package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

/**
 * <p>
 * 论文
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Data
@TableName("sys_paper")
public class SysPaper extends BaseEntity {

    /**
     * 论文标题
     */
    @TableField("paper_title")
    private String paperTitle = "";

    /**
     * 论文路径
     */
    @TableField("paper_path")
    private String paperPath = "";

    /**
     * 作者id
     */
    @TableField("student_id")
    private Long studentId;

    /**
     * 论文状态（1：开题报告，2：期中小结，3：论文初稿）
     */
    @TableField("paper_status")
    private Integer paperStatus = 0;


}
