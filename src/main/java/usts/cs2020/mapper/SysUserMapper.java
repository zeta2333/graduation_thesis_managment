package usts.cs2020.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import usts.cs2020.model.system.SysUser;
import usts.cs2020.model.vo.SysUserQueryVo;
import usts.cs2020.model.vo.SysUserResVo;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Pycro
 * @since 2023-06-22
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    // 条件分页查询
    IPage<SysUserResVo> findPage(Page<SysUser> pageParam, SysUserQueryVo vo);
}
