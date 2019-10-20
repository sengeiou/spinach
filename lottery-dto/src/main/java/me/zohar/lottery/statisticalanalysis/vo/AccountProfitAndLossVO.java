package me.zohar.lottery.statisticalanalysis.vo;

import lombok.Data;

@Data
public class AccountProfitAndLossVO {

	private String userAccountId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 账号类型
	 */
	private String accountType;

	private String accountTypeName;

	/**
	 * 账号级别
	 */
	private Integer accountLevel;

	/**
	 * 账号级别路径
	 */
	private String accountLevelPath;

	/**
	 * 余额
	 */
	private Double balance;

	private Double rechargeAmount;

	private Double withdrawAmount;

	private Double totalBettingAmount;

	private Double totalWinningAmount;

	private Double rebateAmount;

	private Double lowerLevelRebateAmount;

	private Double bettingProfitAndLoss;

}
