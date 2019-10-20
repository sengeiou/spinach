package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.betting.param.StartTrackingNumberParam;
import me.zohar.lottery.betting.param.TrackingNumberSituationQueryCondParam;
import me.zohar.lottery.common.vo.Result;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface TrackingNumberController {

	@PostMapping("/trackingNumber/startTrackingNumber")
	Result startTrackingNumber(@RequestBody StartTrackingNumberParam startTrackingNumberParam);

	@PostMapping("/trackingNumber/findMyTrackingNumberSituationByPage")
	Result findMyTrackingNumberSituationByPage(
			@RequestBody TrackingNumberSituationQueryCondParam startTrackingNumberParam);

	@GetMapping("/trackingNumber/findMyTrackingNumberOrderDetails")
	Result findMyTrackingNumberOrderDetails(@RequestParam(value = "id") String id);

	@GetMapping("/trackingNumber/cancelOrder")
	Result cancelOrder(@RequestParam(value = "orderId") String orderId);

}
