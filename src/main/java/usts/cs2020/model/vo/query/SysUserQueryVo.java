//
//
package usts.cs2020.model.vo.query;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户查询实体
 * </p>
 */
@Data
public class SysUserQueryVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String keyword;
	private String createTimeBegin;
	private String createTimeEnd;

}

