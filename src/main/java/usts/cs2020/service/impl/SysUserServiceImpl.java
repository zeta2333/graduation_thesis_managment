package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cs2020.mapper.SysUserMapper;
import usts.cs2020.model.system.RouterVo;
import usts.cs2020.model.system.SysUser;
import usts.cs2020.model.vo.query.SysUserQueryVo;
import usts.cs2020.model.vo.result.SysUserResVo;
import usts.cs2020.service.SysMenuService;
import usts.cs2020.service.SysUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysMenuService menuService;

    // 条件分页查询
    @Override
    public IPage<SysUserResVo> queryPageList(Page<SysUser> pageParam, SysUserQueryVo vo) {
        if (vo != null && vo.getKeyword() != null) {
            vo.setKeyword(vo.getKeyword().trim());
        }
        return baseMapper.findPage(pageParam, vo);
    }

    // 通过用户名查询用户
    @Override
    public SysUser getByUsername(String username) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, username);
        return baseMapper.selectOne(wrapper);
    }

    // 根据username获取用户信息
    @Override
    public Map<String, Object> getUserInfo(String username) {
        Map<String, Object> result = new HashMap<>();
        SysUser user = getByUsername(username);

        // 根据用户id获取菜单
        List<RouterVo> routerVoList = menuService.findUserMenuList(user.getId());

        result.put("name", user.getRealName());
        result.put("avatar", "https://z3.ax1x.com/2021/03/28/cp7SOK.gif");
        // TODO 权限控制
        // 角色判断
        long roleId = user.getRoleId();
        String roleName = null;
        switch ((int) roleId) {
            case 1:
                roleName = "学生";
                break;
            case 2:
                roleName = "教师";
                break;
            case 3:
                roleName = "管理员";
                break;
        }
        result.put("role", roleName);
        result.put("buttons", new ArrayList<>());
        result.put("routers", routerVoList);
        return result;
    }
}
