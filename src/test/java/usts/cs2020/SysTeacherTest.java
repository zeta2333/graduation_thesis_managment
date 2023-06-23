package usts.cs2020;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.cs2020.mapper.SysTeacherMapper;
import usts.cs2020.model.system.SysTeacher;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-23 11:40 PM
 */
@SpringBootTest
public class SysTeacherTest {
    @Autowired
    SysTeacherMapper mapper;

    @Test
    public void testInsert() {
        SysTeacher sysTeacher = new SysTeacher();
        sysTeacher.setUserId(4L);
        sysTeacher.setTRank("教授");
        sysTeacher.setResearchDirection("分布式系统与云计算");
        int res = mapper.insert(sysTeacher);
        System.out.println("res = " + res);
    }

    @Test
    public void testSelectList() {
        List<SysTeacher> teacherList = mapper.selectList(null);
        teacherList.forEach(System.out::println);
    }
}
