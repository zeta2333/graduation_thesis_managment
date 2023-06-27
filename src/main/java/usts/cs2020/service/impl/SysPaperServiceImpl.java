package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import usts.cs2020.mapper.SysStudentMapper;
import usts.cs2020.model.system.SysPaper;
import usts.cs2020.mapper.SysPaperMapper;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.service.SysPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论文 服务实现类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Service
public class SysPaperServiceImpl extends ServiceImpl<SysPaperMapper, SysPaper> implements SysPaperService {
    @Autowired
    private SysStudentMapper studentMapper;

    // 根据学生id查询
    @Override
    public SysPaper getByUserId(Long userId) {
        // 根据userId获取学生student
        SysStudent student = studentMapper.selectOne(new LambdaQueryWrapper<SysStudent>()
                .eq(SysStudent::getUserId, userId));
        // 根据student的id获取论文paper
        return baseMapper.selectOne(new LambdaQueryWrapper<SysPaper>()
                .eq(SysPaper::getStudentId, student.getId()));
    }
}
