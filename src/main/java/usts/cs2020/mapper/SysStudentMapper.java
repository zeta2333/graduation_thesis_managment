package usts.cs2020.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.query.SysStudentQueryVo;
import usts.cs2020.model.vo.result.SysStudentResVo;

import java.util.List;

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
    Page<SysStudentResVo> findAndPage(Page<SysStudent> pageParam, @Param("vo") SysStudentQueryVo vo);


    // 根据id查询
    SysStudentResVo selectResVoById(@Param("id") Long id);

    // 根据教师的userId获取学生列表
    List<SysStudentResVo> selectListByTeacherUserId(@Param("userId") Long userId);

}
