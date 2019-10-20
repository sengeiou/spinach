package me.zohar.lottery.agent.convert;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import me.zohar.lottery.agent.domain.InviteCode;
import me.zohar.lottery.agent.domain.RebateAndOdds;
import me.zohar.lottery.agent.param.AddOrUpdateRebateAndOddsParam;
import me.zohar.lottery.agent.param.AgentOpenAnAccountParam;
import me.zohar.lottery.agent.param.GenerateInviteCodeParam;
import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.constants.Constant;
import me.zohar.lottery.useraccount.domain.UserAccount;

public class ConvertPoWithAgent {

	public static RebateAndOdds convertToPo(AddOrUpdateRebateAndOddsParam param) {
		RebateAndOdds po = new RebateAndOdds();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setCreateTime(new Date());
		return po;
	}

	public static UserAccount convertToPo(AgentOpenAnAccountParam param, Integer accountLevel) {
		UserAccount po = new UserAccount();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setAccountType(Constant.账号类型_代理);
		po.setAccountLevel(accountLevel);
		po.setMoneyPwd(po.getLoginPwd());
		po.setBalance(0d);
		po.setState(Constant.账号状态_启用);
		po.setRegisteredTime(new Date());
		return po;
	}

	public static InviteCode convertToPo(GenerateInviteCodeParam param, String code, Integer effectiveDuration) {
		InviteCode po = new InviteCode();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setCode(code);
		po.setCreateTime(new Date());
		po.setPeriodOfValidity(DateUtil.offset(po.getCreateTime(), DateField.DAY_OF_YEAR, effectiveDuration));
		return po;
	}

}
