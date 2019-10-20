package me.zohar.lottery.useraccount.convert;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.constants.Constant;
import me.zohar.lottery.useraccount.domain.UserAccount;
import me.zohar.lottery.useraccount.param.AddUserAccountParam;
import me.zohar.lottery.useraccount.param.UserAccountRegisterParam;

public class ConvertPoWithUserAccount {

	public static UserAccount convertToPo(AddUserAccountParam param) {
		UserAccount po = new UserAccount();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setAccountLevel(0);
		po.setAccountLevelPath(po.getId());
		po.setBalance(0d);
		po.setRegisteredTime(new Date());
		po.setMoneyPwd(po.getLoginPwd());
		return po;
	}
	
	public static UserAccount convertToPo(UserAccountRegisterParam param) {
		UserAccount po = new UserAccount();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setRegisteredTime(new Date());
		po.setMoneyPwd(po.getLoginPwd());
		po.setState(Constant.账号状态_启用);
		po.setAccountType(Constant.账号类型_会员);
		po.setBalance(0d);
		po.setAccountLevelPath(po.getId());
		return po;
	}


}
