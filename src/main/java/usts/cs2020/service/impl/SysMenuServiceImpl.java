package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import usts.cs2020.mapper.SysMenuMapper;
import usts.cs2020.model.system.MetaVo;
import usts.cs2020.model.system.RouterVo;
import usts.cs2020.model.system.SysMenu;
import usts.cs2020.service.SysMenuService;
import usts.cs2020.utils.menu.MenuHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-24
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    // 获取用户菜单
    @Override
    public List<RouterVo> findUserMenuList(Long userId) {
        List<SysMenu> menuList = baseMapper.findListByUserId(userId);
        // 构建树形菜单
        List<SysMenu> menuListTree = MenuHelper.buildTree(menuList);
        return buildRouter(menuListTree);
    }

    /**
     * 根据菜单构建路由
     *
     * @param menuList
     * @return
     */
    private List<RouterVo> buildRouter(List<SysMenu> menuList) {
        // 创建最终返回的路由
        List<RouterVo> routers = new LinkedList<>();
        for (SysMenu menu : menuList) {
            RouterVo router = new RouterVo();
            router.setHidden(false);
            router.setAlwaysShow(false);
            router.setPath(getRouterPath(menu));
            router.setComponent(menu.getComponent());
            router.setMeta(new MetaVo(menu.getName(), menu.getIcon()));
            List<SysMenu> children = menu.getChildren();
            // 如果当前是菜单，需将按钮对应的路由加载出来，如：“角色授权”按钮对应的路由在“系统管理”下面
            if (menu.getType() == 1) {
                List<SysMenu> hiddenMenuList = children
                        .stream()
                        .filter(item -> !StringUtils.isEmpty(item.getComponent()))
                        .collect(Collectors.toList());
                for (SysMenu hiddenMenu : hiddenMenuList) {
                    RouterVo hiddenRouter = new RouterVo();
                    hiddenRouter.setHidden(true);
                    hiddenRouter.setAlwaysShow(false);
                    hiddenRouter.setPath(getRouterPath(hiddenMenu));
                    hiddenRouter.setComponent(hiddenMenu.getComponent());
                    hiddenRouter.setMeta(new MetaVo(hiddenMenu.getName(), hiddenMenu.getIcon()));
                    routers.add(hiddenRouter);
                }
            } else {
                if (!CollectionUtils.isEmpty(children)) {
                    router.setAlwaysShow(true);
                    // 递归
                    router.setChildren(buildRouter(children));
                }
            }
            routers.add(router);
        }
        return routers;
    }

    /**
     * 获取路由地址
     *
     * @param menu
     * @return
     */
    public String getRouterPath(SysMenu menu) {
        return (menu.getParentId() == 0 ? "/" : "") + menu.getPath();
    }
}
