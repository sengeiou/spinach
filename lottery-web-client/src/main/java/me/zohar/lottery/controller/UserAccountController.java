package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.useraccount.param.AccountChangeLogQueryCondParam;
import me.zohar.lottery.useraccount.param.BindBankInfoParam;
import me.zohar.lottery.useraccount.param.LowerLevelAccountChangeLogQueryCondParam;
import me.zohar.lottery.useraccount.param.ModifyLoginPwdParam;
import me.zohar.lottery.useraccount.param.ModifyMoneyPwdParam;
import me.zohar.lottery.useraccount.param.UserAccountRegisterParam;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface UserAccountController {

	@PostMapping("/userAccount/bindBankInfo")
	Result bindBankInfo(@RequestBody BindBankInfoParam param);

	@GetMapping("/userAccount/getBankInfo")
	Result getBankInfo();

	@PostMapping("/userAccount/modifyLoginPwd")
	Result modifyLoginPwd(@RequestBody ModifyLoginPwdParam param);

	@PostMapping("/userAccount/modifyMoneyPwd")
	Result modifyMoneyPwd(@RequestBody ModifyMoneyPwdParam param);

	@PostMapping("/userAccount/register")
	Result register(@RequestBody UserAccountRegisterParam param);

	@GetMapping("/userAccount/getUserAccountInfo")
	Result getUserAccountInfo();

	@PostMapping("/userAccount/findMyAccountChangeLogByPage")
	Result findMyAccountChangeLogByPage(@RequestBody AccountChangeLogQueryCondParam param);

	@PostMapping("/userAccount/findLowerLevelAccountChangeLogByPage")
	Result findLowerLevelAccountChangeLogByPage(@RequestBody LowerLevelAccountChangeLogQueryCondParam param);

}
