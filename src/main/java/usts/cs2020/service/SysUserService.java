package usts.cs2020.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import usts.cs2020.model.system.SysUser;
import usts.cs2020.model.vo.query.SysUserQueryVo;
import usts.cs2020.model.vo.result.SysUserResVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-22
 */
public interface SysUserService extends IService<SysUser> {

    // 条件分页查询
    IPage<SysUserResVo> queryPageList(Page<SysUser> pageParam, SysUserQueryVo vo);
}
