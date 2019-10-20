package me.zohar.lottery.mastercontrol.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateRegisterAmountSettingParam {

	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private Double registerAmount;
	
	@NotNull
	private Boolean enabled;

}
