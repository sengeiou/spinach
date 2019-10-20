package me.zohar.lottery.betting.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 投注订单信息
 * 
 * @author zohar
 * @date 2019年1月19日
 *
 */
@Data
public class BettingOrderInfoVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 投注时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date bettingTime;

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
	 * 总投注金额
	 */
	private Double totalBettingAmount;

	/**
	 * 总中奖金额
	 */
	private Double totalWinningAmount;

	/**
	 * 总盈亏
	 */
	private Double totalProfitAndLoss;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 状态名称
	 */
	private String stateName;

	/**
	 * 投注人用户账号id
	 */
	private String userAccountId;

	/**
	 * 投注人用户名
	 */
	private String userName;

	private Boolean cancelOrderFlag = false;

}
