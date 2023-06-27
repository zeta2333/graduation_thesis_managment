package usts.cs2020.model.vo.ins_upd;

import lombok.Data;
import usts.cs2020.model.system.SysTeacher;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-25 10:09 PM
 */
@Data
public class SysTeacherInsUpdVo extends SysTeacher {
    private String username;
    private String password;
    private String teacherName;
    private String tel;
    private String gender;
}
