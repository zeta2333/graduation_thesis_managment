package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import usts.cs2020.mapper.SysTeacherMapper;
import usts.cs2020.model.system.SysTeacher;
import usts.cs2020.model.vo.SysTeacherQueryVo;
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
    public IPage<SysTeacher> queryPageListByCondition(SysTeacherQueryVo vo, Page<SysTeacher> pageParam) {
        // TODO 多表查询待完善：teacherName,researchDirection,rank,...并返回一个全新的teacherInfoVo对象
        LambdaQueryWrapper<SysTeacher> wrapper = new LambdaQueryWrapper<>();
        String keyword = vo.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(SysTeacher::getPosition, keyword)
                    .or().like(SysTeacher::getResearchDirection, keyword);
        }
        return baseMapper.selectPage(pageParam, wrapper);
    }
}
