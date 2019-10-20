package me.zohar.lottery.issue.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueGenerateRuleVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 开始时间(时分,如10:00)
	 */
	private String startTime;

	/**
	 * 时间间隔(分钟)
	 */
	private Integer timeInterval;

	/**
	 * 期数
	 */
	private Integer issueCount;

	/**
	 * 排序号
	 */
	private Double orderNo;

	/**
	 * 对应期号设置id
	 */
	private String issueSettingId;

}
