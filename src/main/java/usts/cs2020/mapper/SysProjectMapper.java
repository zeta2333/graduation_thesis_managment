package usts.cs2020.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import usts.cs2020.model.system.SysProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import usts.cs2020.model.vo.query.SysProjectQueryVo;
import usts.cs2020.model.vo.result.SysProjectResVo;

/**
 * <p>
 * 课题 Mapper 接口
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Mapper
public interface SysProjectMapper extends BaseMapper<SysProject> {
    // 条件分页查询
    IPage<SysProjectResVo> findPage(Page<SysProject> pageParam, @Param("vo") SysProjectQueryVo vo);
}
