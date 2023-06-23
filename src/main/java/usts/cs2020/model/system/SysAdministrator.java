package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Data
@TableName("sys_administrator")
public class SysAdministrator {
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

}
