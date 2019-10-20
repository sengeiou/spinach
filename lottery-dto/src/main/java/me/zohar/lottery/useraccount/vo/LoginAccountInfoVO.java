package me.zohar.lottery.useraccount.vo;

import lombok.Data;

/**
 * 登录账号信息,包含密码
 * 
 * @author zohar
 * @date 2019年1月25日
 *
 */
@Data
public class LoginAccountInfoVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 登录密码
	 */
	private String loginPwd;

	/**
	 * 账号类型
	 */
	private String accountType;

	private String accountTypeName;


}
