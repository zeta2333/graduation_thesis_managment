package usts.cs2020.controller.system;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.SysStudentQueryVo;
import usts.cs2020.model.vo.SysStudentResVo;
import usts.cs2020.service.SysStudentService;
import usts.cs2020.utils.result.Result;

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
    public Result get(@PathVariable Long id) {
        SysStudent student = service.getById(id);
        return Result.ok(student);
    }

    @ApiOperation(value = "添加")
    @PostMapping("save")
    public Result save(@RequestBody SysStudent student) {
        service.save(student);
        return Result.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping("update")
    public Result updateById(@RequestBody SysStudent student) {
        service.updateById(student);
        return Result.ok();
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        service.removeById(id);
        return Result.ok();
    }
}

