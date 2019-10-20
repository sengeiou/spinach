package me.zohar.lottery.issue.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueSettingDetailsVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 所属游戏id
	 */
	private String gameId;

	/**
	 * 日期格式
	 */
	private String dateFormat;

	/**
	 * 期号格式
	 */
	private String issueFormat;

	private List<IssueGenerateRuleVO> issueGenerateRules = new ArrayList<>();

}
