package me.zohar.lottery.betting.param;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zohar.lottery.common.param.PageParam;

@Data
@EqualsAndHashCode(callSuper = false)
public class TrackingNumberSituationQueryCondParam extends PageParam {

	/**
	 * 订单号
	 */
	private String orderNo;

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

	private String state;

	private String userAccountId;

}
