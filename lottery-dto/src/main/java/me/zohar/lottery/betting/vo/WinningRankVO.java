package me.zohar.lottery.betting.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class WinningRankVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private String id;

	private String gameName;

	/**
	 * 期号
	 */
	private Long issueNum;

	private String userName;

	/**
	 * 总中奖金额
	 */
	private Double totalWinningAmount;

}
