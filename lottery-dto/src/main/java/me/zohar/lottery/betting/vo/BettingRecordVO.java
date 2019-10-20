package me.zohar.lottery.betting.vo;

import lombok.Data;

/**
 * 投注记录
 * 
 * @author zohar
 * @date 2019年1月19日
 *
 */
@Data
public class BettingRecordVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 所选号码
	 */
	private String selectedNo;

	/**
	 * 注数
	 */
	private Long bettingCount;

	/**
	 * 游戏玩法代码
	 */
	private String gamePlayCode;

	/**
	 * 游戏玩法名称
	 */
	private String gamePlayName;

	/**
	 * 投注金额
	 */
	private Double bettingAmount;

	/**
	 * 中奖金额
	 */
	private Double winningAmount;

	/**
	 * 投注订单id
	 */
	private String bettingOrderId;

	/**
	 * 期号
	 */
	private Long issueNum;

	/**
	 * 状态名称
	 */
	private String stateName;

}
