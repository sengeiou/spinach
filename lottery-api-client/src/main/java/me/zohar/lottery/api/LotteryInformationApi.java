package me.zohar.lottery.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.information.param.AddOrUpdateInformationCrawlerParam;
import me.zohar.lottery.information.param.AddOrUpdateInformationParam;
import me.zohar.lottery.information.param.LotteryInformationQueryCondParam;
import me.zohar.lottery.information.param.SyncInformationParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface LotteryInformationApi {

	@GetMapping("/lotteryInformation/findAllInformationCrawler")
	Result findAllInformationCrawler();

	@GetMapping("/lotteryInformation/findInformationCrawlerById")
	Result findInformationCrawlerById(@RequestParam(value = "id") String id);

	@GetMapping("/lotteryInformation/delInformationCrawlerById")
	Result delInformationCrawlerById(@RequestParam(value = "id") String id);

	@PostMapping("/lotteryInformation/addOrUpdateInformationCrawler")
	Result addOrUpdateInformationCrawler(@RequestBody AddOrUpdateInformationCrawlerParam param);

	@GetMapping("/lotteryInformation/collectionInformation")
	Result collectionInformation(@RequestParam(value = "id") String id);

	@PostMapping("/lotteryInformation/syncInformation")
	Result syncInformation(@RequestBody List<SyncInformationParam> params);

	@PostMapping("/lotteryInformation/addOrUpdateInformation")
	Result addOrUpdateInformation(@RequestBody AddOrUpdateInformationParam param);

	@GetMapping("/lotteryInformation/delInformationById")
	Result delInformationById(@RequestParam(value = "id") String id);

	@GetMapping("/lotteryInformation/findInformationById")
	Result findInformationById(@RequestParam(value = "id") String id);

	@GetMapping("/lotteryInformation/findTop13Information")
	Result findTop13Information();

	@PostMapping("/lotteryInformation/findLotteryInformationByPage")
	Result findLotteryInformationByPage(@RequestBody LotteryInformationQueryCondParam param);

}
