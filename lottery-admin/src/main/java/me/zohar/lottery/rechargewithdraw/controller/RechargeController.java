package me.zohar.lottery.rechargewithdraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.RechargeApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderQueryCondParam;

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
	private RechargeApi rechargeApi;

	@PostMapping("/findRechargeOrderByPage")
	@ResponseBody
	public Result findRechargeOrderByPage(@RequestBody RechargeOrderQueryCondParam param) {
		return rechargeApi.findRechargeOrderByPage(param);
	}

	@GetMapping("/cancelOrder")
	@ResponseBody
	public Result cancelOrder(String id) {
		return rechargeApi.cancelOrder(id);
	}

	@GetMapping("/manualSettlement")
	@ResponseBody
	public Result manualSettlement(String orderNo) {
		return rechargeApi.manualSettlement(orderNo);
	}

}
