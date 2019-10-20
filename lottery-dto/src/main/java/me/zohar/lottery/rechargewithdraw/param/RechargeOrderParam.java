package me.zohar.lottery.rechargewithdraw.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 充值订单入参
 * 
 * @author zohar
 * @date 2019年1月21日
 *
 */
@Data
public class RechargeOrderParam {

	/**
	 * 充值方式代码
	 */
	@NotBlank
	private String rechargeWayCode;

	/**
	 * 充值金额
	 */
	@NotNull
	@DecimalMin(value = "0", inclusive = false)
	private Double rechargeAmount;

	/**
	 * 用户账号id
	 */
	@NotBlank
	private String userAccountId;

}
