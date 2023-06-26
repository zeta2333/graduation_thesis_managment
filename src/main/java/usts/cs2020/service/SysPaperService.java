package usts.cs2020.service;

import usts.cs2020.model.system.SysPaper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 论文 服务类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
public interface SysPaperService extends IService<SysPaper> {

    // 根据学生id查询
    SysPaper getByStudentId(Long studentId);
}
