package usts.cs2020.controller.system;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.ins_upd.SysStudentInsUpdVo;
import usts.cs2020.model.vo.query.SysStudentQueryVo;
import usts.cs2020.model.vo.result.SysStudentResVo;
import usts.cs2020.service.SysStudentService;
import usts.cs2020.utils.result.Result;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 学生 前端控制器
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Api(tags = "学生管理")
@RestController
@RequestMapping("/system/sysStudent")
public class SysStudentController {
    @Autowired
    private SysStudentService service;

    // 用户条件分页查询
    @ApiOperation("条件分页查询")
    @GetMapping("{current}/{size}")
    public Result index(@PathVariable Long current,
                        @PathVariable Long size,
                        SysStudentQueryVo vo) {
        // 创建page对象
        Page<SysStudent> pageParam = new Page<>(current, size);
        IPage<SysStudentResVo> pageModel = service.queryPageList(vo, pageParam);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "根据id获取")
    @GetMapping("get/{id}")
    public Result getById(@PathVariable Long id) {
        SysStudentResVo studentResVo = service.getResVoById(id);
        return Result.ok(studentResVo);
    }

    @ApiOperation("根据教师的userId获取学生列表")
    @GetMapping("listByTeacherUserId/{userId}")
    public Result listByTeacherUserId(@PathVariable("userId") Long userId) {
        List<SysStudentResVo> studentList = service.listByTeacherUserId(userId);
        return Result.ok(studentList);
    }

    @ApiOperation(value = "添加")
    @PostMapping("save")
    public Result save(@RequestBody SysStudentInsUpdVo vo) {
        service.saveByVo(vo);
        return Result.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping("update")
    public Result updateById(@RequestBody SysStudentInsUpdVo vo) {
        service.updateByVo(vo);
        return Result.ok();
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("remove/{id}")
    public Result removeById(@PathVariable Long id) {
        service.removeById(id);
        return Result.ok();
    }

    // @ApiOperation("选择课题")
    // @PostMapping("selectProject/{userId}/{projectId}")
    // public Result selectProject(
    //         @PathVariable("userId")Long userId,
    //         @PathVariable("")
    //         ) {
    //
    //     return Result.ok();
    // }

    @ApiOperation("上传论文")
    @PostMapping("uploadPaper")
    public Result uploadPaper(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") Long userId
    ) throws IOException {
        service.uploadFile(file, userId);
        return Result.ok();
    }
}

