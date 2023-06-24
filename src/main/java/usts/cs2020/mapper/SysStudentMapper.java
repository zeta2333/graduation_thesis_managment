package usts.cs2020.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.SysStudentQueryVo;
import usts.cs2020.model.vo.SysStudentResVo;

/**
 * <p>
 * 学生 Mapper 接口
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Mapper
public interface SysStudentMapper extends BaseMapper<SysStudent> {

    // 条件分页查询
    Page<SysStudentResVo> findAndPage(Page<SysStudent> pageParam, SysStudentQueryVo vo);
}
