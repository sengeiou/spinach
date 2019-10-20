package me.zohar.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class LotteryWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryWebClientApplication.class, args);
	}
}
