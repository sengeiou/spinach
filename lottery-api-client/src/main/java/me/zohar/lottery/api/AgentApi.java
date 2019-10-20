package me.zohar.lottery.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.agent.param.AddOrUpdateRebateAndOddsParam;
import me.zohar.lottery.agent.param.AgentOpenAnAccountParam;
import me.zohar.lottery.agent.param.GenerateInviteCodeParam;
import me.zohar.lottery.common.param.PageParam;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.statisticalanalysis.param.AccountProfitAndLossQueryCondParam;
import me.zohar.lottery.useraccount.param.LowerLevelAccountQueryCondParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface AgentApi {

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

	@PostMapping("/agent/findRebateAndOddsSituationByPage")
	Result findRebateAndOddsSituationByPage(@RequestBody PageParam param);

	@PostMapping("/agent/resetRebateAndOdds")
	Result resetRebateAndOdds(@RequestBody List<AddOrUpdateRebateAndOddsParam> params);

	@GetMapping("/agent/findRebateAndOdds")
	Result findRebateAndOdds(@RequestParam(value = "rebate") Double rebate, @RequestParam(value = "odds") Double odds);

	@PostMapping("/agent/addOrUpdateRebateAndOdds")
	Result addOrUpdateRebateAndOdds(@RequestBody AddOrUpdateRebateAndOddsParam params);

	@GetMapping("/agent/delRebateAndOdds")
	Result delRebateAndOdds(@RequestParam(value = "rebate") Double rebate, @RequestParam(value = "odds") Double odds);

}
