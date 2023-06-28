package usts.cs2020.model.vo.result;

import lombok.Data;
import usts.cs2020.model.system.SysStudent;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-23 5:48 PM
 */
@Data
public class SysStudentResVo extends SysStudent {
    private String studentName;
    private String projectName = "未选择";
    private String teacherName = "未选择";
    private String subjectName;
    private String paperTitle = "";
    private Integer paperStatus = 0;
    private String paperPath = "";
}
