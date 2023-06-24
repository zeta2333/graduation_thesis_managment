package usts.cs2020.model.vo.result;

import lombok.Data;
import usts.cs2020.model.system.SysTeacher;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-24 12:10 PM
 */
@Data
public class SysTeacherResVo extends SysTeacher {
    private String teacherName;
}
