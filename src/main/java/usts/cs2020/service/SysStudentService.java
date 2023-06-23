package usts.cs2020.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.SysStudentQueryVo;

/**
 * <p>
 * 学生 服务类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
public interface SysStudentService extends IService<SysStudent> {

    // 条件分页查询
    IPage<SysStudent> queryPageListByCondition(SysStudentQueryVo vo, Page<SysStudent> pageParam);
}
