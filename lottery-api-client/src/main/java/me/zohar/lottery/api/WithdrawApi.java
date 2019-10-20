package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelWithdrawRecordQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.StartWithdrawParam;
import me.zohar.lottery.rechargewithdraw.param.WithdrawRecordQueryCondParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface WithdrawApi {

	@GetMapping("/withdraw/approved")
	Result approved(@RequestParam("id") String id, @RequestParam("note") String note);

	@GetMapping("/withdraw/notApproved")
	Result notApproved(@RequestParam("id") String id, @RequestParam("note") String note);

	@GetMapping("/withdraw/confirmCredited")
	Result confirmCredited(@RequestParam("id") String id);

	@PostMapping("/withdraw/findWithdrawRecordByPage")
	Result findWithdrawRecordByPage(@RequestBody WithdrawRecordQueryCondParam param);

	@PostMapping("/withdraw/startWithdraw")
	Result startWithdraw(@RequestBody StartWithdrawParam param);

	@PostMapping("/withdraw/findLowerLevelWithdrawRecordByPage")
	Result findLowerLevelWithdrawRecordByPage(@RequestBody LowerLevelWithdrawRecordQueryCondParam param);

}
