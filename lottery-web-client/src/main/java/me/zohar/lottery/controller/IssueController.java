package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.issue.param.LotteryHistoryParam;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface IssueController {

	@GetMapping("/issue/findLatelyThe5TimeIssue")
	Result findLatelyThe5TimeIssue(@RequestParam(value = "gameCode") String gameCode);

	@GetMapping("/issue/getCurrentIssue")
	Result getCurrentIssue(@RequestParam(value = "gameCode") String gameCode);

	@GetMapping("/issue/getNextIssue")
	Result getNextIssue(@RequestParam(value = "gameCode") String gameCode);

	@GetMapping("/issue/getLatelyIssue")
	Result getLatelyIssue(@RequestParam(value = "gameCode") String gameCode);

	@GetMapping("/issue/findTodayTrackingNumberIssue")
	Result findTodayTrackingNumberIssue(@RequestParam(value = "gameCode") String gameCode);

	@PostMapping("/issue/findLotteryHistory")
	Result findLotteryHistory(@RequestBody LotteryHistoryParam param);

}
