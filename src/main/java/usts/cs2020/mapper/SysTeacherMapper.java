package usts.cs2020.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import usts.cs2020.model.system.SysTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import usts.cs2020.model.vo.query.SysTeacherQueryVo;
import usts.cs2020.model.vo.result.SysTeacherResVo;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Mapper
public interface SysTeacherMapper extends BaseMapper<SysTeacher> {

    // 条件分页查询
    IPage<SysTeacherResVo> findPage(Page<SysTeacher> pageParam, SysTeacherQueryVo vo);
}
