package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelRechargeOrderQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.MuspayCallbackParam;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderParam;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface RechargeController {

	@PostMapping("/recharge/muspayCallback")
	String muspayCallback(@RequestBody MuspayCallbackParam param);
	
	@PostMapping("/recharge/generateRechargeOrder")
	String generateRechargeOrder(@RequestBody RechargeOrderParam param);
	
	@PostMapping("/recharge/findLowerLevelRechargeOrderByPage")
	String findLowerLevelRechargeOrderByPage(@RequestBody LowerLevelRechargeOrderQueryCondParam param);

}
