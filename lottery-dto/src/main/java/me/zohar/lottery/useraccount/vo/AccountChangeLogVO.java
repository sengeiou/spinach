package me.zohar.lottery.useraccount.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AccountChangeLogVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 游戏代码
	 */
	private String gameCode;

	/**
	 * 游戏名称
	 */
	private String gameName;

	/**
	 * 期号
	 */
	private Long issueNum;

	/**
	 * 账变时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date accountChangeTime;

	/**
	 * 账变类型代码
	 */
	private String accountChangeTypeCode;

	/**
	 * 账变类型名称
	 */
	private String accountChangeTypeName;

	/**
	 * 账变金额
	 */
	private Double accountChangeAmount;

	/**
	 * 余额
	 */
	private Double balance;
	
	/**
	 * 备注
	 */
	private String note;

	/**
	 * 用户账号id
	 */
	private String userAccountId;

	/**
	 * 用户名
	 */
	private String userName;

}
