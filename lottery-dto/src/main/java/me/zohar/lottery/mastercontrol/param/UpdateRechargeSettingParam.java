package me.zohar.lottery.mastercontrol.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateRechargeSettingParam {

	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private Integer orderEffectiveDuration;

	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private Integer returnWaterRate;

	@NotNull
	private Boolean returnWaterRateEnabled;

}
