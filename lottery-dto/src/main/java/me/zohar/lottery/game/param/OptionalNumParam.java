package me.zohar.lottery.game.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class OptionalNumParam {

	@NotBlank
	private String num;

	@DecimalMin(value = "0", inclusive = false)
	private Double odds;
	
}
