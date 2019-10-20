package me.zohar.lottery.useraccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.UserAccountApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.UserAccountDetails;
import me.zohar.lottery.useraccount.param.AccountChangeLogQueryCondParam;
import me.zohar.lottery.useraccount.param.AddUserAccountParam;
import me.zohar.lottery.useraccount.param.BindBankInfoParam;
import me.zohar.lottery.useraccount.param.LoginLogQueryCondParam;
import me.zohar.lottery.useraccount.param.UserAccountEditParam;
import me.zohar.lottery.useraccount.param.UserAccountQueryCondParam;

@Controller
@RequestMapping("/userAccount")
public class UserAccountController {

	@Autowired
	private UserAccountApi userAccountApi;

	@PostMapping("/findLoginLogByPage")
	@ResponseBody
	public Result findLoginLogByPage(@RequestBody LoginLogQueryCondParam param) {
		return userAccountApi.findLoginLogByPage(param);
	}

	@PostMapping("/findAccountChangeLogByPage")
	@ResponseBody
	public Result findAccountChangeLogByPage(@RequestBody AccountChangeLogQueryCondParam param) {
		return userAccountApi.findAccountChangeLogByPage(param);
	}

	@GetMapping("/findUserAccountDetailsInfoById")
	@ResponseBody
	public Result findUserAccountDetailsInfoById(String userAccountId) {
		return userAccountApi.findUserAccountDetailsInfoById(userAccountId);
	}

	@PostMapping("/findUserAccountDetailsInfoByPage")
	@ResponseBody
	public Result findUserAccountDetailsInfoByPage(@RequestBody UserAccountQueryCondParam param) {
		return userAccountApi.findUserAccountDetailsInfoByPage(param);
	}

	@PostMapping("/bindBankInfo")
	@ResponseBody
	public Result bindBankInfo(@RequestBody BindBankInfoParam param) {
		return userAccountApi.bindBankInfo(param);
	}

	@GetMapping("/getBankInfo")
	@ResponseBody
	public Result getBankInfo(String userAccountId) {
		return userAccountApi.getBankInfo(userAccountId);
	}

	@GetMapping("/modifyLoginPwd")
	@ResponseBody
	public Result modifyLoginPwd(String userAccountId, String newLoginPwd) {
		return userAccountApi.modifyLoginPwd(userAccountId, newLoginPwd);
	}

	@GetMapping("/modifyMoneyPwd")
	@ResponseBody
	public Result modifyMoneyPwd(String userAccountId, String newMoneyPwd) {
		return userAccountApi.modifyMoneyPwd(userAccountId, newMoneyPwd);
	}

	@PostMapping("/updateUserAccount")
	@ResponseBody
	public Result updateUserAccount(@RequestBody UserAccountEditParam param) {
		return userAccountApi.updateUserAccount(param);
	}

	@GetMapping("/getUserAccountInfo")
	@ResponseBody
	public Result getUserAccountInfo() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if ("anonymousUser".equals(principal)) {
			return Result.success();
		}
		UserAccountDetails user = (UserAccountDetails) principal;
		return userAccountApi.getUserAccountInfo(user.getUserAccountId());
	}

	@GetMapping("/delUserAccount")
	@ResponseBody
	public Result delUserAccount(String userAccountId) {
		return userAccountApi.delUserAccount(userAccountId);
	}

	@PostMapping("/addUserAccount")
	@ResponseBody
	public Result addUserAccount(@RequestBody AddUserAccountParam param) {
		return userAccountApi.addUserAccount(param);
	}

}
