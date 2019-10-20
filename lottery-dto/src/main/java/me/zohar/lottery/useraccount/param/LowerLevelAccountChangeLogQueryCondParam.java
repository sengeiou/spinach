package me.zohar.lottery.useraccount.param;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zohar.lottery.common.param.PageParam;

@Data
@EqualsAndHashCode(callSuper = false)
public class LowerLevelAccountChangeLogQueryCondParam extends PageParam {
	
	/**
	 * 当前账号id
	 */
	@NotBlank
	private String currentAccountId;
	
	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 游戏代码
	 */
	private String gameCode;

	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endTime;

	/**
	 * 账变类型代码
	 */
	private String accountChangeTypeCode;

}
