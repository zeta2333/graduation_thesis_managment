package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cs2020.mapper.SysStudentMapper;
import usts.cs2020.mapper.SysSubjectMapper;
import usts.cs2020.mapper.SysUserMapper;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.system.SysSubject;
import usts.cs2020.model.system.SysUser;
import usts.cs2020.model.vo.ins_upd.SysStudentInsUpdVo;
import usts.cs2020.model.vo.query.SysStudentQueryVo;
import usts.cs2020.model.vo.result.SysStudentResVo;
import usts.cs2020.service.SysStudentService;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Service
public class SysStudentServiceImpl extends ServiceImpl<SysStudentMapper, SysStudent> implements SysStudentService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysSubjectMapper subjectMapper;

    // 条件分页查询
    @Override
    public IPage<SysStudentResVo> queryPageList(SysStudentQueryVo vo, Page<SysStudent> pageParam) {
        if (vo != null && vo.getKeyword() != null) {
            vo.setKeyword(vo.getKeyword().trim());
        }
        return baseMapper.findAndPage(pageParam, vo);
    }

    @Override
    public void saveByVo(SysStudentInsUpdVo vo) {
        // 1.添加sysUser对象
        // 创建user对象
        SysUser user = new SysUser();
        // 填充属性
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword());
        user.setRealName(vo.getRealName());
        user.setTel(vo.getTel());
        user.setGender(vo.getGender());
        user.setRoleId(1L);// 学生角色的roleId为1
        userMapper.insert(user);

        // 2.添加student信息
        SysStudent student = new SysStudent();
        Long userId = user.getId();
        LambdaQueryWrapper<SysSubject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysSubject::getSubjectName, vo.getSubjectName());
        SysSubject subject = subjectMapper.selectOne(wrapper);
        Long subjectId = subject.getId();
        student.setUserId(userId);
        student.setSubjectId(subjectId);
        baseMapper.insert(student);
    }

    @Override
    public void updateByVo(SysStudentInsUpdVo vo) {
        // 查询学生对应的用户
        SysUser user = userMapper.selectById(vo.getUserId());
        // 更新属性
        user.setPassword(vo.getPassword());
        user.setRealName(vo.getRealName());
        user.setTel(vo.getTel());
        user.setGender(vo.getGender());
        // 更新学生对应的用户信息
        userMapper.updateById(user);

        // 查询更新后的专业id
        SysSubject subject = subjectMapper.selectOne(
                new LambdaQueryWrapper<SysSubject>()
                        .eq(SysSubject::getSubjectName, vo.getSubjectName())
        );
        Long subjectId = subject.getId();
        // 更新学生信息
        SysStudent student = baseMapper.selectById(vo.getId());
        student.setSubjectId(subjectId);
        baseMapper.updateById(student);
    }

    @Override
    public SysStudentResVo getResVoById(Long id) {
        return baseMapper.selectResVoById(id);
    }
}
