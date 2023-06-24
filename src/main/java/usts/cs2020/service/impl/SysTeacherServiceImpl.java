package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import usts.cs2020.mapper.SysTeacherMapper;
import usts.cs2020.model.system.SysTeacher;
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

    @Override
    public IPage<SysTeacherResVo> queryPageList(SysTeacherQueryVo vo, Page<SysTeacher> pageParam) {
        if (vo != null && vo.getKeyword() != null) {
            vo.setKeyword(vo.getKeyword().trim());
        }
        return baseMapper.findPage(pageParam, vo);
    }
}
