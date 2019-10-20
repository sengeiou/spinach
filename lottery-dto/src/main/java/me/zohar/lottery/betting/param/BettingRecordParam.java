package me.zohar.lottery.betting.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 投注记录入参
 * 
 * @author zohar
 * @date 2019年1月6日
 *
 */
@Data
public class BettingRecordParam {

	/**
	 * 游戏玩法代码
	 */
	@NotBlank
	private String gamePlayCode;

	/**
	 * 所选号码
	 */
	@NotBlank
	private String selectedNo;

	/**
	 * 注数
	 */
	@NotNull
	@DecimalMin(value = "1", inclusive = true)
	private Long bettingCount;

}
