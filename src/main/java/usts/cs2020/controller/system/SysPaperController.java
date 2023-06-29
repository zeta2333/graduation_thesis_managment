package usts.cs2020.controller.system;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import usts.cs2020.model.system.SysPaper;
import usts.cs2020.service.SysPaperService;
import usts.cs2020.utils.result.Result;

/**
 * <p>
 * 论文 前端控制器
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Api(tags = "论文管理")
@RestController
@RequestMapping("/system/sysPaper")
@CrossOrigin
public class SysPaperController {
    @Autowired
    private SysPaperService service;

    // 条件分页查询
    @ApiOperation("分页查询")
    @GetMapping("{current}/{size}")
    public Result index(@PathVariable Long current,
                        @PathVariable Long size) {
        // 创建page对象
        Page<SysPaper> pageParam = new Page<>(current, size);
        IPage<SysPaper> pageModel = service.page(pageParam, null);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "根据id获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysPaper paper = service.getById(id);
        return Result.ok(paper);
    }

    @ApiOperation(value = "添加")
    @PostMapping("save")
    public Result save(@RequestBody SysPaper paper) {
        service.save(paper);
        return Result.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping("update")
    public Result updateById(@RequestBody SysPaper paper) {
        service.updateById(paper);
        return Result.ok();
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        service.removeById(id);
        return Result.ok();
    }

    @ApiOperation("根据学生的userId查询")
    @GetMapping("getByUserId/{userId}")
    public Result getByUserId(@PathVariable("userId") Long userId) {
        SysPaper paper = service.getByUserId(userId);
        return Result.ok(paper);
    }
}

