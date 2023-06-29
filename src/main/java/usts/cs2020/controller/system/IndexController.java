package usts.cs2020.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usts.cs2020.model.system.LoginVo;
import usts.cs2020.model.system.SysUser;
import usts.cs2020.service.SysUserService;
import usts.cs2020.utils.encrypt.MD5;
import usts.cs2020.utils.handler.CustomException;
import usts.cs2020.utils.jwt.JwtHelper;
import usts.cs2020.utils.result.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-22 7:00 PM
 */
@Api(tags = "后台登录管理")
@RestController
@RequestMapping("system/index")
@CrossOrigin
public class IndexController {
    @Autowired
    SysUserService userService;

    /**
     * 登录
     *
     * @return
     */
    @ApiOperation("登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo) {
        SysUser user = userService.getByUsername(loginVo.getUsername());
        // 登录验证
        if (user == null) {
            throw new CustomException(201, "用户不存在");
        }
        if (!MD5.encrypt(loginVo.getPassword()).equals(user.getPassword())) {
            throw new CustomException(201, "密码错误");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("token", JwtHelper.createToken(user.getId(), user.getUsername()));
        return Result.ok(map);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @ApiOperation("获取信息")
    @GetMapping("info")
    public Result info(HttpServletRequest request) {
        String username = JwtHelper.getUsername(request.getHeader("token"));
        Map<String, Object> map = userService.getUserInfo(username);
        return Result.ok(map);
    }

    /**
     * 退出
     *
     * @return
     */
    @ApiOperation("登出")
    @PostMapping("logout")
    public Result logout() {
        return Result.ok();
    }

}