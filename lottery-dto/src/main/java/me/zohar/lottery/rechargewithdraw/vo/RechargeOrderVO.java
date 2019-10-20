package me.zohar.lottery.rechargewithdraw.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RechargeOrderVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 充值方式代码
	 */
	private String rechargeWayCode;
	
	/**
	 * 充值方式
	 */
	private String rechargeWayName;

	/**
	 * 充值金额
	 */
	private Double rechargeAmount;
	
	/**
	 * 实际支付金额
	 */
	private Double actualPayAmount;

	/**
	 * 提交时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date submitTime;

	/**
	 * 有效时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date usefulTime;

	/**
	 * 订单状态
	 */
	private String orderState;

	private String orderStateName;

	/**
	 * 备注
	 */
	private String note;

	/**
	 * 支付地址
	 */
	private String payUrl;

	/**
	 * 支付时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date payTime;

	/**
	 * 处理时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date dealTime;

	/**
	 * 结算时间,即更新到账号余额的时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date settlementTime;

	/**
	 * 用户账号id
	 */
	private String userAccountId;

	/**
	 * 用户名
	 */
	private String userName;

}
