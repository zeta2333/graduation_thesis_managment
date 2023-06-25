package usts.cs2020;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.cs2020.mapper.SysUserMapper;
import usts.cs2020.model.system.SysUser;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-25 9:41 PM
 */
@SpringBootTest
public class SysUserMapperTest {
    @Autowired
    private SysUserMapper mapper;

    @Test
    public void testInsert() {
        SysUser user = new SysUser();
        user.setUsername("fuck");
        user.setPassword("tnnd");
        user.setRoleId(2L);
        System.out.println("添加前：" + user.getId());
        mapper.insert(user);
        System.out.println("添加后：" + user.getId());
    }
}
