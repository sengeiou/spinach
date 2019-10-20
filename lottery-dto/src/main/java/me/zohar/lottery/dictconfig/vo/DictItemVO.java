package me.zohar.lottery.dictconfig.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class DictItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 字典项code
	 */
	private String dictItemCode;

	/**
	 * 字典项名称
	 */
	private String dictItemName;

	/**
	 * 排序号
	 */
	private Double orderNo;

}
