package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.systemnotice.param.AddOrUpdateSystemNoticeParam;
import me.zohar.lottery.systemnotice.param.SystemNoticeQueryCondParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface SystemNoticeApi {

	@PostMapping("/systemNotice/findSystemNoticeByPage")
	Result findSystemNoticeByPage(@RequestBody SystemNoticeQueryCondParam param);

	@PostMapping("/systemNotice/addOrUpdateSystemNotice")
	Result addOrUpdateSystemNotice(@RequestBody AddOrUpdateSystemNoticeParam param);

	@GetMapping("/systemNotice/delSystemNoticeById")
	Result delSystemNoticeById(@RequestParam(value = "id") String id);
	
	@GetMapping("/systemNotice/findSystemNoticeById")
	Result findSystemNoticeById(@RequestParam(value = "id") String id);

	@GetMapping("/systemNotice/findTop5PublishedSystemNotice")
	Result findTop5PublishedSystemNotice();

}
