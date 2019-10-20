package me.zohar.lottery.dictconfig.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class ConfigItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 配置项code
	 */
	private String configCode;

	/**
	 * 配置项名称
	 */
	private String configName;

	/**
	 * 配置项值
	 */
	private String configValue;

}
