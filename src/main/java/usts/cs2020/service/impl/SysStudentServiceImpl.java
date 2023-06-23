package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import usts.cs2020.mapper.SysStudentMapper;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.SysStudentQueryVo;
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


    // 条件分页查询
    @Override
    public IPage<SysStudent> queryPageListByCondition(SysStudentQueryVo vo, Page<SysStudent> pageParam) {
        // TODO 多表查询待完善：studentName,teacherName,projectName,...并返回一个全新的studentInfoVo对象
        LambdaQueryWrapper<SysStudent> wrapper = new LambdaQueryWrapper<>();
        String keyword = vo.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(SysStudent::getUserId, keyword);
        }
        return baseMapper.selectPage(pageParam, wrapper);
    }
}
