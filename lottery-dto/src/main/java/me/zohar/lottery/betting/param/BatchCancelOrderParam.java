package me.zohar.lottery.betting.param;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class BatchCancelOrderParam {

	@NotEmpty
	private List<String> orderIds;

	@NotBlank
	private String userAccountId;
}
