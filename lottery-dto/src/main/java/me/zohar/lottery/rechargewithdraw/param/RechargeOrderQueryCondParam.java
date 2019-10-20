package me.zohar.lottery.rechargewithdraw.param;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zohar.lottery.common.param.PageParam;

@Data
@EqualsAndHashCode(callSuper = false)
public class RechargeOrderQueryCondParam extends PageParam {

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 订单状态
	 */
	private String orderState;

	/**
	 * 充值方式代码
	 */
	private String rechargeWayCode;

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
