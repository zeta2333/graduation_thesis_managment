package usts.cs2020.controller.system;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import usts.cs2020.model.system.SysTeacher;
import usts.cs2020.model.vo.ins_upd.SysTeacherInsUpdVo;
import usts.cs2020.model.vo.query.SysTeacherQueryVo;
import usts.cs2020.model.vo.result.SysTeacherResVo;
import usts.cs2020.service.SysTeacherService;
import usts.cs2020.utils.result.Result;

/**
 * <p>
 * 用户角色 前端控制器
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Api(tags = "教师管理")
@RestController
@RequestMapping("/system/sysTeacher")
public class SysTeacherController {
    @Autowired
    private SysTeacherService service;

    // 条件分页查询
    @ApiOperation("分页查询")
    @GetMapping("{current}/{size}")
    public Result index(
            @PathVariable Long current,
            @PathVariable Long size,
            SysTeacherQueryVo vo
    ) {
        // 创建page对象
        Page<SysTeacher> pageParam = new Page<>(current, size);
        // 条件分页查询
        IPage<SysTeacherResVo> pageModel = service.queryPageList(vo, pageParam);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "根据id获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysTeacherResVo teacherResVo = service.getResVoById(id);
        return Result.ok(teacherResVo);
    }

    @ApiOperation(value = "添加")
    @PostMapping("save")
    public Result save(@RequestBody SysTeacherInsUpdVo vo) {
        service.saveByVo(vo);
        return Result.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping("update")
    public Result updateById(@RequestBody SysTeacherInsUpdVo vo) {
        service.updateByVo(vo);
        return Result.ok();
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        service.removeById(id);
        return Result.ok();
    }

    @ApiOperation("下载论文")
    @GetMapping("downloadPaper/{filename}")
    public ModelAndView hello(@PathVariable("filename") String filename) {
        return new ModelAndView(
                "redirect:/system/sysFile/download",
                new ModelMap("filename", filename)
        );
    }
}