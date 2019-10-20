package me.zohar.lottery.information.param;

import lombok.Data;

@Data
public class AddOrUpdateInformationCrawlerParam {

	private String id;

	/**
	 * 来源
	 */
	private String source;

	/**
	 * 脚本
	 */
	private String script;

}
