package me.zohar.lottery.rechargewithdraw.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.constants.Constant;
import me.zohar.lottery.dictconfig.DictHolder;
import me.zohar.lottery.rechargewithdraw.domain.RechargeOrder;
import me.zohar.lottery.rechargewithdraw.domain.RechargeWithdrawLog;
import me.zohar.lottery.rechargewithdraw.domain.WithdrawRecord;
import me.zohar.lottery.rechargewithdraw.vo.RechargeOrderVO;
import me.zohar.lottery.rechargewithdraw.vo.RechargeWithdrawLogVO;
import me.zohar.lottery.rechargewithdraw.vo.WithdrawRecordVO;

public class ConvertVoWithRechargeWithdraw {

	public static List<RechargeOrderVO> convertRechargeOrder(List<RechargeOrder> rechargeOrders) {
		if (CollectionUtil.isEmpty(rechargeOrders)) {
			return new ArrayList<>();
		}
		List<RechargeOrderVO> vos = new ArrayList<>();
		for (RechargeOrder rechargeOrder : rechargeOrders) {
			vos.add(convertRechargeOrder(rechargeOrder));
		}
		return vos;
	}

	public static RechargeOrderVO convertRechargeOrder(RechargeOrder rechargeOrder) {
		if (rechargeOrder == null) {
			return null;
		}
		RechargeOrderVO vo = new RechargeOrderVO();
		BeanUtils.copyProperties(rechargeOrder, vo);
		vo.setOrderStateName(DictHolder.getDictItemName("rechargeOrderState", vo.getOrderState()));
		vo.setRechargeWayName(DictHolder.getDictItemName("rechargeWay", vo.getRechargeWayCode()));
		if (rechargeOrder.getUserAccount() != null) {
			vo.setUserName(rechargeOrder.getUserAccount().getUserName());
		}
		return vo;
	}

	public static List<RechargeWithdrawLogVO> convertRechargeWithdrawLog(
			List<RechargeWithdrawLog> rechargeWithdrawLogs) {
		if (CollectionUtil.isEmpty(rechargeWithdrawLogs)) {
			return new ArrayList<>();
		}
		List<RechargeWithdrawLogVO> vos = new ArrayList<>();
		for (RechargeWithdrawLog rechargeWithdrawLog : rechargeWithdrawLogs) {
			vos.add(convertRechargeWithdrawLog(rechargeWithdrawLog));
		}
		return vos;
	}

	public static RechargeWithdrawLogVO convertRechargeWithdrawLog(RechargeWithdrawLog rechargeWithdrawLog) {
		if (rechargeWithdrawLog == null) {
			return null;
		}
		RechargeWithdrawLogVO vo = new RechargeWithdrawLogVO();
		BeanUtils.copyProperties(rechargeWithdrawLog, vo);
		vo.setOrderTypeName(DictHolder.getDictItemName("rechargeWithdrawLogOrderType", vo.getOrderType()));
		if (Constant.充提日志订单类型_充值.equals(vo.getOrderType())) {
			vo.setOrderStateName(DictHolder.getDictItemName("rechargeOrderState", vo.getOrderState()));
		} else {
			vo.setOrderStateName(DictHolder.getDictItemName("withdrawRecordState", vo.getOrderState()));
		}
		return vo;
	}

	public static List<WithdrawRecordVO> convertWithdrawRecord(List<WithdrawRecord> withdrawRecords) {
		if (CollectionUtil.isEmpty(withdrawRecords)) {
			return new ArrayList<>();
		}
		List<WithdrawRecordVO> vos = new ArrayList<>();
		for (WithdrawRecord withdrawRecord : withdrawRecords) {
			vos.add(convertWithdrawRecord(withdrawRecord));
		}
		return vos;
	}

	public static WithdrawRecordVO convertWithdrawRecord(WithdrawRecord withdrawRecord) {
		if (withdrawRecord == null) {
			return null;
		}
		WithdrawRecordVO vo = new WithdrawRecordVO();
		BeanUtils.copyProperties(withdrawRecord, vo);
		vo.setStateName(DictHolder.getDictItemName("withdrawRecordState", vo.getState()));
		if (withdrawRecord.getUserAccount() != null) {
			vo.setUserName(withdrawRecord.getUserAccount().getUserName());
		}
		return vo;
	}

}
