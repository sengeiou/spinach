package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelWithdrawRecordQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.StartWithdrawParam;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface WithdrawController {
	
	@PostMapping("/withdraw/startWithdraw")
	String startWithdraw(@RequestBody StartWithdrawParam param);
	
	@PostMapping("/withdraw/findLowerLevelWithdrawRecordByPage")
	String findLowerLevelWithdrawRecordByPage(@RequestBody LowerLevelWithdrawRecordQueryCondParam param);

}
