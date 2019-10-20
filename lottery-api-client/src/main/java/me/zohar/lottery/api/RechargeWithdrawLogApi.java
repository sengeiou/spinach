package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.rechargewithdraw.param.RechargeWithdrawLogQueryCondParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface RechargeWithdrawLogApi {

	@PostMapping("/rechargeWithdrawLog/findMyRechargeWithdrawLogByPage")
	Result findMyRechargeWithdrawLogByPage(@RequestBody RechargeWithdrawLogQueryCondParam param);

}
