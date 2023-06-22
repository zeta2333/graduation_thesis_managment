package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-22 10:23 PM
 */
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity {
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("real_name")
    private String realName;
    @TableField("tel")
    private String tel;
    @TableField("gender")
    private String gender;
    @TableField("role_id")
    private Long roleId;
}
