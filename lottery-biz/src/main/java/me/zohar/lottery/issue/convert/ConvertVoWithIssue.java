package me.zohar.lottery.issue.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import me.zohar.lottery.dictconfig.DictHolder;
import me.zohar.lottery.issue.domain.Issue;
import me.zohar.lottery.issue.domain.IssueGenerateRule;
import me.zohar.lottery.issue.domain.IssueSetting;
import me.zohar.lottery.issue.domain.LotterySituation;
import me.zohar.lottery.issue.vo.IssueGenerateRuleVO;
import me.zohar.lottery.issue.vo.IssueSettingDetailsVO;
import me.zohar.lottery.issue.vo.IssueVO;
import me.zohar.lottery.issue.vo.LotteryHistoryVO;
import me.zohar.lottery.issue.vo.LotterySituationVO;
import me.zohar.lottery.issue.vo.SscExtFieldVO;

public class ConvertVoWithIssue {
	
	public static SscExtFieldVO convertSscExtField(Issue issue) {
		if (StrUtil.isBlank(issue.getLotteryNum())) {
			return new SscExtFieldVO();
		}
		List<String> bigSmall = new ArrayList<>();
		List<String> singleDouble = new ArrayList<>();
		long sumLotteryNum = 0L;
		long firstNum = 0L;
		long fifthNum = 0L;
		String[] lotteryNums = issue.getLotteryNum().split(",");
		for (int i = 0; i < lotteryNums.length; i++) {
			long lotteryNum = Long.parseLong(lotteryNums[i]);
			bigSmall.add(lotteryNum <= 4 ? "小" : "大");
			singleDouble.add(lotteryNum % 2 == 0 ? "双" : "单");
			sumLotteryNum += lotteryNum;
			if (i == 0) {
				firstNum = lotteryNum;
			}
			if (i == 4) {
				fifthNum = lotteryNum;
			}
		}
		int loongTigerCompare = Long.compare(firstNum, fifthNum);

		SscExtFieldVO vo = new SscExtFieldVO();
		vo.setBigSmall(String.join(",", bigSmall));
		vo.setSingleDouble(String.join(",", singleDouble));
		vo.setSumLotteryNum(String.valueOf(sumLotteryNum));
		vo.setSumBigSmall(sumLotteryNum <= 22 ? "小" : "大");
		vo.setSumSingleDouble(sumLotteryNum % 2 == 0 ? "双" : "单");
		vo.setLoongTiger(loongTigerCompare == 0 ? "和" : loongTigerCompare > 0 ? "龙" : "虎");
		return vo;
	}
	
	public static List<LotterySituationVO> convertLotterySituation(List<LotterySituation> lotterySituations) {
		if (CollectionUtil.isEmpty(lotterySituations)) {
			return new ArrayList<>();
		}
		List<LotterySituationVO> vos = new ArrayList<>();
		for (LotterySituation lotterySituation : lotterySituations) {
			vos.add(convertLotterySituation(lotterySituation));
		}
		return vos;
	}

	public static LotterySituationVO convertLotterySituation(LotterySituation lotterySituation) {
		if (lotterySituation == null) {
			return null;
		}
		LotterySituationVO vo = new LotterySituationVO();
		BeanUtils.copyProperties(lotterySituation, vo);
		vo.setGameName(DictHolder.getDictItemName("game", vo.getGameCode()));
		vo.setStateName(DictHolder.getDictItemName("issueState", vo.getState()));
		return vo;
	}

	
	public static List<LotteryHistoryVO> convertLotteryHistory(List<Issue> issues) {
		if (CollectionUtil.isEmpty(issues)) {
			return new ArrayList<>();
		}
		List<LotteryHistoryVO> vos = new ArrayList<>();
		for (Issue issue : issues) {
			vos.add(convertLotteryHistory(issue));
		}
		return vos;
	}

	public static LotteryHistoryVO convertLotteryHistory(Issue issue) {
		if (issue == null) {
			return null;
		}
		LotteryHistoryVO vo = new LotteryHistoryVO();
		BeanUtils.copyProperties(issue, vo);
		vo.setExtField(convertSscExtField(issue));
		return vo;
	}
	
	public static List<IssueGenerateRuleVO> convertIssueGenerateRule(Collection<IssueGenerateRule> issueGenerateRules) {
		if (CollectionUtil.isEmpty(issueGenerateRules)) {
			return new ArrayList<>();
		}
		List<IssueGenerateRuleVO> vos = new ArrayList<>();
		for (IssueGenerateRule issueGenerateRule : issueGenerateRules) {
			vos.add(convertIssueGenerateRule(issueGenerateRule));
		}
		return vos;
	}

	public static IssueGenerateRuleVO convertIssueGenerateRule(IssueGenerateRule issueGenerateRule) {
		if (issueGenerateRule == null) {
			return null;
		}
		IssueGenerateRuleVO vo = new IssueGenerateRuleVO();
		BeanUtils.copyProperties(issueGenerateRule, vo);
		return vo;
	}
	
	public static IssueSettingDetailsVO convertIssueSettingDetails(IssueSetting issueSetting) {
		if (issueSetting == null) {
			return null;
		}
		IssueSettingDetailsVO vo = new IssueSettingDetailsVO();
		BeanUtils.copyProperties(issueSetting, vo);
		vo.setIssueGenerateRules(convertIssueGenerateRule(issueSetting.getIssueGenerateRules()));
		return vo;
	}
	
	public static List<IssueVO> convertIssue(List<Issue> issues) {
		if (CollectionUtil.isEmpty(issues)) {
			return new ArrayList<>();
		}
		List<IssueVO> vos = new ArrayList<>();
		for (Issue issue : issues) {
			vos.add(convertIssue(issue));
		}
		return vos;
	}

	public static IssueVO convertIssue(Issue issue) {
		if (issue == null) {
			return null;
		}
		IssueVO vo = new IssueVO();
		BeanUtils.copyProperties(issue, vo);
		vo.setGameName(DictHolder.getDictItemName("game", vo.getGameCode()));
		vo.setStateName(DictHolder.getDictItemName("issueState", vo.getState()));
		return vo;
	}
	
	


}
