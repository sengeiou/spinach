package me.zohar.lottery.dictconfig.vo;

import lombok.Data;

@Data
public class DictTypeVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 字典类型code
	 */
	private String dictTypeCode;

	/**
	 * 字典类型名称
	 */
	private String dictTypeName;

	/**
	 * 备注
	 */
	private String note;

}
