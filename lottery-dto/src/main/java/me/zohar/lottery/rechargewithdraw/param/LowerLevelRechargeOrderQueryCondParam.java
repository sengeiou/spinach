package me.zohar.lottery.rechargewithdraw.param;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zohar.lottery.common.param.PageParam;

@Data
@EqualsAndHashCode(callSuper = false)
public class LowerLevelRechargeOrderQueryCondParam extends PageParam {

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
	 * 账号类型
	 */
	private String accountType;

	/**
	 * 提交开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date submitStartTime;

	/**
	 * 提交结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date submitEndTime;

}
