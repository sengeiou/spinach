package me.zohar.lottery.useraccount.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LoginLogVO {

	private String id;

	private String state;

	private String stateName;

	private String ipAddr;

	private String loginLocation;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date loginTime;

	private String browser;

	private String os;

	private String msg;

	private String userName;

}
