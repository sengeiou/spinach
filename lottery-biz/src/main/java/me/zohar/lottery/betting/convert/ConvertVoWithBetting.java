package me.zohar.lottery.betting.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.betting.domain.BettingOrder;
import me.zohar.lottery.betting.domain.BettingRecord;
import me.zohar.lottery.betting.domain.TrackingNumberContent;
import me.zohar.lottery.betting.domain.TrackingNumberPlan;
import me.zohar.lottery.betting.domain.TrackingNumberSituation;
import me.zohar.lottery.betting.vo.BettingOrderDetailsVO;
import me.zohar.lottery.betting.vo.BettingOrderInfoVO;
import me.zohar.lottery.betting.vo.BettingRecordVO;
import me.zohar.lottery.betting.vo.TrackingNumberContentVO;
import me.zohar.lottery.betting.vo.TrackingNumberOrderDetailsVO;
import me.zohar.lottery.betting.vo.TrackingNumberPlanVO;
import me.zohar.lottery.betting.vo.TrackingNumberSituationVO;
import me.zohar.lottery.betting.vo.WinningRankVO;
import me.zohar.lottery.constants.Constant;
import me.zohar.lottery.dictconfig.DictHolder;

public class ConvertVoWithBetting {

	public static BettingOrderDetailsVO convertBettingOrderDetails(BettingOrder bettingOrder) {
		if (bettingOrder == null) {
			return null;
		}
		BettingOrderDetailsVO vo = new BettingOrderDetailsVO();
		BeanUtils.copyProperties(bettingOrder, vo);
		vo.setGameName(DictHolder.getDictItemName("game", vo.getGameCode()));
		vo.setStateName(DictHolder.getDictItemName("bettingOrderState", vo.getState()));
		if (bettingOrder.getUserAccount() != null) {
			vo.setUserName(bettingOrder.getUserAccount().getUserName());
		}
		if (Constant.投注订单状态_未开奖.equals(bettingOrder.getState())) {
			if (bettingOrder.getIssue() != null) {
				if (new Date().getTime() < bettingOrder.getIssue().getEndTime().getTime()) {
					vo.setCancelOrderFlag(true);
				}
			}
		}
		vo.setBettingRecords(convertBettingRecord(bettingOrder.getBettingRecords()));
		return vo;
	}

	public static List<BettingOrderInfoVO> convertBettingOrderInfo(Collection<BettingOrder> bettingOrders) {
		if (CollectionUtil.isEmpty(bettingOrders)) {
			return new ArrayList<>();
		}
		List<BettingOrderInfoVO> vos = new ArrayList<>();
		for (BettingOrder bettingOrder : bettingOrders) {
			vos.add(convertBettingOrderInfo(bettingOrder));
		}
		return vos;
	}

	public static BettingOrderInfoVO convertBettingOrderInfo(BettingOrder bettingOrder) {
		if (bettingOrder == null) {
			return null;
		}
		BettingOrderInfoVO vo = new BettingOrderInfoVO();
		BeanUtils.copyProperties(bettingOrder, vo);
		vo.setGameName(DictHolder.getDictItemName("game", vo.getGameCode()));
		vo.setStateName(DictHolder.getDictItemName("bettingOrderState", vo.getState()));
		if (bettingOrder.getUserAccount() != null) {
			vo.setUserName(bettingOrder.getUserAccount().getUserName());
		}
		if (Constant.投注订单状态_未开奖.equals(bettingOrder.getState())) {
			if (bettingOrder.getIssue() != null) {
				if (new Date().getTime() < bettingOrder.getIssue().getEndTime().getTime()) {
					vo.setCancelOrderFlag(true);
				}
			}
		}
		return vo;
	}

	public static List<BettingRecordVO> convertBettingRecord(Collection<BettingRecord> bettingRecords) {
		if (CollectionUtil.isEmpty(bettingRecords)) {
			return new ArrayList<>();
		}
		List<BettingRecordVO> vos = new ArrayList<>();
		for (BettingRecord bettingRecord : bettingRecords) {
			vos.add(convertBettingRecord(bettingRecord));
		}
		return vos;
	}

	public static BettingRecordVO convertBettingRecord(BettingRecord bettingRecord) {
		if (bettingRecord == null) {
			return null;
		}
		BettingRecordVO vo = new BettingRecordVO();
		BeanUtils.copyProperties(bettingRecord, vo);
		vo.setGamePlayName(DictHolder.getDictItemName("gamePlay",
				bettingRecord.getBettingOrder().getGameCode() + "_" + bettingRecord.getGamePlayCode()));
		vo.setIssueNum(bettingRecord.getBettingOrder().getIssueNum());
		vo.setStateName(DictHolder.getDictItemName("bettingOrderState", bettingRecord.getBettingOrder().getState()));
		return vo;
	}

	public static List<TrackingNumberContentVO> convertTrackingNumberContent(
			Collection<TrackingNumberContent> trackingNumberContents) {
		if (CollectionUtil.isEmpty(trackingNumberContents)) {
			return new ArrayList<>();
		}
		List<TrackingNumberContentVO> vos = new ArrayList<>();
		for (TrackingNumberContent trackingNumberContent : trackingNumberContents) {
			vos.add(convertTrackingNumberContent(trackingNumberContent));
		}
		return vos;
	}

	public static TrackingNumberContentVO convertTrackingNumberContent(TrackingNumberContent trackingNumberContent) {
		if (trackingNumberContent == null) {
			return null;
		}
		TrackingNumberContentVO vo = new TrackingNumberContentVO();
		BeanUtils.copyProperties(trackingNumberContent, vo);
		vo.setGamePlayName(
				DictHolder.getDictItemName("gamePlay", trackingNumberContent.getTrackingNumberOrder().getGameCode()
						+ "_" + trackingNumberContent.getGamePlayCode()));
		return vo;
	}

	public static TrackingNumberOrderDetailsVO convertTrackingNumberOrderDetails(TrackingNumberSituation order) {
		if (order == null) {
			return null;
		}
		TrackingNumberOrderDetailsVO vo = new TrackingNumberOrderDetailsVO();
		BeanUtils.copyProperties(order, vo);
		vo.setGameName(DictHolder.getDictItemName("game", vo.getGameCode()));
		vo.setStateName(DictHolder.getDictItemName("trackingNumberOrderState", vo.getState()));
		if (order.getUserAccount() != null) {
			vo.setUserName(order.getUserAccount().getUserName());
		}
		vo.setTrackingNumberContents(convertTrackingNumberContent(order.getTrackingNumberContents()));
		vo.setTrackingNumberPlans(convertTrackingNumberPlan(order.getTrackingNumberPlans()));
		return vo;
	}

	public static List<TrackingNumberPlanVO> convertTrackingNumberPlan(
			Collection<TrackingNumberPlan> trackingNumberPlans) {
		if (CollectionUtil.isEmpty(trackingNumberPlans)) {
			return new ArrayList<>();
		}
		List<TrackingNumberPlanVO> vos = new ArrayList<>();
		for (TrackingNumberPlan trackingNumberPlan : trackingNumberPlans) {
			vos.add(convertTrackingNumberPlan(trackingNumberPlan));
		}
		return vos;
	}

	public static TrackingNumberPlanVO convertTrackingNumberPlan(TrackingNumberPlan trackingNumberPlan) {
		if (trackingNumberPlan == null) {
			return null;
		}
		TrackingNumberPlanVO vo = new TrackingNumberPlanVO();
		BeanUtils.copyProperties(trackingNumberPlan, vo);
		BettingOrder bettingOrder = trackingNumberPlan.getBettingOrder();
		if (bettingOrder != null) {
			vo.setLotteryNum(bettingOrder.getLotteryNum());
			vo.setTotalBettingAmount(bettingOrder.getTotalBettingAmount());
			vo.setTotalWinningAmount(bettingOrder.getTotalWinningAmount());
			vo.setState(bettingOrder.getState());
			vo.setStateName(DictHolder.getDictItemName("bettingOrderState", vo.getState()));
			vo.setBettingOrderId(bettingOrder.getId());
		}
		if (Constant.投注订单状态_未开奖.equals(bettingOrder.getState())) {
			if (bettingOrder.getIssue() != null) {
				if (new Date().getTime() < bettingOrder.getIssue().getEndTime().getTime()) {
					vo.setCancelOrderFlag(true);
				}
			}
		}
		return vo;
	}

	public static List<TrackingNumberSituationVO> convertTrackingNumberSituation(
			Collection<TrackingNumberSituation> trackingNumberSituations) {
		if (CollectionUtil.isEmpty(trackingNumberSituations)) {
			return new ArrayList<>();
		}
		List<TrackingNumberSituationVO> vos = new ArrayList<>();
		for (TrackingNumberSituation trackingNumberSituation : trackingNumberSituations) {
			vos.add(convertTrackingNumberSituation(trackingNumberSituation));
		}
		return vos;
	}

	public static TrackingNumberSituationVO convertTrackingNumberSituation(
			TrackingNumberSituation trackingNumberSituation) {
		if (trackingNumberSituation == null) {
			return null;
		}
		TrackingNumberSituationVO vo = new TrackingNumberSituationVO();
		BeanUtils.copyProperties(trackingNumberSituation, vo);
		vo.setGameName(DictHolder.getDictItemName("game", vo.getGameCode()));
		vo.setStateName(DictHolder.getDictItemName("trackingNumberOrderState", vo.getState()));
		return vo;
	}

	public static List<WinningRankVO> convertWinningRank(Collection<BettingOrder> bettingOrders) {
		if (CollectionUtil.isEmpty(bettingOrders)) {
			return new ArrayList<>();
		}
		List<WinningRankVO> vos = new ArrayList<>();
		for (BettingOrder bettingOrder : bettingOrders) {
			vos.add(convertWinningRank(bettingOrder));
		}
		return vos;
	}

	public static WinningRankVO convertWinningRank(BettingOrder bettingOrder) {
		if (bettingOrder == null) {
			return null;
		}
		WinningRankVO vo = new WinningRankVO();
		BeanUtils.copyProperties(bettingOrder, vo);
		vo.setGameName(DictHolder.getDictItemName("game", bettingOrder.getGameCode()));
		if (bettingOrder.getUserAccount() != null) {
			String userName = bettingOrder.getUserAccount().getUserName();
			userName = userName.substring(0, userName.length() - 4) + "****";
			vo.setUserName(userName);
		}
		return vo;
	}

}
