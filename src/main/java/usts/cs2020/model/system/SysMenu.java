package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author Pycro
 * @since 2023-06-24
 */
@Data
@TableName("sys_menu")
public class SysMenu extends BaseEntity {


    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 路由地址
     */
    @TableField("path")
    private String path;

    /**
     * 组件路径
     */
    @TableField("component")
    private String component;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 排序
     */
    @TableField("sort_value")
    private Integer sortValue;


}
