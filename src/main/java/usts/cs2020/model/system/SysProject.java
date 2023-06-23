package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 课题
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Data
@TableName("sys_project")
public class SysProject {
    /**
     * 课题名称
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 所属教师id
     */
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 课题描述
     */
    @TableField("description")
    private String description;

    /**
     * 课题状态（0：无人选择，1：有人选择）
     */
    @TableField("status")
    private Integer status;


}
