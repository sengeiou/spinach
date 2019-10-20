package me.zohar.lottery.betting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.betting.param.BatchCancelOrderParam;
import me.zohar.lottery.betting.param.BettingOrderQueryCondParam;
import me.zohar.lottery.betting.param.ChangeOrderParam;
import me.zohar.lottery.betting.param.LowerLevelBettingOrderQueryCondParam;
import me.zohar.lottery.betting.param.PlaceOrderParam;
import me.zohar.lottery.betting.service.BettingService;
import me.zohar.lottery.common.vo.Result;

@Controller
@RequestMapping("/betting")
public class BettingController {

	@Autowired
	private BettingService bettingService;

	@PostMapping("/changeOrder")
	@ResponseBody
	public Result changeOrder(@RequestBody List<ChangeOrderParam> params) {
		bettingService.changeOrder(params);
		return Result.success();
	}

	@PostMapping("/findBettingOrderInfoByPage")
	@ResponseBody
	public Result findBettingOrderInfoByPage(@RequestBody BettingOrderQueryCondParam param) {
		return Result.success().setData(bettingService.findBettingOrderInfoByPage(param));
	}

	@GetMapping("/findBettingOrderDetails")
	@ResponseBody
	public Result findBettingOrderDetails(String id) {
		return Result.success().setData(bettingService.findBettingOrderDetails(id));
	}

	@GetMapping("/findTop50WinningRank")
	@ResponseBody
	public Result findTop50WinningRank() {
		return Result.success().setData(bettingService.findTop50WinningRank());
	}

	/**
	 * 获取我或下级账号投注信息详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findMyOrLowerLevelBettingOrderDetails")
	@ResponseBody
	public Result findMyOrLowerLevelBettingOrderDetails(String id, String userAccountId) {
		return Result.success().setData(bettingService.findMyOrLowerLevelBettingOrderDetails(id, userAccountId));
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
		return Result.success().setData(bettingService.findMyBettingOrderInfoByPage(param));
	}

	@GetMapping("/findTodayLatestThe5TimeBettingRecord")
	@ResponseBody
	public Result findTodayLatestThe5TimeBettingRecord(String userAccountId, String gameCode) {
		return Result.success().setData(bettingService.findTodayLatestThe5TimeBettingRecord(userAccountId, gameCode));
	}

	/**
	 * 下单
	 * 
	 * @return
	 */
	@PostMapping("/placeOrder")
	@ResponseBody
	public Result placeOrder(@RequestBody PlaceOrderParam placeOrderParam) {
		bettingService.placeOrder(placeOrderParam);
		return Result.success();
	}

	@GetMapping("/cancelOrder")
	@ResponseBody
	public Result cancelOrder(String orderId, String userAccountId) {
		bettingService.cancelOrder(orderId, userAccountId);
		return Result.success();
	}

	@PostMapping("/batchCancelOrder")
	@ResponseBody
	public Result batchCancelOrder(@RequestBody BatchCancelOrderParam param) {
		bettingService.batchCancelOrder(param.getOrderIds(), param.getUserAccountId());
		return Result.success();
	}

	@PostMapping("/findLowerLevelBettingOrderInfoByPage")
	@ResponseBody
	public Result findLowerLevelBettingOrderInfoByPage(@RequestBody LowerLevelBettingOrderQueryCondParam param) {
		return Result.success().setData(bettingService.findLowerLevelBettingOrderInfoByPage(param));
	}

}
