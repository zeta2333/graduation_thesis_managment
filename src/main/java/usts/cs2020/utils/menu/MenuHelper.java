package usts.cs2020.utils.menu;

import usts.cs2020.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-25 10:02 AM
 */
public class MenuHelper {
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        // 创建列表，作为最终返回的对象
        List<SysMenu> tree = new ArrayList<>();
        // 遍历所有菜单
        for (SysMenu sysMenu : sysMenuList) {
            // 递归入口
            if (sysMenu.getParentId() == 0) {
                tree.add(getChildren(sysMenu, sysMenuList));
            }
        }
        return tree;
    }

    private static SysMenu getChildren(SysMenu sysMenu, List<SysMenu> sysMenuList) {
        sysMenu.setChildren(new ArrayList<>());
        // 遍历所有菜单，判断每个菜单的parentId和sysMenu的id的关系
        for (SysMenu item : sysMenuList) {
            if (sysMenu.getId().equals(item.getParentId())) {
                sysMenu.getChildren().add(getChildren(item, sysMenuList));
            }
        }
        return sysMenu;
    }
}
