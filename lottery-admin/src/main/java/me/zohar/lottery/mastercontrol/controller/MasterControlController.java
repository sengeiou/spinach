package me.zohar.lottery.mastercontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.MasterControlApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.mastercontrol.param.UpdateInviteRegisterSettingParam;
import me.zohar.lottery.mastercontrol.param.UpdateRechargeSettingParam;
import me.zohar.lottery.mastercontrol.param.UpdateRegisterAmountSettingParam;

/**
 * 总控
 * 
 * @author zohar
 * @date 2019年3月9日
 *
 */
@Controller
@RequestMapping("/masterControl")
public class MasterControlController {

	@Autowired
	private MasterControlApi masterControlApi;

	@GetMapping("/getInviteRegisterSetting")
	@ResponseBody
	public Result getInviteRegisterSetting() {
		return masterControlApi.getInviteRegisterSetting();
	}

	@PostMapping("/updateInviteRegisterSetting")
	@ResponseBody
	public Result updateInviteRegisterSetting(@RequestBody UpdateInviteRegisterSettingParam param) {
		return masterControlApi.updateInviteRegisterSetting(param);
	}

	@GetMapping("/getRegisterAmountSetting")
	@ResponseBody
	public Result getRegisterAmountSetting() {
		return masterControlApi.getRegisterAmountSetting();
	}

	@PostMapping("/updateRegisterAmountSetting")
	@ResponseBody
	public Result updateRegisterAmountSetting(@RequestBody UpdateRegisterAmountSettingParam param) {
		return masterControlApi.updateRegisterAmountSetting(param);
	}

	@GetMapping("/getRechargeSetting")
	@ResponseBody
	public Result getRechargeSetting() {
		return masterControlApi.getRechargeSetting();
	}

	@PostMapping("/updateRechargeSetting")
	@ResponseBody
	public Result updateRechargeSetting(@RequestBody UpdateRechargeSettingParam param) {
		return masterControlApi.updateRechargeSetting(param);
	}

	@PostMapping("/refreshCache")
	@ResponseBody
	public Result refreshCache(@RequestBody List<String> cacheItems) {
		return masterControlApi.refreshCache(cacheItems);
	}

}
