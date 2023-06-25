package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

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
public class SysProject extends BaseEntity {
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
     * 课题状态（0：待审核，1：审核通过待选择，2：有人选择）
     */
    @TableField("status")
    private Integer status;


}
