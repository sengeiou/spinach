package me.zohar.lottery.rechargewithdraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.rechargewithdraw.param.RechargeWithdrawLogQueryCondParam;
import me.zohar.lottery.rechargewithdraw.service.RechargeWithdrawLogService;

@Controller
@RequestMapping("/rechargeWithdrawLog")
public class RechargeWithdrawLogController {

	@Autowired
	private RechargeWithdrawLogService rechargeWithdrawLogService;

	@PostMapping("/findMyRechargeWithdrawLogByPage")
	@ResponseBody
	public Result findMyRechargeWithdrawLogByPage(@RequestBody RechargeWithdrawLogQueryCondParam param) {
		return Result.success().setData(rechargeWithdrawLogService.findMyRechargeWithdrawLogByPage(param));
	}

}
