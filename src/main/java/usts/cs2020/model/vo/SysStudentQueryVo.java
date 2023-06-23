package usts.cs2020.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-23 4:15 PM
 */
@Data
public class SysStudentQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String keyword;
}
