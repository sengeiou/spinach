package me.zohar.lottery.information.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.LotteryInformationApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.information.param.AddOrUpdateInformationCrawlerParam;
import me.zohar.lottery.information.param.AddOrUpdateInformationParam;
import me.zohar.lottery.information.param.LotteryInformationQueryCondParam;
import me.zohar.lottery.information.param.SyncInformationParam;

@Controller
@RequestMapping("/lotteryInformation")
public class LotteryInformationController {

	@Autowired
	private LotteryInformationApi lotteryInformationApi;

	@GetMapping("/findInformationById")
	@ResponseBody
	public Result findInformationById(String id) {
		return lotteryInformationApi.findInformationById(id);
	}

	@GetMapping("/delInformationById")
	@ResponseBody
	public Result delInformationById(String id) {
		return lotteryInformationApi.delInformationById(id);
	}

	@PostMapping("/addOrUpdateInformation")
	@ResponseBody
	public Result addOrUpdateInformation(@RequestBody AddOrUpdateInformationParam param) {
		return lotteryInformationApi.addOrUpdateInformation(param);
	}

	@PostMapping("/syncInformation")
	@ResponseBody
	public Result syncInformation(@RequestBody List<SyncInformationParam> params) {
		return lotteryInformationApi.syncInformation(params);
	}

	@GetMapping("/collectionInformation")
	@ResponseBody
	public Result collectionInformation(String id) {
		return lotteryInformationApi.collectionInformation(id);
	}

	@PostMapping("/addOrUpdateInformationCrawler")
	@ResponseBody
	public Result addOrUpdateInformationCrawler(@RequestBody AddOrUpdateInformationCrawlerParam param) {
		return lotteryInformationApi.addOrUpdateInformationCrawler(param);
	}

	@GetMapping("/delInformationCrawlerById")
	@ResponseBody
	public Result delInformationCrawlerById(String id) {
		return lotteryInformationApi.delInformationCrawlerById(id);
	}

	@GetMapping("/findInformationCrawlerById")
	@ResponseBody
	public Result findInformationCrawlerById(String id) {
		return lotteryInformationApi.findInformationCrawlerById(id);
	}

	@GetMapping("/findAllInformationCrawler")
	@ResponseBody
	public Result findAllInformationCrawler() {
		return lotteryInformationApi.findAllInformationCrawler();
	}

	@PostMapping("/findLotteryInformationByPage")
	@ResponseBody
	public Result findLotteryInformationByPage(@RequestBody LotteryInformationQueryCondParam param) {
		return lotteryInformationApi.findLotteryInformationByPage(param);
	}

}
