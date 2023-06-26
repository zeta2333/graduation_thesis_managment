package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import usts.cs2020.model.system.SysPaper;
import usts.cs2020.mapper.SysPaperMapper;
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

    // 根据学生id查询
    @Override
    public SysPaper getByStudentId(Long studentId) {
        LambdaQueryWrapper<SysPaper> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysPaper::getStudentId, studentId);
        return baseMapper.selectOne(wrapper);
    }
}
