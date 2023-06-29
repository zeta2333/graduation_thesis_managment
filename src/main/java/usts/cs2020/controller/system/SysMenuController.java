package usts.cs2020.controller.system;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usts.cs2020.model.system.SysMenu;
import usts.cs2020.service.SysMenuService;
import usts.cs2020.utils.result.Result;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author Pycro
 * @since 2023-06-24
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/system/sysMenu")
@CrossOrigin
public class SysMenuController {
    @Autowired
    private SysMenuService service;

    // 条件分页查询
    @ApiOperation("查询所有")
    @GetMapping("getAllMenus")
    public Result index() {
        // 创建page对象
        List<SysMenu> menuList = service.list();
        return Result.ok(menuList);
    }

    @ApiOperation(value = "根据id获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysMenu menu = service.getById(id);
        return Result.ok(menu);
    }

    @ApiOperation(value = "添加")
    @PostMapping("save")
    public Result save(@RequestBody SysMenu menu) {
        service.save(menu);
        return Result.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping("update")
    public Result updateById(@RequestBody SysMenu menu) {
        service.updateById(menu);
        return Result.ok();
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        service.removeById(id);
        return Result.ok();
    }
}

