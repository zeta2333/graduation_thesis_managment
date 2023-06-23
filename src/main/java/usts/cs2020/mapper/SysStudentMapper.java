package usts.cs2020.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import usts.cs2020.model.system.SysStudent;

/**
 * <p>
 * 学生 Mapper 接口
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Mapper
public interface SysStudentMapper extends BaseMapper<SysStudent> {

}
