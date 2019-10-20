package me.zohar.lottery.dictconfig.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AddOrUpdateDictTypeParam {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 字典类型code
	 */
	@NotBlank
	private String dictTypeCode;

	/**
	 * 字典类型名称
	 */
	@NotBlank
	private String dictTypeName;

	/**
	 * 备注
	 */
	private String note;
	
}
