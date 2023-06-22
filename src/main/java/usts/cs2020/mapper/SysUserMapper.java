package usts.cs2020.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import usts.cs2020.model.system.SysUser;

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

}
