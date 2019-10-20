package me.zohar.lottery.betting.convert;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.util.NumberUtil;
import me.zohar.lottery.betting.domain.BettingOrder;
import me.zohar.lottery.betting.domain.BettingRecord;
import me.zohar.lottery.betting.domain.TrackingNumberContent;
import me.zohar.lottery.betting.domain.TrackingNumberOrder;
import me.zohar.lottery.betting.domain.TrackingNumberPlan;
import me.zohar.lottery.betting.param.BettingRecordParam;
import me.zohar.lottery.betting.param.PlaceOrderParam;
import me.zohar.lottery.betting.param.StartTrackingNumberParam;
import me.zohar.lottery.betting.param.StartTrackingNumberParam.TrackingNumberPlanParam;
import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.constants.Constant;

public class ConvertPoWithBetting {

	public static BettingRecord convertToPo(BettingRecordParam param, Double bettingAmount, Double odds) {
		BettingRecord po = new BettingRecord();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setBettingAmount(bettingAmount);
		po.setOdds(odds);
		po.setWinningAmount(0d);
		po.setProfitAndLoss(-bettingAmount);
		return po;
	}

	public static TrackingNumberContent convertToPo(BettingRecordParam param, String trackingNumberOrderId) {
		TrackingNumberContent po = new TrackingNumberContent();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setTrackingNumberOrderId(trackingNumberOrderId);
		return po;
	}

	public static BettingOrder convertToPo(PlaceOrderParam param, String issueId, Long totalBettingCount,
			Double totalBettingAmount, String userAccountId) {
		BettingOrder po = new BettingOrder();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setOrderNo(po.getGameCode() + po.getId());
		po.setBettingTime(new Date());
		po.setIssueId(issueId);
		po.setTotalBettingAmount(totalBettingAmount);
		po.setTotalBettingCount(totalBettingCount);
		po.setTotalWinningAmount(0d);
		po.setTotalProfitAndLoss(-totalBettingAmount);
		po.setRebateAmount(NumberUtil.round(po.getRebate() * 0.01 * totalBettingAmount, 4).doubleValue());
		po.setState(Constant.投注订单状态_未开奖);
		po.setUserAccountId(userAccountId);
		return po;
	}

	public static TrackingNumberOrder convertToPo(StartTrackingNumberParam param, Long startIssueNum,
			Double totalBettingAmount, String userAccountId) {
		TrackingNumberOrder po = new TrackingNumberOrder();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setOrderNo(po.getId());
		po.setStartIssueNum(startIssueNum);
		po.setTrackingNumberTime(new Date());
		po.setTotalBettingAmount(NumberUtil.round(totalBettingAmount, 4).doubleValue());
		po.setUserAccountId(userAccountId);
		return po;
	}

	public static TrackingNumberPlan convertToPo(TrackingNumberPlanParam param, String trackingNumberOrderId) {
		TrackingNumberPlan po = new TrackingNumberPlan();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setTrackingNumberOrderId(trackingNumberOrderId);
		return po;
	}

}
