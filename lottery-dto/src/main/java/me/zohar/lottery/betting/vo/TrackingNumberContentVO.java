package me.zohar.lottery.betting.vo;

import lombok.Data;

@Data
public class TrackingNumberContentVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 游戏玩法代码
	 */
	private String gamePlayCode;

	/**
	 * 游戏玩法名称
	 */
	private String gamePlayName;

	/**
	 * 所选号码
	 */
	private String selectedNo;

	/**
	 * 注数
	 */
	private Long bettingCount;


}
