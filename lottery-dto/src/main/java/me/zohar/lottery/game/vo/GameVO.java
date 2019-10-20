package me.zohar.lottery.game.vo;

import lombok.Data;

@Data
public class GameVO {

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

	/**
	 * 游戏说明
	 */
	private String gameDesc;

	private Boolean hotGameFlag;

	/**
	 * 状态
	 */
	private String state;

	private String stateName;

	/**
	 * 排序号
	 */
	private Double orderNo;

	/**
	 * 游戏类别id
	 */
	private String gameCategoryId;

	private String gameCategoryCode;

	private String gameCategoryName;

}
