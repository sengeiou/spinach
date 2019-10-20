package me.zohar.lottery.rechargewithdraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.RechargeWithdrawLogApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.UserAccountDetails;
import me.zohar.lottery.rechargewithdraw.param.RechargeWithdrawLogQueryCondParam;

@Controller
@RequestMapping("/rechargeWithdrawLog")
public class RechargeWithdrawLogController {

	@Autowired
	private RechargeWithdrawLogApi rechargeWithdrawLogApi;

	@PostMapping("/findMyRechargeWithdrawLogByPage")
	@ResponseBody
	public Result findMyRechargeWithdrawLogByPage(@RequestBody RechargeWithdrawLogQueryCondParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setUserAccountId(user.getUserAccountId());
		return rechargeWithdrawLogApi.findMyRechargeWithdrawLogByPage(param);
	}

}
