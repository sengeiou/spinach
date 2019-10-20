package me.zohar.lottery.game.vo;

import lombok.Data;

@Data
public class OptionalNumVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 号码
	 */
	private String num;

	/**
	 * 赔率
	 */
	private Double odds;

	/**
	 * 排序号
	 */
	private Double orderNo;

	/**
	 * 对应号位id
	 */
	private String numLocateId;

}
