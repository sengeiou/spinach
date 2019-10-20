package me.zohar.lottery.mastercontrol.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateInviteRegisterSettingParam {

	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private Integer effectiveDuration;

	@NotNull
	private Boolean enabled;

}
