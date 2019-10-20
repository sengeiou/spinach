package me.zohar.lottery.useraccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.agent.param.AgentOpenAnAccountParam;
import me.zohar.lottery.agent.param.GenerateInviteCodeParam;
import me.zohar.lottery.api.AgentApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.UserAccountDetails;
import me.zohar.lottery.statisticalanalysis.param.AccountProfitAndLossQueryCondParam;
import me.zohar.lottery.useraccount.param.LowerLevelAccountQueryCondParam;

@Controller
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private AgentApi agentApi;

	@GetMapping("/findAllRebateAndOdds")
	@ResponseBody
	public Result findAllRebateAndOdds() {
		return agentApi.findAllRebateAndOdds();
	}

	@PostMapping("/agentOpenAnAccount")
	@ResponseBody
	public Result agentOpenAnAccount(@RequestBody AgentOpenAnAccountParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setInviterId(user.getUserAccountId());
		return agentApi.agentOpenAnAccount(param);
	}

	@PostMapping("/generateInviteCodeAndGetInviteRegisterLink")
	@ResponseBody
	public Result generateInviteCodeAndGetInviteRegisterLink(@RequestBody GenerateInviteCodeParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setInviterId(user.getUserAccountId());
		return agentApi.generateInviteCodeAndGetInviteRegisterLink(param);
	}

	@PostMapping("/findLowerLevelAccountDetailsInfoByPage")
	@ResponseBody
	public Result findLowerLevelAccountDetailsInfoByPage(@RequestBody LowerLevelAccountQueryCondParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setCurrentAccountId(user.getUserAccountId());
		return agentApi.findLowerLevelAccountDetailsInfoByPage(param);
	}

	@PostMapping("/findAccountProfitAndLossByPage")
	@ResponseBody
	public Result findAccountProfitAndLossByPage(@RequestBody AccountProfitAndLossQueryCondParam param) {
		UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		param.setCurrentAccountId(user.getUserAccountId());
		return agentApi.findAccountProfitAndLossByPage(param);
	}

}
