package me.zohar.lottery.rechargewithdraw.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class WithdrawRecordVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 提现金额
	 */
	private Double withdrawAmount;

	/**
	 * 开户银行
	 */
	private String openAccountBank;

	/**
	 * 开户人姓名
	 */
	private String accountHolder;

	/**
	 * 银行卡账号
	 */
	private String bankCardAccount;
	
	/**
	 * 提交时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date submitTime;

	/**
	 * 状态
	 */
	private String state;

	private String stateName;
	
	/**
	 * 备注
	 */
	private String note;
	
	/**
	 * 审核时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date approvalTime;
	
	/**
	 * 确认到帐时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date confirmCreditedTime;

	/**
	 * 用户账号id
	 */
	private String userAccountId;

	/**
	 * 用户名
	 */
	private String userName;


}
