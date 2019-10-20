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
import me.zohar.lottery.issue.param.LotteryHistoryParam;

@Controller
@RequestMapping("/issue")
public class IssueController {

	@Autowired
	private IssueApi issueApi;

	@GetMapping("/findLatelyThe5TimeIssue")
	@ResponseBody
	public Result findLatelyThe5TimeIssue(String gameCode) {
		return issueApi.findLatelyThe5TimeIssue(gameCode);
	}

	@GetMapping("/getCurrentIssue")
	@ResponseBody
	public Result getCurrentIssue(String gameCode) {
		return issueApi.getCurrentIssue(gameCode);
	}

	@GetMapping("/getNextIssue")
	@ResponseBody
	public Result getNextIssue(String gameCode) {
		return issueApi.getNextIssue(gameCode);
	}

	@GetMapping("/getLatelyIssue")
	@ResponseBody
	public Result getLatelyIssue(String gameCode) {
		return issueApi.getLatelyIssue(gameCode);
	}

	@GetMapping("/findTodayTrackingNumberIssue")
	@ResponseBody
	public Result findTodayTrackingNumberIssue(String gameCode) {
		return issueApi.findTodayTrackingNumberIssue(gameCode);
	}

	@PostMapping("/findLotteryHistory")
	@ResponseBody
	public Result findLotteryHistory(@RequestBody LotteryHistoryParam param) {
		return issueApi.findLotteryHistory(param);
	}

}
