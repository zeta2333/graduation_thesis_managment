package usts.cs2020.model.vo.ins_upd;

import lombok.Data;
import usts.cs2020.model.system.SysStudent;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-25 9:26 PM
 */
@Data
public class SysStudentInsUpdVo extends SysStudent {
    private String subjectName;
    private String username;
    private String password;
    private String studentName;
    private String tel;
    private String gender;
}
