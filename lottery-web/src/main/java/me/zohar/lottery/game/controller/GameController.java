package me.zohar.lottery.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.GameApi;
import me.zohar.lottery.common.vo.Result;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameApi gameApi;

	@GetMapping("/findAllOpenGame")
	@ResponseBody
	public Result findAllOpenGame() {
		return gameApi.findAllOpenGame();
	}

	@GetMapping("/findGamePlayAndNumLocateByGameCode")
	@ResponseBody
	public Result findGamePlayAndNumLocateByGameCode(String gameCode) {
		return gameApi.findGamePlayAndNumLocateByGameCode(gameCode);
	}

	@GetMapping("/findAllGameCategory")
	@ResponseBody
	public Result findAllGameCategory() {
		return gameApi.findAllGameCategory();
	}

	@GetMapping("/findAllGameSituation")
	@ResponseBody
	public Result findAllGameSituation() {
		return gameApi.findAllGameSituation();
	}

	@GetMapping("/findGameSituationByGameCategoryId")
	@ResponseBody
	public Result findGameSituationByGameCategoryId(String gameCategoryId) {
		return gameApi.findGameSituationByGameCategoryId(gameCategoryId);
	}

	@GetMapping("/findGameByGameCode")
	@ResponseBody
	public Result findGameByGameCode(String gameCode) {
		return gameApi.findGameByGameCode(gameCode);
	}

}
