package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.rechargewithdraw.param.RechargeWithdrawLogQueryCondParam;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface RechargeWithdrawLogController {

	@PostMapping("/rechargeWithdrawLog/findMyRechargeWithdrawLogByPage")
	Result login(@RequestBody RechargeWithdrawLogQueryCondParam param);

}
