package me.zohar.lottery.issue.param;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LotteryHistoryParam {

	@NotBlank
	private String gameCode;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lotteryDate;

}
