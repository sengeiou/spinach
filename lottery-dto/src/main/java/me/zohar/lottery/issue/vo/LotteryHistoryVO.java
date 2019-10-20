package me.zohar.lottery.issue.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 开奖历史
 * 
 * @author zohar
 * @date 2019年6月16日
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotteryHistoryVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 期数
	 */
	private Long issueNum;

	/**
	 * 开奖时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lotteryTime;

	/**
	 * 全部开奖号码,以逗号分隔
	 */
	private String lotteryNum;

	/**
	 * 扩展字段
	 */
	private LotteryHistoryExtFieldVO extField;

}
