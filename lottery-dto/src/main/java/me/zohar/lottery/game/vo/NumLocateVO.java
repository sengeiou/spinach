package me.zohar.lottery.game.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class NumLocateVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 号位名称
	 */
	private String numLocateName;

	/**
	 * 候选的号码集合,以逗号分隔
	 */
	private String nums;

	/**
	 * 最大可选多少个号码
	 */
	private Integer maxSelected;

	/**
	 * 是否有过滤按钮
	 */
	private Boolean hasFilterBtnFlag;

	/**
	 * 对应游戏玩法id
	 */
	private String gamePlayId;
	
	/**
	 * 候选号码集合
	 */
	private List<OptionalNumVO> optionalNums = new ArrayList<>();

}
