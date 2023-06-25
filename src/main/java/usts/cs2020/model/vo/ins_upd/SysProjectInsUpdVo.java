package usts.cs2020.model.vo.ins_upd;

import lombok.Data;
import usts.cs2020.model.system.SysProject;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-25 11:00 PM
 */
@Data
public class SysProjectInsUpdVo extends SysProject {
    private Long userId;
}
