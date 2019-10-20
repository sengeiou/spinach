package me.zohar.lottery.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.mastercontrol.param.UpdateInviteRegisterSettingParam;
import me.zohar.lottery.mastercontrol.param.UpdateRechargeSettingParam;
import me.zohar.lottery.mastercontrol.param.UpdateRegisterAmountSettingParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface MasterControlApi {

	@GetMapping("/masterControl/getInviteRegisterSetting")
	Result getInviteRegisterSetting();

	@PostMapping("/masterControl/updateInviteRegisterSetting")
	Result updateInviteRegisterSetting(@RequestBody UpdateInviteRegisterSettingParam param);

	@GetMapping("/masterControl/getRegisterAmountSetting")
	Result getRegisterAmountSetting();

	@PostMapping("/masterControl/updateRegisterAmountSetting")
	Result updateRegisterAmountSetting(@RequestBody UpdateRegisterAmountSettingParam param);

	@GetMapping("/masterControl/getRechargeSetting")
	Result getRechargeSetting();

	@PostMapping("/masterControl/updateRechargeSetting")
	Result updateRechargeSetting(@RequestBody UpdateRechargeSettingParam param);

	@PostMapping("/masterControl/refreshCache")
	Result refreshCache(@RequestBody List<String> cacheItems);

}
