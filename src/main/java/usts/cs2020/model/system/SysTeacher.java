package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

/**
 * <p>
 * 用户角色
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Data
@TableName("sys_teacher")
public class SysTeacher extends BaseEntity {
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 研究方向
     */
    @TableField("research_direction")
    private String researchDirection;

    /**
     * 职位
     */
    @TableField("position")
    private String position;
}
