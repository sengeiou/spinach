package me.zohar.lottery.rechargewithdraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.RechargeApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.UserAccountDetails;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelRechargeOrderQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderParam;

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

	@PostMapping("/generateRechargeOrder")
	@ResponseBody
	public Result generateRechargeOrder(@RequestBody RechargeOrderParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setUserAccountId(user.getUserAccountId());
		return rechargeApi.generateRechargeOrder(param);
	}

	@PostMapping("/findLowerLevelRechargeOrderByPage")
	@ResponseBody
	public Result findLowerLevelRechargeOrderByPage(@RequestBody LowerLevelRechargeOrderQueryCondParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setCurrentAccountId(user.getUserAccountId());
		return rechargeApi.findLowerLevelRechargeOrderByPage(param);
	}

}
