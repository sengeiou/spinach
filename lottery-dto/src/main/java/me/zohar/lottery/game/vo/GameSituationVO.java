package me.zohar.lottery.game.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GameSituationVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 游戏代码
	 */
	private String gameCode;

	/**
	 * 游戏名称
	 */
	private String gameName;

	private String gameCategoryId;

	private String gameCategoryCode;

	private String gameCategoryName;

	private Boolean hotGameFlag;

	/**
	 * 总期数
	 */
	private Long issueCount;

	/**
	 * 当前期
	 */
	private Long currentIssue;

	private Long currentIssueInner;

	/**
	 * 当前期结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date currentIssueEndTime;

	/**
	 * 上一期
	 */
	private Long preIssue;

	/**
	 * 上一期开奖号码
	 */
	private String preIssueLotteryNum;

	/**
	 * 下一期
	 */
	private Long nextIssue;

	/**
	 * 下一期结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date nextIssueEndTime;

}
