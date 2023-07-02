package usts.cs2020;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.cs2020.mapper.SysStudentMapper;
import usts.cs2020.model.system.SysStudent;
import usts.cs2020.model.vo.query.SysStudentQueryVo;
import usts.cs2020.model.vo.result.SysStudentResVo;

/**
 * @author Pycro
 * @version 1.0
 * 2023-07-02 3:20 PM
 */
@SpringBootTest
public class SysStudentMapperTest {
    @Autowired
    private SysStudentMapper mapper;

    @Test
    public void testCRUD() {
        Page<SysStudent> pageParam = new Page<>(1, 10);
        SysStudentQueryVo vo = new SysStudentQueryVo();
        Page<SysStudentResVo> page = mapper.findAndPage(pageParam, vo);
        System.out.println(page);
    }
}
