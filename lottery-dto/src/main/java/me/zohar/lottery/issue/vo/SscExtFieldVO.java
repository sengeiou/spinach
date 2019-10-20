package me.zohar.lottery.issue.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SscExtFieldVO extends LotteryHistoryExtFieldVO {

	/**
	 * 大小
	 */
	private String bigSmall;

	/**
	 * 单双
	 */
	private String singleDouble;

	private String sumLotteryNum;

	private String sumBigSmall;

	private String sumSingleDouble;

	/**
	 * 龙虎
	 */
	private String loongTiger;

}
