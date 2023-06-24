package usts.cs2020.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import usts.cs2020.model.system.SysUser;
import usts.cs2020.model.vo.SysUserQueryVo;
import usts.cs2020.model.vo.SysUserResVo;
import usts.cs2020.service.SysUserService;
import usts.cs2020.utils.encrypt.MD5;
import usts.cs2020.utils.result.Result;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Pycro
 * @since 2023-06-22
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService service;

    // 用户条件分页查询
    @ApiOperation("用户条件分页查询")
    @GetMapping("{current}/{size}")
    public Result index(@PathVariable Long current,
                        @PathVariable Long size,
                        SysUserQueryVo vo) {
        // 创建page对象
        Page<SysUser> pageParam = new Page<>(current, size);

        // // 封装条件，判断条件值不为空
        // LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        // // 获取条件值
        // String keyword = vo.getKeyword();
        // String createTimeBegin = vo.getCreateTimeBegin();
        // String createTimeEnd = vo.getCreateTimeEnd();
        // // 判断条件值不为空
        // // like 模糊查询
        // if (!StringUtils.isEmpty(keyword)) {
        //     wrapper.like(SysUser::getUsername, keyword)
        //             .or().like(SysUser::getRealName, keyword)
        //             .or().like(SysUser::getTel, keyword)
        //             .or().eq(SysUser::getGender, keyword);
        // }
        // // ge 大于等于
        // if (!StringUtils.isEmpty(createTimeBegin)) {
        //     wrapper.ge(SysUser::getCreateTime, createTimeBegin);
        // }
        // // le 小于等于
        // if (!StringUtils.isEmpty(createTimeEnd)) {
        //     wrapper.le(SysUser::getCreateTime, createTimeEnd);
        // }

        // 调用mp的方法实现条件分页查询
        IPage<SysUserResVo> pageModel = service.queryPageList(pageParam, vo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "获取用户")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysUser user = service.getById(id);
        return Result.ok(user);
    }

    @ApiOperation(value = "保存用户")
    @PostMapping("save")
    public Result save(@RequestBody SysUser user) {
        // 对password做加密后添加到数据库
        user.setPassword(MD5.encrypt(user.getPassword()));
        service.save(user);
        return Result.ok();
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("update")
    public Result updateById(@RequestBody SysUser user) {
        service.updateById(user);
        return Result.ok();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        service.removeById(id);
        return Result.ok();
    }
}

