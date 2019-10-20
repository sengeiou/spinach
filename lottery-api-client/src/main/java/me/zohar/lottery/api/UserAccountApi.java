package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.useraccount.param.AccountChangeLogQueryCondParam;
import me.zohar.lottery.useraccount.param.AddUserAccountParam;
import me.zohar.lottery.useraccount.param.BindBankInfoParam;
import me.zohar.lottery.useraccount.param.LoginLogQueryCondParam;
import me.zohar.lottery.useraccount.param.LowerLevelAccountChangeLogQueryCondParam;
import me.zohar.lottery.useraccount.param.ModifyLoginPwdParam;
import me.zohar.lottery.useraccount.param.ModifyMoneyPwdParam;
import me.zohar.lottery.useraccount.param.UserAccountEditParam;
import me.zohar.lottery.useraccount.param.UserAccountQueryCondParam;
import me.zohar.lottery.useraccount.param.UserAccountRegisterParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface UserAccountApi {

	@PostMapping("/userAccount/findLoginLogByPage")
	Result findLoginLogByPage(@RequestBody LoginLogQueryCondParam param);

	@PostMapping("/userAccount/findAccountChangeLogByPage")
	Result findAccountChangeLogByPage(@RequestBody AccountChangeLogQueryCondParam param);

	@GetMapping("/userAccount/findUserAccountDetailsInfoById")
	Result findUserAccountDetailsInfoById(@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/userAccount/findUserAccountDetailsInfoByPage")
	Result findUserAccountDetailsInfoByPage(@RequestBody UserAccountQueryCondParam param);

	@GetMapping("/userAccount/modifyLoginPwd")
	Result modifyLoginPwd(@RequestParam(value = "userAccountId") String userAccountId,
			@RequestParam(value = "newLoginPwd") String newLoginPwd);

	@GetMapping("/userAccount/modifyMoneyPwd")
	Result modifyMoneyPwd(@RequestParam(value = "userAccountId") String userAccountId,
			@RequestParam(value = "newMoneyPwd") String newMoneyPwd);

	@PostMapping("/userAccount/updateUserAccount")
	Result updateUserAccount(@RequestBody UserAccountEditParam param);

	@GetMapping("/userAccount/delUserAccount")
	Result delUserAccount(@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/userAccount/addUserAccount")
	Result addUserAccount(@RequestBody AddUserAccountParam param);

	@GetMapping("/userAccount/getLoginAccountInfo")
	Result getLoginAccountInfo(@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/userAccount/bindBankInfo")
	Result bindBankInfo(@RequestBody BindBankInfoParam param);

	@GetMapping("/userAccount/getBankInfo")
	Result getBankInfo(@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/userAccount/modifyLoginPwd")
	Result modifyLoginPwd(@RequestBody ModifyLoginPwdParam param);

	@PostMapping("/userAccount/modifyMoneyPwd")
	Result modifyMoneyPwd(@RequestBody ModifyMoneyPwdParam param);

	@PostMapping("/userAccount/register")
	Result register(@RequestBody UserAccountRegisterParam param);

	@GetMapping("/userAccount/getUserAccountInfo")
	Result getUserAccountInfo(@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/userAccount/findMyAccountChangeLogByPage")
	Result findMyAccountChangeLogByPage(@RequestBody AccountChangeLogQueryCondParam param);

	@PostMapping("/userAccount/findLowerLevelAccountChangeLogByPage")
	Result findLowerLevelAccountChangeLogByPage(@RequestBody LowerLevelAccountChangeLogQueryCondParam param);

}
