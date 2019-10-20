package me.zohar.lottery.agent.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class InviteCodeDetailsInfoVO {

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 邀请码
	 */
	private String code;

	/**
	 * 账号类型
	 */
	private String accountType;

	/**
	 * 返点
	 */
	private Double rebate;

	/**
	 * 赔率
	 */
	private Double odds;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	/**
	 * 有效期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date periodOfValidity;

	private String inviterId;

	/**
	 * 有效标识
	 */
	private Boolean validFlag;

	/**
	 * 邀请注册链接
	 */
	private String inviteRegisterLink;


}
