package me.zohar.lottery.config.security;

import me.zohar.lottery.useraccount.vo.LoginAccountInfoVO;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(LoginAccountInfoVO loginAccountInfo) {
		return new JwtUser(loginAccountInfo.getId());
	}
}
