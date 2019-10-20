package me.zohar.lottery.useraccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.agent.param.AddOrUpdateRebateAndOddsParam;
import me.zohar.lottery.api.AgentApi;
import me.zohar.lottery.common.param.PageParam;
import me.zohar.lottery.common.vo.Result;

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

	@PostMapping("/findRebateAndOddsSituationByPage")
	@ResponseBody
	public Result findRebateAndOddsSituationByPage(@RequestBody PageParam param) {
		return agentApi.findRebateAndOddsSituationByPage(param);
	}

	@PostMapping("/resetRebateAndOdds")
	@ResponseBody
	public Result resetRebateAndOdds(@RequestBody List<AddOrUpdateRebateAndOddsParam> params) {
		return agentApi.resetRebateAndOdds(params);
	}

	@GetMapping("/findRebateAndOdds")
	@ResponseBody
	public Result findRebateAndOdds(Double rebate, Double odds) {
		return agentApi.findRebateAndOdds(rebate, odds);
	}

	@PostMapping("/addOrUpdateRebateAndOdds")
	@ResponseBody
	public Result addOrUpdateRebateAndOdds(@RequestBody AddOrUpdateRebateAndOddsParam param) {
		return agentApi.addOrUpdateRebateAndOdds(param);
	}

	@GetMapping("/delRebateAndOdds")
	@ResponseBody
	public Result delRebateAndOdds(Double rebate, Double odds) {
		return agentApi.delRebateAndOdds(rebate, odds);
	}
}
