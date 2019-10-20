package me.zohar.lottery.game.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GamePlayVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * 赔率
	 */
	private Double odds;

	/**
	 * 赔率模式
	 */
	private String oddsMode;

	/**
	 * 玩法描述
	 */
	private String gamePlayDesc;

	/**
	 * 排序号
	 */
	private Double orderNo;

	/**
	 * 所属游戏代码
	 */
	private String gameCode;

	/**
	 * 状态,启用:1;禁用:0
	 */
	private String state;

	/**
	 * 状态中文值
	 */
	private String stateName;

	/**
	 * 所属游戏玩法类别名称
	 */
	private String gamePlayCategoryName;

	/**
	 * 所属游戏子玩法类别名称
	 */
	private String subGamePlayCategoryName;

	/**
	 * 号位集合
	 */
	private List<NumLocateVO> numLocates = new ArrayList<>();

}
