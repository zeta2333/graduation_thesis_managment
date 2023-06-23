package usts.cs2020.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import usts.cs2020.model.system.SysTeacher;
import usts.cs2020.model.vo.SysTeacherQueryVo;

/**
 * <p>
 * 用户角色 服务类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
public interface SysTeacherService extends IService<SysTeacher> {

    //  条件分页查询
    IPage<SysTeacher> queryPageListByCondition(SysTeacherQueryVo vo, Page<SysTeacher> pageParam);
}
