package me.zohar.lottery.rechargewithdraw.param;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 发起提现入参
 * 
 * @author zohar
 * @date 2019年2月23日
 *
 */
@Data
public class StartWithdrawParam {

	/**
	 * 提现金额
	 */
	@NotNull
	@DecimalMin(value = "0", inclusive = false, message = "withdrawAmount不能少于或等于0")
	private Double withdrawAmount;

	/**
	 * 资金密码
	 */
	@NotBlank
	private String moneyPwd;

	/**
	 * 用户账号id
	 */
	@NotBlank
	private String userAccountId;

}
