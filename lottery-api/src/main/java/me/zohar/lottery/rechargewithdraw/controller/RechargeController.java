package me.zohar.lottery.rechargewithdraw.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelRechargeOrderQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.MuspayCallbackParam;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderParam;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderQueryCondParam;
import me.zohar.lottery.rechargewithdraw.service.RechargeService;

/**
 * 
 * @author zohar
 * @date 2019年1月21日
 *
 */
@Controller
@RequestMapping("/recharge")
public class RechargeController {

	@Autowired
	private RechargeService rechargeService;

	@PostMapping("/findRechargeOrderByPage")
	@ResponseBody
	public Result findRechargeOrderByPage(@RequestBody RechargeOrderQueryCondParam param) {
		return Result.success().setData(rechargeService.findRechargeOrderByPage(param));
	}

	@GetMapping("/cancelOrder")
	@ResponseBody
	public Result cancelOrder(String id) {
		rechargeService.cancelOrder(id);
		return Result.success();
	}

	@GetMapping("/manualSettlement")
	@ResponseBody
	public Result manualSettlement(String orderNo) {
		rechargeService.manualSettlement(orderNo);
		return Result.success();
	}

	@RequestMapping("/muspayCallback")
	@ResponseBody
	public String muspayCallback(@RequestBody MuspayCallbackParam param) throws IOException {
		rechargeService.checkOrderWithMuspay(param);
		return Result.success().getMsg();
	}

	@PostMapping("/generateRechargeOrder")
	@ResponseBody
	public Result generateRechargeOrder(@RequestBody RechargeOrderParam param) {
		return Result.success().setData(rechargeService.generateRechargeOrder(param));
	}

	@PostMapping("/findLowerLevelRechargeOrderByPage")
	@ResponseBody
	public Result findLowerLevelRechargeOrderByPage(@RequestBody LowerLevelRechargeOrderQueryCondParam param) {
		return Result.success().setData(rechargeService.findLowerLevelRechargeOrderByPage(param));
	}

}
