package usts.cs2020.controller.system;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import usts.cs2020.model.system.SysProject;
import usts.cs2020.model.vo.ins_upd.SysProjectInsUpdVo;
import usts.cs2020.model.vo.query.SysProjectQueryVo;
import usts.cs2020.model.vo.result.SysProjectResVo;
import usts.cs2020.service.SysProjectService;
import usts.cs2020.utils.result.Result;

/**
 * <p>
 * 课题 前端控制器
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Api(tags = "课题管理")
@RestController
@RequestMapping("/system/sysProject")
public class SysProjectController {
    @Autowired
    private SysProjectService service;

    // 条件分页查询
    @ApiOperation("分页查询")
    @GetMapping("{current}/{size}")
    public Result index(@PathVariable Long current,
                        @PathVariable Long size,
                        SysProjectQueryVo vo) {
        // 创建page对象
        Page<SysProject> pageParam = new Page<>(current, size);
        IPage<SysProjectResVo> pageModel = service.queryPage(pageParam, vo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "根据id获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysProjectResVo projectResVo = service.getResVoById(id);
        return Result.ok(projectResVo);
    }

    @ApiOperation("查询目标教师的课题")
    @GetMapping("getByUserId/{userId}")
    public Result getByUserId(@PathVariable("userId") Long userId) {
        SysProjectResVo projectResVo = service.getByUserId(userId);
        return Result.ok(projectResVo);
    }

    @ApiOperation(value = "添加")
    @PostMapping("save")
    public Result save(@RequestBody SysProjectInsUpdVo vo) {
        service.saveByVo(vo);
        return Result.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping("update")
    public Result updateById(@RequestBody SysProject project) {
        service.updateById(project);
        return Result.ok();
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        service.removeById(id);
        return Result.ok();
    }
}

