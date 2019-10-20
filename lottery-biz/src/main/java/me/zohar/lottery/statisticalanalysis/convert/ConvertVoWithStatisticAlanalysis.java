package me.zohar.lottery.statisticalanalysis.convert;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.dictconfig.DictHolder;
import me.zohar.lottery.statisticalanalysis.vo.AccountProfitAndLossVO;

public class ConvertVoWithStatisticAlanalysis {
	
	public static List<AccountProfitAndLossVO> convertFor(List<Object[]> result) {
		if (CollectionUtil.isEmpty(result)) {
			return new ArrayList<>();
		}
		List<AccountProfitAndLossVO> vos = new ArrayList<>();
		for (Object[] object : result) {
			vos.add(convertFor(object));
		}
		return vos;
	}

	public static AccountProfitAndLossVO convertFor(Object[] object) {
		if (object == null) {
			return null;
		}
		AccountProfitAndLossVO vo = new AccountProfitAndLossVO();
		vo.setUserAccountId((String) object[0]);
		vo.setUserName((String) object[1]);
		vo.setAccountType((String) object[2]);
		vo.setAccountLevel((Integer) object[3]);
		vo.setAccountLevelPath((String) object[4]);
		vo.setBalance((Double) object[5]);
		vo.setRechargeAmount((Double) object[6]);
		vo.setWithdrawAmount((Double) object[7]);
		vo.setTotalBettingAmount((Double) object[8]);
		vo.setTotalWinningAmount((Double) object[9]);
		vo.setRebateAmount((Double) object[10]);
		vo.setLowerLevelRebateAmount((Double) object[11]);
		vo.setBettingProfitAndLoss((Double) object[12]);
		vo.setAccountTypeName(DictHolder.getDictItemName("accountType", vo.getAccountType()));
		return vo;
	}


}
