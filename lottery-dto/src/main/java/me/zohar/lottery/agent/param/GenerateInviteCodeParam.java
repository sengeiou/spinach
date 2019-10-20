package me.zohar.lottery.agent.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GenerateInviteCodeParam {

	@NotBlank
	private String accountType;

	/**
	 * 返点
	 */
	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private Double rebate;

	/**
	 * 赔率
	 */
	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private Double odds;

	/**
	 * 邀请人账号id
	 */
	@NotBlank
	private String inviterId;

}
