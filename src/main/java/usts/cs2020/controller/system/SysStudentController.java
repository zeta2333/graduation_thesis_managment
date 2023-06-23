package usts.cs2020.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.SysStudentVo;
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
                        SysStudentVo vo) {
        // 创建page对象
        Page<SysStudent> pageParam = new Page<>(current, size);

        // 封装条件，判断条件值不为空
        LambdaQueryWrapper<SysStudent> wrapper = new LambdaQueryWrapper<>();
        // // 获取条件值
        // String keyword = vo.getKeyword();
        // String createTimeBegin = vo.getCreateTimeBegin();
        // String createTimeEnd = vo.getCreateTimeEnd();
        // // 判断条件值不为空
        // // like 模糊查询
        // if (!StringUtils.isEmpty(keyword)) {
        //     wrapper.like(SysStudent::getUsername, keyword)
        //             .or().like(SysStudent::getRealName, keyword)
        //             .or().like(SysStudent::getTel, keyword)
        //             .or().eq(SysStudent::getGender, keyword);
        // }
        // // ge 大于等于
        // if (!StringUtils.isEmpty(createTimeBegin)) {
        //     wrapper.ge(SysStudent::getCreateTime, createTimeBegin);
        // }
        // // le 小于等于
        // if (!StringUtils.isEmpty(createTimeEnd)) {
        //     wrapper.le(SysStudent::getCreateTime, createTimeEnd);
        // }

        // 调用mp的方法实现条件分页查询
        IPage<SysStudent> pageModel = service.page(pageParam, wrapper);
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

