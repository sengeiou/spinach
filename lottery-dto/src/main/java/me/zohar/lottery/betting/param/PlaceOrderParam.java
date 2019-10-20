package me.zohar.lottery.betting.param;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 下单入参
 * 
 * @author zohar
 * @date 2019年1月17日
 *
 */
@Data
public class PlaceOrderParam {
	
	@NotBlank
	private String userAccountId;

	/**
	 * 游戏代码
	 */
	@NotBlank
	private String gameCode;

	/**
	 * 期号
	 */
	@NotNull
	private Long issueNum;

	/**
	 * 投注底数金额
	 */
	@NotNull
	@DecimalMin(value = "0", inclusive = false)
	private Double baseAmount;

	/**
	 * 倍数
	 */
	@NotNull
	@DecimalMin(value = "1", inclusive = true)
	private Double multiple;

	/**
	 * 追号标识
	 */
	@NotNull
	private Boolean trackingNumberFlag;

	/**
	 * 返点
	 */
	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private Double rebate;

	/**
	 * 投注记录集合
	 */
	@NotEmpty
	@Valid
	private List<BettingRecordParam> bettingRecords;

}
