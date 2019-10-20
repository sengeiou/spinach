package me.zohar.lottery.information.param;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AddOrUpdateInformationParam {

	private String id;

	private String title;

	private String content;

	private String source;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	private Date publishTime;
	
}
