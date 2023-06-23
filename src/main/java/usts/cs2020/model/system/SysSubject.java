package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

/**
 * <p>
 * 专业
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Data
@TableName("sys_subject")
public class SysSubject extends BaseEntity {

    /**
     * 专业名称
     */
    @TableField("subject_name")
    private String subjectName;

}
