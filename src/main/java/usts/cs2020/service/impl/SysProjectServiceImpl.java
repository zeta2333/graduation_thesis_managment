package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import usts.cs2020.mapper.SysTeacherMapper;
import usts.cs2020.model.system.SysProject;
import usts.cs2020.mapper.SysProjectMapper;
import usts.cs2020.model.system.SysTeacher;
import usts.cs2020.model.vo.ins_upd.SysProjectInsUpdVo;
import usts.cs2020.model.vo.query.SysProjectQueryVo;
import usts.cs2020.model.vo.result.SysProjectResVo;
import usts.cs2020.service.SysProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课题 服务实现类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Service
public class SysProjectServiceImpl extends ServiceImpl<SysProjectMapper, SysProject> implements SysProjectService {
    @Autowired
    SysTeacherMapper teacherMapper;

    // 条件分页查询
    @Override
    public IPage<SysProjectResVo> queryPage(Page<SysProject> pageParam, SysProjectQueryVo vo) {
        if (vo != null && vo.getKeyword() != null) {
            vo.setKeyword(vo.getKeyword().trim());
        }
        return baseMapper.findPage(pageParam, vo);
    }

    @Override
    public SysProjectResVo getResVoById(Long id) {
        return baseMapper.selectResVoById(id);
    }

    @Override
    public void saveByVo(SysProjectInsUpdVo vo) {
        SysTeacher teacher = teacherMapper.selectOne(
                new LambdaQueryWrapper<SysTeacher>()
                        .eq(SysTeacher::getUserId, vo.getUserId())
        );
        Long teacherId = teacher.getId();
        SysProject project = new SysProject();
        project.setProjectName(vo.getProjectName());
        project.setTeacherId(teacherId);
        project.setDescription(vo.getDescription());
        project.setStatus(vo.getStatus());
        baseMapper.insert(project);
    }

    // 根据userId查询
    @Override
    public SysProjectResVo getByUserId(Long userId) {
        return baseMapper.selectResVoByUserId(userId);
    }
}
