package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.betting.param.StartTrackingNumberParam;
import me.zohar.lottery.betting.param.TrackingNumberSituationQueryCondParam;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface TrackingNumberApi {

	@PostMapping("/trackingNumber/findTrackingNumberSituationByPage")
	Result findTrackingNumberSituationByPage(@RequestBody TrackingNumberSituationQueryCondParam param);

	@GetMapping("/trackingNumber/findTrackingNumberOrderDetails")
	Result findTrackingNumberOrderDetails(@RequestParam(value = "id") String id);

	@PostMapping("/trackingNumber/startTrackingNumber")
	Result startTrackingNumber(@RequestBody StartTrackingNumberParam param);

	@PostMapping("/trackingNumber/findMyTrackingNumberSituationByPage")
	Result findMyTrackingNumberSituationByPage(@RequestBody TrackingNumberSituationQueryCondParam param);

	@GetMapping("/trackingNumber/findMyTrackingNumberOrderDetails")
	Result findMyTrackingNumberOrderDetails(@RequestParam(value = "id") String id,
			@RequestParam(value = "userAccountId") String userAccountId);

	@GetMapping("/trackingNumber/cancelOrder")
	Result cancelOrder(@RequestParam(value = "orderId") String orderId,
			@RequestParam(value = "userAccountId") String userAccountId);

}
