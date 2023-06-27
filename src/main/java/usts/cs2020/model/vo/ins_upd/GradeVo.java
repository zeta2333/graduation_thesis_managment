package usts.cs2020.model.vo.ins_upd;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-27 11:24 PM
 */
@Data
public class GradeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    // 学生id
    private Long id;
    // 成绩
    private Integer grade;
}
