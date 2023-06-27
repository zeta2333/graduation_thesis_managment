package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cs2020.mapper.SysTeacherMapper;
import usts.cs2020.mapper.SysUserMapper;
import usts.cs2020.model.system.SysTeacher;
import usts.cs2020.model.system.SysUser;
import usts.cs2020.model.vo.ins_upd.SysTeacherInsUpdVo;
import usts.cs2020.model.vo.query.SysTeacherQueryVo;
import usts.cs2020.model.vo.result.SysTeacherResVo;
import usts.cs2020.service.SysTeacherService;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Service
public class SysTeacherServiceImpl extends ServiceImpl<SysTeacherMapper, SysTeacher> implements SysTeacherService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public IPage<SysTeacherResVo> queryPageList(SysTeacherQueryVo vo, Page<SysTeacher> pageParam) {
        if (vo != null && vo.getKeyword() != null) {
            vo.setKeyword(vo.getKeyword().trim());
        }
        return baseMapper.findPage(pageParam, vo);
    }

    @Override
    public void saveByVo(SysTeacherInsUpdVo vo) {
        // 添加sysUser对象
        SysUser user = new SysUser();
        // 填充属性
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword());
        user.setRealName(vo.getTeacherName());
        user.setTel(vo.getTel());
        user.setGender(vo.getGender());
        user.setRoleId(2L);// 教师角色的roleId为2
        userMapper.insert(user);

        // 添加teacher对象
        SysTeacher teacher = new SysTeacher();
        Long userId = user.getId();
        teacher.setUserId(userId);
        teacher.setResearchDirection(vo.getResearchDirection());
        teacher.setPosition(vo.getPosition());
        baseMapper.insert(teacher);
    }

    @Override
    public void updateByVo(SysTeacherInsUpdVo vo) {
        // 查询教师对应的用户
        SysUser user = userMapper.selectById(vo.getUserId());
        // 更新属性
        user.setPassword(vo.getPassword());
        user.setRealName(vo.getTeacherName());
        user.setTel(vo.getTel());
        user.setGender(vo.getGender());
        // 更新教师对应的用户信息
        userMapper.updateById(user);
        // 更新教师信息
        SysTeacher teacher = baseMapper.selectById(vo.getId());
        teacher.setPosition(vo.getPosition());
        teacher.setResearchDirection(vo.getResearchDirection());
        baseMapper.updateById(teacher);
    }

    @Override
    public SysTeacherResVo getResVoById(Long id) {
        return baseMapper.selectResVoById(id);
    }
}
