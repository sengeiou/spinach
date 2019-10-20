package me.zohar.lottery.mastercontrol.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RechargeSettingVO {

	private String id;

	/**
	 * 订单有效时长
	 */
	private Integer orderEffectiveDuration;

	/**
	 * 充值返水率
	 */
	private Integer returnWaterRate;

	/**
	 * 充值返水率启用标识
	 */
	private Boolean returnWaterRateEnabled;

	/**
	 * 最近修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date latelyUpdateTime;


}
