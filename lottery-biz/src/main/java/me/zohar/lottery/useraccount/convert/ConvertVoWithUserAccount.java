package me.zohar.lottery.useraccount.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.dictconfig.DictHolder;
import me.zohar.lottery.useraccount.domain.AccountChangeLog;
import me.zohar.lottery.useraccount.domain.LoginLog;
import me.zohar.lottery.useraccount.domain.UserAccount;
import me.zohar.lottery.useraccount.vo.AccountChangeLogVO;
import me.zohar.lottery.useraccount.vo.BankInfoVO;
import me.zohar.lottery.useraccount.vo.LoginAccountInfoVO;
import me.zohar.lottery.useraccount.vo.LoginLogVO;
import me.zohar.lottery.useraccount.vo.UserAccountDetailsInfoVO;
import me.zohar.lottery.useraccount.vo.UserAccountInfoVO;

public class ConvertVoWithUserAccount {
	
	public static List<AccountChangeLogVO> convertAccountChangeLog(List<AccountChangeLog> accountChangeLogs) {
		if (CollectionUtil.isEmpty(accountChangeLogs)) {
			return new ArrayList<>();
		}
		List<AccountChangeLogVO> vos = new ArrayList<>();
		for (AccountChangeLog accountChangeLog : accountChangeLogs) {
			vos.add(convertAccountChangeLog(accountChangeLog));
		}
		return vos;
	}

	public static AccountChangeLogVO convertAccountChangeLog(AccountChangeLog accountChangeLog) {
		if (accountChangeLog == null) {
			return null;
		}
		AccountChangeLogVO vo = new AccountChangeLogVO();
		BeanUtils.copyProperties(accountChangeLog, vo);
		vo.setGameName(DictHolder.getDictItemName("game", vo.getGameCode()));
		if (accountChangeLog.getUserAccount() != null) {
			vo.setUserName(accountChangeLog.getUserAccount().getUserName());
		}
		vo.setAccountChangeTypeName(DictHolder.getDictItemName("accountChangeType", vo.getAccountChangeTypeCode()));
		return vo;
	}
	
	public static BankInfoVO convertBankInfo(UserAccount userAccount) {
		if (userAccount == null) {
			return null;
		}
		BankInfoVO vo = new BankInfoVO();
		BeanUtils.copyProperties(userAccount, vo);
		return vo;
	}
	
	public static LoginAccountInfoVO convertLoginAccountInfo(UserAccount userAccount) {
		if (userAccount == null) {
			return null;
		}
		LoginAccountInfoVO vo = new LoginAccountInfoVO();
		BeanUtils.copyProperties(userAccount, vo);
		vo.setAccountTypeName(DictHolder.getDictItemName("accountType", vo.getAccountType()));
		return vo;
	}
	
	public static List<LoginLogVO> convertLoginLog(List<LoginLog> loginLogs) {
		if (CollectionUtil.isEmpty(loginLogs)) {
			return new ArrayList<>();
		}
		List<LoginLogVO> vos = new ArrayList<>();
		for (LoginLog loginLog : loginLogs) {
			vos.add(convertLoginLog(loginLog));
		}
		return vos;
	}

	public static LoginLogVO convertLoginLog(LoginLog loginLog) {
		if (loginLog == null) {
			return null;
		}
		LoginLogVO vo = new LoginLogVO();
		BeanUtils.copyProperties(loginLog, vo);
		vo.setStateName(DictHolder.getDictItemName("loginState", vo.getState()));
		return vo;
	}
	
	public static List<UserAccountDetailsInfoVO> convertUserAccountDetailsInfo(List<UserAccount> userAccounts) {
		if (CollectionUtil.isEmpty(userAccounts)) {
			return new ArrayList<>();
		}
		List<UserAccountDetailsInfoVO> vos = new ArrayList<>();
		for (UserAccount userAccount : userAccounts) {
			vos.add(convertUserAccountDetailsInfo(userAccount));
		}
		return vos;
	}

	public static UserAccountDetailsInfoVO convertUserAccountDetailsInfo(UserAccount userAccount) {
		if (userAccount == null) {
			return null;
		}
		UserAccountDetailsInfoVO vo = new UserAccountDetailsInfoVO();
		BeanUtils.copyProperties(userAccount, vo);
		vo.setAccountTypeName(DictHolder.getDictItemName("accountType", vo.getAccountType()));
		vo.setStateName(DictHolder.getDictItemName("accountState", vo.getState()));
		if (userAccount.getInviter() != null) {
			vo.setInviterUserName(userAccount.getInviter().getUserName());
		}
		return vo;
	}
	
	public static UserAccountInfoVO convertUserAccountInfo(UserAccount userAccount) {
		if (userAccount == null) {
			return null;
		}
		UserAccountInfoVO vo = new UserAccountInfoVO();
		BeanUtils.copyProperties(userAccount, vo);
		vo.setAccountTypeName(DictHolder.getDictItemName("accountType", vo.getAccountType()));
		return vo;
	}


}
