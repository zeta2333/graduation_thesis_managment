package usts.cs2020.mapper;

import org.apache.ibatis.annotations.Mapper;
import usts.cs2020.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author Pycro
 * @since 2023-06-24
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}
