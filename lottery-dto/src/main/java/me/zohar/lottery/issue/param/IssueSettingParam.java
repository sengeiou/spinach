package me.zohar.lottery.issue.param;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class IssueSettingParam {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 所属游戏id
	 */
	@NotBlank
	private String gameId;

	/**
	 * 日期格式
	 */
	@NotBlank
	private String dateFormat;

	/**
	 * 期号格式
	 */
	@NotBlank
	private String issueFormat;

	/**
	 * 期号生成规则集合
	 */
	@NotEmpty
	private List<IssueGenerateRuleParam> issueGenerateRules;

}
