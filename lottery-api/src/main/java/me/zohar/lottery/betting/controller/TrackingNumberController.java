package me.zohar.lottery.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.betting.param.StartTrackingNumberParam;
import me.zohar.lottery.betting.param.TrackingNumberSituationQueryCondParam;
import me.zohar.lottery.betting.service.TrackingNumberService;
import me.zohar.lottery.common.vo.Result;

@Controller
@RequestMapping("/trackingNumber")
public class TrackingNumberController {

	@Autowired
	private TrackingNumberService trackingNumberService;

	@PostMapping("/findTrackingNumberSituationByPage")
	@ResponseBody
	public Result findTrackingNumberSituationByPage(@RequestBody TrackingNumberSituationQueryCondParam param) {
		return Result.success().setData(trackingNumberService.findTrackingNumberSituationByPage(param));
	}

	@GetMapping("/findTrackingNumberOrderDetails")
	@ResponseBody
	public Result findTrackingNumberOrderDetails(String id) {
		return Result.success().setData(trackingNumberService.findTrackingNumberOrderDetails(id));
	}

	/**
	 * 发起追号
	 * 
	 * @return
	 */
	@PostMapping("/startTrackingNumber")
	@ResponseBody
	public Result startTrackingNumber(@RequestBody StartTrackingNumberParam startTrackingNumberParam) {
		trackingNumberService.startTrackingNumber(startTrackingNumberParam);
		return Result.success();
	}

	@PostMapping("/findMyTrackingNumberSituationByPage")
	@ResponseBody
	public Result findMyTrackingNumberSituationByPage(@RequestBody TrackingNumberSituationQueryCondParam param) {
		return Result.success().setData(trackingNumberService.findMyTrackingNumberSituationByPage(param));
	}

	@GetMapping("/findMyTrackingNumberOrderDetails")
	@ResponseBody
	public Result findMyTrackingNumberOrderDetails(String id, String userAccountId) {
		return Result.success().setData(trackingNumberService.findMyTrackingNumberOrderDetails(id, userAccountId));
	}

	@GetMapping("/cancelOrder")
	@ResponseBody
	public Result cancelOrder(String orderId, String userAccountId) {
		trackingNumberService.cancelOrder(orderId, userAccountId);
		return Result.success();
	}

}
