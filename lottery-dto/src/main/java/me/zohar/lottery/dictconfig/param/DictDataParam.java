package me.zohar.lottery.dictconfig.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DictDataParam {

	/**
	 * 字典项code
	 */
	@NotBlank
	private String dictItemCode;

	/**
	 * 字典项名称
	 */
	@NotBlank
	private String dictItemName;

}
