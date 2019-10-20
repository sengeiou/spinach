package me.zohar.lottery.systemnotice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.SystemNoticeApi;
import me.zohar.lottery.common.vo.Result;

@Controller
@RequestMapping("/systemNotice")
public class SystemNoticeController {
	
	@Autowired
	private SystemNoticeApi systemNoticeApi;
	
	@GetMapping("/findTop5PublishedSystemNotice")
	@ResponseBody
	public Result findTop5PublishedSystemNotice() {
		return systemNoticeApi.findTop5PublishedSystemNotice();
	}

}
