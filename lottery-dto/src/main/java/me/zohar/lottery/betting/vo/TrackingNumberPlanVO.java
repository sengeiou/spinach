package me.zohar.lottery.betting.vo;

import lombok.Data;

@Data
public class TrackingNumberPlanVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 期号
	 */
	private Long issueNum;

	/**
	 * 倍数
	 */
	private Double multiple;

	/**
	 * 全部开奖号码,以逗号分隔
	 */
	private String lotteryNum;

	/**
	 * 总投注金额
	 */
	private Double totalBettingAmount;

	/**
	 * 总中奖金额
	 */
	private Double totalWinningAmount;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 状态名称
	 */
	private String stateName;

	private String bettingOrderId;

	private Boolean cancelOrderFlag = false;


}
