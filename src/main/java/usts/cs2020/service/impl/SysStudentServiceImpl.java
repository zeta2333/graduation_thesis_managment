package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import usts.cs2020.mapper.*;
import usts.cs2020.model.system.*;
import usts.cs2020.model.vo.ins_upd.SysStudentInsUpdVo;
import usts.cs2020.model.vo.query.SysStudentQueryVo;
import usts.cs2020.model.vo.result.SysStudentResVo;
import usts.cs2020.service.SysStudentService;
import usts.cs2020.utils.file.FileUtil;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Service
public class SysStudentServiceImpl extends ServiceImpl<SysStudentMapper, SysStudent> implements SysStudentService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysSubjectMapper subjectMapper;
    @Autowired
    private SysPaperMapper paperMapper;
    @Autowired
    private SysProjectMapper projectMapper;


    // 条件分页查询
    @Override
    public IPage<SysStudentResVo> queryPageList(SysStudentQueryVo vo, Page<SysStudent> pageParam) {
        if (vo != null && vo.getKeyword() != null) {
            vo.setKeyword(vo.getKeyword().trim());
        }
        return baseMapper.findAndPage(pageParam, vo);
    }

    @Override
    public void saveByVo(SysStudentInsUpdVo vo) {
        // 1.添加sysUser对象
        // 创建user对象
        SysUser user = new SysUser();
        // 填充属性
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword());
        user.setRealName(vo.getStudentName());
        user.setTel(vo.getTel());
        user.setGender(vo.getGender());
        user.setRoleId(1L);// 学生角色的roleId为1
        userMapper.insert(user);

        // 2.添加student信息
        SysStudent student = new SysStudent();
        Long userId = user.getId();
        LambdaQueryWrapper<SysSubject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysSubject::getSubjectName, vo.getSubjectName());
        SysSubject subject = subjectMapper.selectOne(wrapper);
        Long subjectId = subject.getId();
        student.setUserId(userId);
        student.setSubjectId(subjectId);
        baseMapper.insert(student);
    }

    @Override
    public void updateByVo(SysStudentInsUpdVo vo) {
        // 查询学生对应的用户
        SysUser user = userMapper.selectById(vo.getUserId());
        // 更新属性
        user.setPassword(vo.getPassword());
        user.setRealName(vo.getStudentName());
        user.setTel(vo.getTel());
        user.setGender(vo.getGender());
        // 更新学生对应的用户信息
        userMapper.updateById(user);

        // 查询更新后的专业id
        SysSubject subject = subjectMapper.selectOne(
                new LambdaQueryWrapper<SysSubject>()
                        .eq(SysSubject::getSubjectName, vo.getSubjectName())
        );
        Long subjectId = subject.getId();
        // 更新学生信息
        SysStudent student = baseMapper.selectById(vo.getId());
        student.setSubjectId(subjectId);
        baseMapper.updateById(student);
    }

    @Override
    public SysStudentResVo getResVoById(Long id) {
        return baseMapper.selectResVoById(id);
    }

    @Override
    public void uploadFile(MultipartFile file, Long userId) throws IOException {
        // 上传文件
        String fileName = FileUtil.upload(file);

        // 根据userId查询学生
        SysStudent student = this.getOne(new LambdaQueryWrapper<SysStudent>()
                .eq(SysStudent::getUserId, userId));

        // 判断，如果数据库没有该学生的论文记录，则新增，否则修改
        SysPaper paper;
        // 先进行查询
        paper = paperMapper.selectOne(new LambdaQueryWrapper<SysPaper>()
                .eq(SysPaper::getStudentId, student.getId()));
        if (paper == null) {// 查询不存在，则数据库添加论文记录
            paper = new SysPaper();
            paper.setPaperPath(fileName);
            paper.setPaperTitle(fileName.substring(0, fileName.indexOf(".")));
            paper.setStudentId(student.getId());
            paper.setPaperStatus(1);
            paperMapper.insert(paper);
        } else {
            paper.setPaperPath(fileName);
            paper.setPaperTitle(fileName.substring(0, fileName.indexOf(".")));
            paper.setPaperStatus(paper.getPaperStatus() + (paper.getPaperStatus() != 3 ? 1 : 0));
            paperMapper.updateById(paper);

        }


    }

    // 根据教师的userId获取学生列表
    @Override
    public List<SysStudentResVo> listByTeacherUserId(Long userId) {
        return baseMapper.selectListByTeacherUserId(userId);
    }

    // 选择课题
    @Override
    public void selectProject(Long userId, Long projectId) {
        // 查询选择的课题
        SysProject project = projectMapper.selectById(projectId);
        // 修改课题状态为2：有人选择
        project.setStatus(2);
        projectMapper.updateById(project);

        // 查询当前的学生
        SysStudent student = baseMapper.selectOne(
                new LambdaQueryWrapper<SysStudent>()
                        .eq(SysStudent::getUserId, userId)
        );
        // 修改学生信息
        student.setProjectId(projectId);
        student.setTeacherId(project.getTeacherId());
        student.setProjectStatus(1);// 设置当前学生的课题状态为已选择
        baseMapper.updateById(student);


    }

    @Override
    public void assessGrade(Long id, Integer grade) {
        baseMapper.assessGrade(id, grade);
    }
}
