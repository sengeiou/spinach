package me.zohar.lottery.rechargewithdraw.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RechargeWithdrawLogVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 订单类型
	 */
	private String orderType;

	/**
	 * 订单类型名称:充值,提现
	 */
	private String orderTypeName;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 提交时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date submitTime;

	/**
	 * 订单状态
	 */
	private String orderState;

	/**
	 * 订单状态名称
	 */
	private String orderStateName;

	/**
	 * 备注
	 */
	private String note;

	/**
	 * 用户账号id
	 */
	private String userAccountId;


}
