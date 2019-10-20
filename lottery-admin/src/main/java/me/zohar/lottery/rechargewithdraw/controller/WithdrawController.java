package me.zohar.lottery.rechargewithdraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.WithdrawApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.rechargewithdraw.param.WithdrawRecordQueryCondParam;

@Controller
@RequestMapping("/withdraw")
public class WithdrawController {

	@Autowired
	private WithdrawApi withdrawApi;

	@GetMapping("/approved")
	@ResponseBody
	public Result approved(String id, String note) {
		return withdrawApi.approved(id, note);
	}

	@GetMapping("/notApproved")
	@ResponseBody
	public Result notApproved(String id, String note) {
		return withdrawApi.notApproved(id, note);
	}

	@GetMapping("/confirmCredited")
	@ResponseBody
	public Result confirmCredited(String id) {
		return withdrawApi.confirmCredited(id);
	}

	@PostMapping("/findWithdrawRecordByPage")
	@ResponseBody
	public Result findWithdrawRecordByPage(@RequestBody WithdrawRecordQueryCondParam param) {
		return withdrawApi.findWithdrawRecordByPage(param);
	}

}
