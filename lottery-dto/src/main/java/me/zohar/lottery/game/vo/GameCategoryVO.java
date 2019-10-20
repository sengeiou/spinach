package me.zohar.lottery.game.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class GameCategoryVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	/**
	 * 游戏类别code
	 */
	private String gameCategoryCode;

	/**
	 * 游戏类别
	 */
	private String gameCategoryName;

	/**
	 * 排序号
	 */
	private Double orderNo;

}
