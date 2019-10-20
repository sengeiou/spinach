package me.zohar.lottery.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.BettingApi;
import me.zohar.lottery.betting.param.BatchCancelOrderParam;
import me.zohar.lottery.betting.param.BettingOrderQueryCondParam;
import me.zohar.lottery.betting.param.LowerLevelBettingOrderQueryCondParam;
import me.zohar.lottery.betting.param.PlaceOrderParam;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.UserAccountDetails;

@Controller
@RequestMapping("/betting")
public class BettingController {

	@Autowired
	private BettingApi bettingApi;

	@GetMapping("/findTop50WinningRank")
	@ResponseBody
	public Result findTop50WinningRank() {
		return bettingApi.findTop50WinningRank();
	}

	/**
	 * 获取我或下级账号投注信息详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findMyOrLowerLevelBettingOrderDetails")
	@ResponseBody
	public Result findMyOrLowerLevelBettingOrderDetails(String id) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return bettingApi.findMyOrLowerLevelBettingOrderDetails(id, user.getUserAccountId());
	}

	/**
	 * 分页获取我的投注订单信息
	 * 
	 * @param param
	 * @return
	 */
	@PostMapping("/findMyBettingOrderInfoByPage")
	@ResponseBody
	public Result findMyBettingOrderInfoByPage(@RequestBody BettingOrderQueryCondParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setUserAccountId(user.getUserAccountId());
		return bettingApi.findMyBettingOrderInfoByPage(param);
	}

	@GetMapping("/findTodayLatestThe5TimeBettingRecord")
	@ResponseBody
	public Result findTodayLatestThe5TimeBettingRecord(String gameCode) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return bettingApi.findTodayLatestThe5TimeBettingRecord(gameCode, user.getUserAccountId());
	}

	/**
	 * 下单
	 * 
	 * @return
	 */
	@PostMapping("/placeOrder")
	@ResponseBody
	public Result placeOrder(@RequestBody PlaceOrderParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setUserAccountId(user.getUserAccountId());
		return bettingApi.placeOrder(param);
	}

	@GetMapping("/cancelOrder")
	@ResponseBody
	public Result cancelOrder(String orderId) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return bettingApi.cancelOrder(orderId, user.getUserAccountId());
	}

	@PostMapping("/batchCancelOrder")
	@ResponseBody
	public Result batchCancelOrder(@RequestBody BatchCancelOrderParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setUserAccountId(user.getUserAccountId());
		return bettingApi.batchCancelOrder(param);
	}

	@PostMapping("/findLowerLevelBettingOrderInfoByPage")
	@ResponseBody
	public Result findLowerLevelBettingOrderInfoByPage(@RequestBody LowerLevelBettingOrderQueryCondParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setCurrentAccountId(user.getUserAccountId());
		return bettingApi.findLowerLevelBettingOrderInfoByPage(param);
	}

}
