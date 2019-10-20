package me.zohar.lottery.rechargewithdraw.convert;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.constants.Constant;
import me.zohar.lottery.rechargewithdraw.domain.RechargeOrder;
import me.zohar.lottery.rechargewithdraw.domain.WithdrawRecord;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderParam;
import me.zohar.lottery.rechargewithdraw.param.StartWithdrawParam;

public class ConvertPoWithRechargeWithdraw {

	public static RechargeOrder convertToPo(RechargeOrderParam param, Integer orderEffectiveDuration) {
		RechargeOrder po = new RechargeOrder();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setSubmitTime(new Date());
		po.setUsefulTime(DateUtil.offset(po.getSubmitTime(), DateField.MINUTE, orderEffectiveDuration));
		po.setOrderNo(po.getId());
		po.setOrderState(Constant.充值订单状态_待支付);
		return po;
	}

	public static WithdrawRecord convertToPo(StartWithdrawParam param) {
		WithdrawRecord po = new WithdrawRecord();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setOrderNo(po.getId());
		po.setSubmitTime(new Date());
		po.setState(Constant.提现记录状态_发起提现);
		return po;
	}

}
