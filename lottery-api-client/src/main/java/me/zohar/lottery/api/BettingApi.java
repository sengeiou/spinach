package me.zohar.lottery.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.betting.param.BatchCancelOrderParam;
import me.zohar.lottery.betting.param.BettingOrderQueryCondParam;
import me.zohar.lottery.betting.param.ChangeOrderParam;
import me.zohar.lottery.betting.param.LowerLevelBettingOrderQueryCondParam;
import me.zohar.lottery.betting.param.PlaceOrderParam;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface BettingApi {
	
	@PostMapping("/betting/changeOrder")
	Result changeOrder(@RequestBody List<ChangeOrderParam> params);
	
	@PostMapping("/betting/findBettingOrderInfoByPage")
	Result findBettingOrderInfoByPage(@RequestBody BettingOrderQueryCondParam param);

	@GetMapping("/betting/findBettingOrderDetails")
	Result findBettingOrderDetails(@RequestParam(value = "id") String id);

	@GetMapping("/betting/findTop50WinningRank")
	Result findTop50WinningRank();

	@GetMapping("/betting/findMyOrLowerLevelBettingOrderDetails")
	Result findMyOrLowerLevelBettingOrderDetails(@RequestParam(value = "id") String id,
			@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/betting/findMyBettingOrderInfoByPage")
	Result findMyBettingOrderInfoByPage(@RequestBody BettingOrderQueryCondParam param);

	@GetMapping("/betting/findTodayLatestThe5TimeBettingRecord")
	Result findTodayLatestThe5TimeBettingRecord(@RequestParam(value = "gameCode") String gameCode,
			@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/betting/placeOrder")
	Result placeOrder(@RequestBody PlaceOrderParam placeOrderParam);

	@GetMapping("/betting/cancelOrder")
	Result cancelOrder(@RequestParam(value = "orderId") String orderId,
			@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/betting/batchCancelOrder")
	Result batchCancelOrder(@RequestBody BatchCancelOrderParam param);

	@PostMapping("/betting/findLowerLevelBettingOrderInfoByPage")
	Result findLowerLevelBettingOrderInfoByPage(@RequestBody LowerLevelBettingOrderQueryCondParam param);

}
