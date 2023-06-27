package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-23 2:42 PM
 */

@Data
@TableName("sys_student")
public class SysStudent extends BaseEntity {

    @TableField("project_id")
    private Long projectId;

    // 课题状态（0：未选择，1：已选择）
    @TableField("project_status")
    private Integer projectStatus;

    @TableField("project_score")
    private Integer projectScore;

    @TableField("user_id")
    private Long userId;

    @TableField("teacher_id")
    private Long teacherId;

    @TableField("subject_id")
    private Long subjectId;
}
