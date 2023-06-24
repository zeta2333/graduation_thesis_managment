package usts.cs2020.model.vo;

import lombok.Data;
import usts.cs2020.model.system.SysUser;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-24 11:37 AM
 */
@Data
public class SysUserResVo extends SysUser {
    private String roleName;
}
