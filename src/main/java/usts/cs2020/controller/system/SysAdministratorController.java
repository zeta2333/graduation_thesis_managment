package usts.cs2020.controller.system;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usts.cs2020.model.system.SysAdministrator;
import usts.cs2020.service.SysAdministratorService;
import usts.cs2020.utils.result.Result;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Api(tags = "管理员管理")
@RestController
@RequestMapping("/system/sysAdministrator")
@CrossOrigin
public class SysAdministratorController {
    @Autowired
    private SysAdministratorService service;

    // 条件分页查询
    @ApiOperation("分页查询")
    @GetMapping("{current}/{size}")
    public Result index(@PathVariable Long current,
                        @PathVariable Long size) {
        // 创建page对象
        Page<SysAdministrator> pageParam = new Page<>(current, size);
        IPage<SysAdministrator> pageModel = service.page(pageParam, null);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "根据id获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysAdministrator administrator = service.getById(id);
        return Result.ok(administrator);
    }

    @ApiOperation(value = "添加")
    @PostMapping("save")
    public Result save(@RequestBody SysAdministrator administrator) {
        service.save(administrator);
        return Result.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping("update")
    public Result updateById(@RequestBody SysAdministrator administrator) {
        service.updateById(administrator);
        return Result.ok();
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        service.removeById(id);
        return Result.ok();
    }
}

