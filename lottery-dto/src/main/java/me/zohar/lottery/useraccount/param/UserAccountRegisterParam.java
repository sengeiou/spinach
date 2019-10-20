package me.zohar.lottery.useraccount.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserAccountRegisterParam {

	/**
	 * 邀请码
	 */
	private String inviteCode;

	/**
	 * 用户名
	 */
	@NotBlank
	@Pattern(regexp = "^[A-Za-z][A-Za-z0-9]{5,11}$")
	private String userName;

	/**
	 * 真实姓名
	 */
	@NotBlank
	private String realName;

	/**
	 * 登录密码
	 */
	@NotBlank
	@Pattern(regexp = "^[A-Za-z][A-Za-z0-9]{5,14}$")
	private String loginPwd;

}
