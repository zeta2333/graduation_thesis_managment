package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-21 5:22 PM
 */
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {
    @TableField("role_name")
    private String roleName;
    @TableField("description")
    private String description;
}
