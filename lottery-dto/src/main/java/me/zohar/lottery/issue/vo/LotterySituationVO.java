package me.zohar.lottery.issue.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotterySituationVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 所属游戏代码
	 */
	private String gameCode;

	/**
	 * 所属游戏名称
	 */
	private String gameName;

	/**
	 * 期数
	 */
	private Long issueNum;

	/**
	 * 开奖日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lotteryDate;

	/**
	 * 开奖时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lotteryTime;

	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;

	/**
	 * 全部开奖号码,以逗号分隔
	 */
	private String lotteryNum;

	/**
	 * 同步时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date syncTime;

	/**
	 * 结算时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date settlementTime;

	/**
	 * 状态
	 */
	private String state;

	private String stateName;
	
	/**
	 * 自动开奖
	 */
	private Boolean automaticLottery;
	
	/**
	 * 自动结算
	 */
	private Boolean automaticSettlement;

	/**
	 * 总投注金额
	 */
	private Double totalBettingAmount;

	/**
	 * 总中奖金额
	 */
	private Double totalWinningAmount;

}
