package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import usts.cs2020.mapper.SysStudentMapper;
import usts.cs2020.model.system.SysStudent;
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


    // 条件分页查询
    @Override
    public IPage<SysStudentResVo> queryPageList(SysStudentQueryVo vo, Page<SysStudent> pageParam) {
        if (vo != null && vo.getKeyword() != null) {
            vo.setKeyword(vo.getKeyword().trim());
        }
        return baseMapper.findAndPage(pageParam, vo);
    }
}
