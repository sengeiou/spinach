package me.zohar.lottery.betting.param;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 发起追号入参
 * 
 * @author zohar
 * @date 2019年1月17日
 *
 */
@Data
public class StartTrackingNumberParam {

	@NotBlank
	private String userAccountId;

	/**
	 * 游戏代码
	 */
	@NotBlank
	private String gameCode;

	/**
	 * 投注底数金额
	 */
	@NotNull
	@DecimalMin(value = "0", inclusive = false)
	private Double baseAmount;

	/**
	 * 返点
	 */
	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private Double rebate;

	/**
	 * 中奖即停
	 */
	@NotNull
	private Boolean winToStop;

	/**
	 * 投注记录集合
	 */
	@NotEmpty
	@Valid
	private List<BettingRecordParam> bettingRecords;

	/**
	 * 追号计划集合
	 */
	@NotEmpty
	@Valid
	private List<TrackingNumberPlanParam> plans;

	/**
	 * 追号计划入参
	 * 
	 * @author zohar
	 * @date 2019年5月14日
	 *
	 */
	@Data
	public static class TrackingNumberPlanParam {

		/**
		 * 期号
		 */
		@NotNull
		private Long issueNum;

		/**
		 * 倍数
		 */
		@NotNull
		@DecimalMin(value = "1", inclusive = true)
		private Double multiple;

		/**
		 * 投注订单id
		 */
		private String bettingOrderId;

	}

}
