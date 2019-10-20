package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.agent.param.AgentOpenAnAccountParam;
import me.zohar.lottery.agent.param.GenerateInviteCodeParam;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.statisticalanalysis.param.AccountProfitAndLossQueryCondParam;
import me.zohar.lottery.useraccount.param.LowerLevelAccountQueryCondParam;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface AgentController {

	@GetMapping("/agent/findAllRebateAndOdds")
	Result findAllRebateAndOdds();

	@PostMapping("/agent/agentOpenAnAccount")
	Result agentOpenAnAccount(@RequestBody AgentOpenAnAccountParam param);

	@PostMapping("/agent/generateInviteCodeAndGetInviteRegisterLink")
	Result generateInviteCodeAndGetInviteRegisterLink(@RequestBody GenerateInviteCodeParam param);

	@PostMapping("/agent/findLowerLevelAccountDetailsInfoByPage")
	Result findLowerLevelAccountDetailsInfoByPage(@RequestBody LowerLevelAccountQueryCondParam param);

	@PostMapping("/agent/findAccountProfitAndLossByPage")
	Result findAccountProfitAndLossByPage(@RequestBody AccountProfitAndLossQueryCondParam param);

}
