package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.common.vo.Result;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface DictConfigController {

	@GetMapping("/dictconfig/findDictItemInCache")
	Result findDictItemInCache(@RequestParam("dictTypeCode") String dictTypeCode);

}
