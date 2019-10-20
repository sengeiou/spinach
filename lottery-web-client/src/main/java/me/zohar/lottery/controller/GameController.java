package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;
import me.zohar.lottery.common.vo.Result;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface GameController {

	@GetMapping("/game/findAllOpenGame")
	Result findAllOpenGame();

	@GetMapping("/game/findGamePlayAndNumLocateByGameCode")
	Result findGamePlayAndNumLocateByGameCode(@RequestParam("gameCode") String gameCode);

	@GetMapping("/game/findAllGameCategory")
	Result findAllGameCategory();

	@GetMapping("/game/findAllGameSituation")
	Result findAllGameSituation();

	@GetMapping("/game/findGameSituationByGameCategoryId")
	Result findGameSituationByGameCategoryId(@RequestParam("gameCategoryId") String gameCategoryId);

	@GetMapping("/game/findGameByGameCode")
	Result findGameByGameCode(@RequestParam("gameCode") String gameCode);

}
