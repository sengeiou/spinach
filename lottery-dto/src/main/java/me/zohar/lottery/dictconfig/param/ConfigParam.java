package me.zohar.lottery.dictconfig.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ConfigParam {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 配置项code
	 */
	@NotBlank
	private String configCode;

	/**
	 * 配置项名称
	 */
	@NotBlank
	private String configName;

	/**
	 * 配置项值
	 */
	@NotBlank
	private String configValue;
	
}
