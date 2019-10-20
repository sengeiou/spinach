package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface LoginApi {

	@PostMapping("/login")
	Result login(@RequestParam("userName") String userName, @RequestParam("password") String password);

}
