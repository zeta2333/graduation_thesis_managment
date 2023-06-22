package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import usts.cs2020.mapper.SysUserMapper;
import usts.cs2020.model.system.SysUser;
import usts.cs2020.service.SysUserService;

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

}
