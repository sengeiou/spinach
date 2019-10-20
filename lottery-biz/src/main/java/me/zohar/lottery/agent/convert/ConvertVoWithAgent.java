package me.zohar.lottery.agent.convert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.agent.domain.InviteCode;
import me.zohar.lottery.agent.domain.RebateAndOdds;
import me.zohar.lottery.agent.domain.RebateAndOddsSituation;
import me.zohar.lottery.agent.vo.InviteCodeDetailsInfoVO;
import me.zohar.lottery.agent.vo.RebateAndOddsSituationVO;
import me.zohar.lottery.agent.vo.RebateAndOddsVO;
import me.zohar.lottery.dictconfig.ConfigHolder;

public class ConvertVoWithAgent {

	public static InviteCodeDetailsInfoVO convertInviteCodeDetailsInfo(InviteCode inviteCode) {
		if (inviteCode == null) {
			return null;
		}
		InviteCodeDetailsInfoVO vo = new InviteCodeDetailsInfoVO();
		BeanUtils.copyProperties(inviteCode, vo);
		vo.setValidFlag(vo.getPeriodOfValidity().getTime() > new Date().getTime());
		vo.setInviteRegisterLink(ConfigHolder.getConfigValue("register.inviteRegisterLink") + vo.getCode());
		return vo;
	}

	public static List<RebateAndOddsSituationVO> convertRebateAndOddsSituation(List<RebateAndOddsSituation> rebateAndOddsSituations) {
		if (CollectionUtil.isEmpty(rebateAndOddsSituations)) {
			return new ArrayList<>();
		}
		List<RebateAndOddsSituationVO> vos = new ArrayList<>();
		for (RebateAndOddsSituation rebateAndOddsSituation : rebateAndOddsSituations) {
			vos.add(convertRebateAndOddsSituation(rebateAndOddsSituation));
		}
		return vos;
	}

	public static RebateAndOddsSituationVO convertRebateAndOddsSituation(RebateAndOddsSituation rebateAndOddsSituation) {
		if (rebateAndOddsSituation == null) {
			return null;
		}
		RebateAndOddsSituationVO vo = new RebateAndOddsSituationVO();
		BeanUtils.copyProperties(rebateAndOddsSituation, vo);
		return vo;
	}

	public static List<RebateAndOddsVO> convertRebateAndOdds(List<RebateAndOdds> rebateAndOddses) {
		if (CollectionUtil.isEmpty(rebateAndOddses)) {
			return new ArrayList<>();
		}
		List<RebateAndOddsVO> vos = new ArrayList<>();
		for (RebateAndOdds rebateAndOdds : rebateAndOddses) {
			vos.add(convertRebateAndOdds(rebateAndOdds));
		}
		return vos;
	}

	public static RebateAndOddsVO convertRebateAndOdds(RebateAndOdds rebateAndOdds) {
		if (rebateAndOdds == null) {
			return null;
		}
		RebateAndOddsVO vo = new RebateAndOddsVO();
		BeanUtils.copyProperties(rebateAndOdds, vo);
		return vo;
	}

}
