package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.game.param.GameCategoryParam;
import me.zohar.lottery.game.param.GameParam;
import me.zohar.lottery.game.param.GamePlayParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface GameApi {

	@GetMapping("/game/dictSync")
	Result dictSync(@RequestParam("syncGameDict") Boolean syncGameDict,
			@RequestParam("syncGamePlayDict") Boolean syncGamePlayDict);

	@GetMapping("/game/findGameByGameCategoryId")
	Result findGameByGameCategoryId(@RequestParam("gameCategoryId") String gameCategoryId);

	@GetMapping("/game/delGameById")
	Result delGameById(@RequestParam("id") String id);

	@PostMapping("/game/addOrUpdateGame")
	Result addOrUpdateGame(@RequestBody GameParam param);

	@GetMapping("/game/findGameById")
	Result findGameById(@RequestParam("id") String id);

	@GetMapping("/game/findGamePlayByGameCode")
	Result findGamePlayByGameCode(@RequestParam("gameCode") String gameCode);

	@GetMapping("/game/findGamePlayDetailsById")
	Result findGamePlayDetailsById(@RequestParam("id") String id);

	@GetMapping("/game/updateGamePlayState")
	Result updateGamePlayState(@RequestParam("id") String id, @RequestParam("state") String state);

	@GetMapping("/game/delGamePlayById")
	Result delGamePlayById(@RequestParam("id") String id);

	@PostMapping("/game/addOrUpdateGameCategory")
	Result addOrUpdateGameCategory(@RequestBody GameCategoryParam param);

	@GetMapping("/game/delGameCategoryById")
	Result delGameCategoryById(@RequestParam("id") String id);

	@GetMapping("/game/findGameCategoryById")
	Result findGameCategoryById(@RequestParam("id") String id);

	@PostMapping("/game/addOrUpdateGamePlay")
	Result addOrUpdateGamePlay(@RequestBody GamePlayParam param);

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
