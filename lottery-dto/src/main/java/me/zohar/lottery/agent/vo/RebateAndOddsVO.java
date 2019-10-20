package me.zohar.lottery.agent.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RebateAndOddsVO {

	private String id;

	/**
	 * 返点
	 */
	private Double rebate;

	/**
	 * 赔率
	 */
	private Double odds;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;


}
