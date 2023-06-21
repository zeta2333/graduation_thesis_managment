package usts.cs2020;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import usts.cs2020.mapper.SysRoleMapper;
import usts.cs2020.model.system.SysRole;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-21 7:08 PM
 */
@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    SysRoleMapper mapper;

    @Test
    public void testSelect() {
        List<SysRole> sysRoles = mapper.selectList(null);
        System.out.println("-----------分割线--------");
        System.out.println(mapper.getClass());
        sysRoles.forEach(System.out::println);
    }
    @Test
    public void testLambdaWrapper(){
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName,"student");
        List<SysRole> sysRoles = mapper.selectList(wrapper);
        sysRoles.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("administrator");
        sysRole.setDescription("管理员角色");
        int res = mapper.insert(sysRole);
        System.out.println("res = " + res);
        System.out.println(sysRole);
    }

    @Test
    public void testUpdate() {
        SysRole sysRole = new SysRole();
        sysRole.setId(3L);
        sysRole.setDescription("管理员角色");
        int res = mapper.updateById(sysRole);
        System.out.println("res = " + res);
    }

    @Test
    public void testDelete() {
        int res = mapper.deleteById(2L);
        System.out.println("res = " + res);
    }
}
