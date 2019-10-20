package me.zohar.lottery.dictconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.DictConfigApi;
import me.zohar.lottery.common.vo.Result;

@Controller
@RequestMapping("/dictconfig")
public class DictConfigController {

	@Autowired
	private DictConfigApi dictConfigApi;

	@GetMapping("/findDictItemInCache")
	@ResponseBody
	public Result findDictItemInCache(String dictTypeCode) {
		return dictConfigApi.findDictItemInCache(dictTypeCode);
	}

}
