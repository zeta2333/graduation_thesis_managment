package usts.cs2020.mapper;

import org.apache.ibatis.annotations.Mapper;
import usts.cs2020.model.system.SysSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 专业 Mapper 接口
 * </p>
 *
 * @author Pycro
 * @since 2023-06-23
 */
@Mapper
public interface SysSubjectMapper extends BaseMapper<SysSubject> {

}
