package me.zohar.lottery.issue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.IssueApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.issue.param.IssueEditParam;
import me.zohar.lottery.issue.param.IssueSettingParam;
import me.zohar.lottery.issue.param.LotterySituationQueryCondParam;
import me.zohar.lottery.issue.param.ManualLotteryParam;

@Controller
@RequestMapping("/issue")
public class IssueController {

	@Autowired
	private IssueApi issueApi;

	@GetMapping("/getIssueSettingDetailsByGameId")
	@ResponseBody
	public Result getIssueSettingDetailsByGameId(String gameId) {
		return issueApi.getIssueSettingDetailsByGameId(gameId);
	}

	@PostMapping("/addOrUpdateIssueSetting")
	@ResponseBody
	public Result addOrUpdateIssueSetting(@RequestBody IssueSettingParam param) {
		return issueApi.addOrUpdateIssueSetting(param);
	}

	@GetMapping("/findLotterySituationById")
	@ResponseBody
	public Result findLotterySituationById(String id) {
		return issueApi.findLotterySituationById(id);
	}

	@PostMapping("/findLotterySituationByPage")
	@ResponseBody
	public Result findLotterySituationByPage(@RequestBody LotterySituationQueryCondParam param) {
		return issueApi.findLotterySituationByPage(param);
	}

	@PostMapping("/manualLottery")
	@ResponseBody
	public Result manualLottery(@RequestBody ManualLotteryParam param) {
		return issueApi.manualLottery(param);
	}

	@GetMapping("/manualSettlement")
	@ResponseBody
	public Result manualSettlement(String id) {
		return issueApi.manualSettlement(id);
	}

	@PostMapping("/updateIssue")
	@ResponseBody
	public Result updateIssue(@RequestBody IssueEditParam param) {
		return issueApi.updateIssue(param);
	}

}
