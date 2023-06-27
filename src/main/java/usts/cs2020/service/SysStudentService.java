package usts.cs2020.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.ins_upd.SysStudentInsUpdVo;
import usts.cs2020.model.vo.query.SysStudentQueryVo;
import usts.cs2020.model.vo.result.SysStudentResVo;

import java.io.IOException;
import java.util.List;

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
    IPage<SysStudentResVo> queryPageList(SysStudentQueryVo vo, Page<SysStudent> pageParam);

    // 添加学生
    void saveByVo(SysStudentInsUpdVo vo);

    // 修改学生
    void updateByVo(SysStudentInsUpdVo vo);

    // 根据id查询并返回resVo
    SysStudentResVo getResVoById(Long id);

    // 上传文件
    void uploadFile(MultipartFile file, Long userId) throws IOException;

    // 根据教师的userId获取学生列表
    List<SysStudentResVo> listByTeacherUserId(Long userId);

    // 选择课题
    void selectProject(Long userId, Long projectId);
}
