package me.zohar.lottery.useraccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import me.zohar.lottery.api.LoginApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.JwtTokenUtil;
import me.zohar.lottery.useraccount.vo.LoginAccountInfoVO;

@RestController
public class LoginController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private LoginApi loginApi;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(String userName, String password) {
		Result result = loginApi.login(userName, password);
		LoginAccountInfoVO loginAccountInfo = JSON.parseObject(JSON.toJSONString(result.getData()),
				LoginAccountInfoVO.class);
		String token = jwtTokenUtil.generateToken(loginAccountInfo);
		return Result.success().setData(token);
	}

}
