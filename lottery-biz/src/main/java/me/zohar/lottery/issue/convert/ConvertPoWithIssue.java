package me.zohar.lottery.issue.convert;

import org.springframework.beans.BeanUtils;

import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.issue.domain.IssueGenerateRule;
import me.zohar.lottery.issue.domain.IssueSetting;
import me.zohar.lottery.issue.param.IssueGenerateRuleParam;
import me.zohar.lottery.issue.param.IssueSettingParam;

public class ConvertPoWithIssue {

	public static IssueGenerateRule convertToPo(IssueGenerateRuleParam param) {
		IssueGenerateRule po = new IssueGenerateRule();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

	public static IssueSetting convertToPo(IssueSettingParam param) {
		IssueSetting po = new IssueSetting();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

}
