package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelRechargeOrderQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderParam;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderQueryCondParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface RechargeApi {

	@PostMapping("/recharge/findRechargeOrderByPage")
	Result findRechargeOrderByPage(@RequestBody RechargeOrderQueryCondParam param);

	@GetMapping("/recharge/manualSettlement")
	Result manualSettlement(@RequestParam(value = "orderNo") String orderNo);

	@GetMapping("/recharge/cancelOrder")
	Result cancelOrder(@RequestParam(value = "id") String id);

	@PostMapping("/recharge/generateRechargeOrder")
	Result generateRechargeOrder(@RequestBody RechargeOrderParam param);

	@PostMapping("/recharge/findLowerLevelRechargeOrderByPage")
	Result findLowerLevelRechargeOrderByPage(@RequestBody LowerLevelRechargeOrderQueryCondParam param);

}
