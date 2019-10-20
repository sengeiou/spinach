package me.zohar.lottery.rechargewithdraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.WithdrawApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.UserAccountDetails;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelWithdrawRecordQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.StartWithdrawParam;

@Controller
@RequestMapping("/withdraw")
public class WithdrawController {

	@Autowired
	private WithdrawApi withdrawApi;

	@PostMapping("/startWithdraw")
	@ResponseBody
	public Result startWithdraw(@RequestBody StartWithdrawParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setUserAccountId(user.getUserAccountId());
		return withdrawApi.startWithdraw(param);
	}

	@PostMapping("/findLowerLevelWithdrawRecordByPage")
	@ResponseBody
	public Result findLowerLevelWithdrawRecordByPage(@RequestBody LowerLevelWithdrawRecordQueryCondParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setCurrentAccountId(user.getUserAccountId());
		return withdrawApi.findLowerLevelWithdrawRecordByPage(param);
	}

}
