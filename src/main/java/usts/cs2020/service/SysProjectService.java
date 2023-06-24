package usts.cs2020.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import usts.cs2020.model.system.SysProject;
import com.baomidou.mybatisplus.extension.service.IService;
import usts.cs2020.model.vo.query.SysProjectQueryVo;
import usts.cs2020.model.vo.result.SysProjectResVo;

/**
 * <p>
 * 课题 服务类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
public interface SysProjectService extends IService<SysProject> {

    // 条件分页查询
    IPage<SysProjectResVo> queryPage(Page<SysProject> pageParam, SysProjectQueryVo vo);
}
