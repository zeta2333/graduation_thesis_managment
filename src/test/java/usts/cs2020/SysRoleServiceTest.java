package usts.cs2020;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.cs2020.model.system.SysRole;
import usts.cs2020.service.SysRoleService;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-22 10:11 AM
 */
@SpringBootTest
public class SysRoleServiceTest {
    @Autowired
    private SysRoleService service;

    @Test
    public void testSelectList() {
        List<SysRole> list = service.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("test_role");
        sysRole.setDescription("测试角色");
        service.save(sysRole);
    }

    @Test
    public void testUpdateById() {
        SysRole sysRole = new SysRole();
        sysRole.setId(4L);
        sysRole.setDescription("测试角色update");
        service.updateById(sysRole);
    }

    @Test
    public void testDeleteById() {
        service.removeById(4);
    }

    @Test
    public void testWrapperSelect() {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(SysRole::getId, 2);
        List<SysRole> list = service.list(wrapper);
        list.forEach(System.out::println);
    }
}
