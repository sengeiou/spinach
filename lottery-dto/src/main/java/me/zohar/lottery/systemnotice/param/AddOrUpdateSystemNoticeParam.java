package me.zohar.lottery.systemnotice.param;

import lombok.Data;

@Data
public class AddOrUpdateSystemNoticeParam {

	private String id;

	private String noticeTitle;

	private String noticeContent;

	/**
	 * 发布日期
	 */
	private String publishDate;

}
