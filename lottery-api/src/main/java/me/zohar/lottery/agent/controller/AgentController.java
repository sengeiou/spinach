package me.zohar.lottery.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.agent.param.AddOrUpdateRebateAndOddsParam;
import me.zohar.lottery.agent.param.AgentOpenAnAccountParam;
import me.zohar.lottery.agent.param.GenerateInviteCodeParam;
import me.zohar.lottery.agent.service.AgentService;
import me.zohar.lottery.common.param.PageParam;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.statisticalanalysis.param.AccountProfitAndLossQueryCondParam;
import me.zohar.lottery.statisticalanalysis.service.StatisticalAnalysisService;
import me.zohar.lottery.useraccount.param.LowerLevelAccountQueryCondParam;
import me.zohar.lottery.useraccount.service.UserAccountService;

@Controller
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private AgentService agentService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private StatisticalAnalysisService statisticalAnalysisService;

	@GetMapping("/findAllRebateAndOdds")
	@ResponseBody
	public Result findAllRebateAndOdds() {
		return Result.success().setData(agentService.findAllRebateAndOdds());
	}

	@PostMapping("/findRebateAndOddsSituationByPage")
	@ResponseBody
	public Result findRebateAndOddsSituationByPage(@RequestBody PageParam param) {
		return Result.success().setData(agentService.findRebateAndOddsSituationByPage(param));
	}

	@GetMapping("/findRebateAndOdds")
	@ResponseBody
	public Result findRebateAndOdds(Double rebate, Double odds) {
		return Result.success().setData(agentService.findRebateAndOdds(rebate, odds));
	}

	@PostMapping("/addOrUpdateRebateAndOdds")
	@ResponseBody
	public Result addOrUpdateRebateAndOdds(@RequestBody AddOrUpdateRebateAndOddsParam param) {
		agentService.addOrUpdateRebateAndOdds(param);
		return Result.success();
	}

	@GetMapping("/delRebateAndOdds")
	@ResponseBody
	public Result delRebateAndOdds(Double rebate, Double odds) {
		agentService.delRebateAndOdds(rebate, odds);
		return Result.success();
	}

	@PostMapping("/resetRebateAndOdds")
	@ResponseBody
	public Result resetRebateAndOdds(@RequestBody List<AddOrUpdateRebateAndOddsParam> params) {
		agentService.resetRebateAndOdds(params);
		return Result.success();
	}

	@PostMapping("/agentOpenAnAccount")
	@ResponseBody
	public Result agentOpenAnAccount(@RequestBody AgentOpenAnAccountParam param) {
		agentService.agentOpenAnAccount(param);
		return Result.success();
	}

	@PostMapping("/generateInviteCodeAndGetInviteRegisterLink")
	@ResponseBody
	public Result generateInviteCodeAndGetInviteRegisterLink(@RequestBody GenerateInviteCodeParam param) {
		String inviteCodeId = agentService.generateInviteCode(param);
		return Result.success().setData(agentService.getInviteCodeDetailsInfoById(inviteCodeId));
	}

	@PostMapping("/findLowerLevelAccountDetailsInfoByPage")
	@ResponseBody
	public Result findLowerLevelAccountDetailsInfoByPage(@RequestBody LowerLevelAccountQueryCondParam param) {
		return Result.success().setData(userAccountService.findLowerLevelAccountDetailsInfoByPage(param));
	}

	@PostMapping("/findAccountProfitAndLossByPage")
	@ResponseBody
	public Result findAccountProfitAndLossByPage(@RequestBody AccountProfitAndLossQueryCondParam param) {
		return Result.success().setData(statisticalAnalysisService.findAccountProfitAndLossByPage(param));
	}

}
