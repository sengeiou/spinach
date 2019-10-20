package me.zohar.lottery.betting.param;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zohar.lottery.common.param.PageParam;

/**
 * 下级账号投注订单查询条件入参
 * 
 * @author zohar
 * @date 2019年1月19日
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LowerLevelBettingOrderQueryCondParam extends PageParam {

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
	 * 游戏代码
	 */
	private String gameCode;

	private Long issueNum;

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
	 * 状态
	 */
	private String state;

}
