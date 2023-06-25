package usts.cs2020.service;

import com.baomidou.mybatisplus.extension.service.IService;
import usts.cs2020.model.system.RouterVo;
import usts.cs2020.model.system.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-24
 */

public interface SysMenuService extends IService<SysMenu> {
    // 获取用户菜单
    List<RouterVo> findUserMenuList(Long userId);
}
