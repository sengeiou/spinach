package me.zohar.lottery.information.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LotteryInformationCrawlerVO {

	private String id;

	/**
	 * 来源
	 */
	private String source;

	/**
	 * 脚本
	 */
	private String script;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

}
