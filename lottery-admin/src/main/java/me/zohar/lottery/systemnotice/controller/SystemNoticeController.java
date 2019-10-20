package me.zohar.lottery.systemnotice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.SystemNoticeApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.systemnotice.param.AddOrUpdateSystemNoticeParam;
import me.zohar.lottery.systemnotice.param.SystemNoticeQueryCondParam;

@Controller
@RequestMapping("/systemNotice")
public class SystemNoticeController {

	@Autowired
	private SystemNoticeApi systemNoticeApi;

	@PostMapping("/findSystemNoticeByPage")
	@ResponseBody
	public Result findSystemNoticeByPage(@RequestBody SystemNoticeQueryCondParam param) {
		return systemNoticeApi.findSystemNoticeByPage(param);
	}

	@PostMapping("/addOrUpdateSystemNotice")
	@ResponseBody
	public Result addOrUpdateSystemNotice(@RequestBody AddOrUpdateSystemNoticeParam param) {
		return systemNoticeApi.addOrUpdateSystemNotice(param);
	}

	@GetMapping("/delSystemNoticeById")
	@ResponseBody
	public Result delSystemNoticeById(String id) {
		return systemNoticeApi.delSystemNoticeById(id);
	}

	@GetMapping("/findSystemNoticeById")
	@ResponseBody
	public Result findSystemNoticeById(String id) {
		return systemNoticeApi.findSystemNoticeById(id);
	}
	
}
