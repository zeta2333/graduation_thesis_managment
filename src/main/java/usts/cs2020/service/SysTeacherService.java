package usts.cs2020.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import usts.cs2020.model.system.SysTeacher;
import usts.cs2020.model.vo.ins_upd.SysTeacherInsUpdVo;
import usts.cs2020.model.vo.query.SysTeacherQueryVo;
import usts.cs2020.model.vo.result.SysTeacherResVo;

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
    IPage<SysTeacherResVo> queryPageList(SysTeacherQueryVo vo, Page<SysTeacher> pageParam);

    // 添加
    void saveByVo(SysTeacherInsUpdVo vo);

    // 更新
    void updateByVo(SysTeacherInsUpdVo vo);

    // 根据id查询
    SysTeacherResVo getResVoById(Long id);
}
