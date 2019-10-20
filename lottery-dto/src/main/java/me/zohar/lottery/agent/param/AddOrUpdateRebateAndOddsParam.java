package me.zohar.lottery.agent.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddOrUpdateRebateAndOddsParam {

	private String id;

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

}
