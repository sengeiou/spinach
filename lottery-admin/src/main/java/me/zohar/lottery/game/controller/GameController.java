package me.zohar.lottery.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.GameApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.game.param.GameCategoryParam;
import me.zohar.lottery.game.param.GameParam;
import me.zohar.lottery.game.param.GamePlayParam;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameApi gameApi;

	@GetMapping("/dictSync")
	@ResponseBody
	public Result dictSync(Boolean syncGameDict, Boolean syncGamePlayDict) {
		return gameApi.dictSync(syncGameDict, syncGamePlayDict);
	}

	@GetMapping("/findGameByGameCategoryId")
	@ResponseBody
	public Result findGameByGameCategoryId(String gameCategoryId) {
		return gameApi.findGameByGameCategoryId(gameCategoryId);
	}

	@GetMapping("/delGameById")
	@ResponseBody
	public Result delGameById(String id) {
		return gameApi.delGameById(id);
	}

	@PostMapping("/addOrUpdateGame")
	@ResponseBody
	public Result addOrUpdateGame(@RequestBody GameParam param) {
		return gameApi.addOrUpdateGame(param);
	}

	@GetMapping("/findGameById")
	@ResponseBody
	public Result findGameById(String id) {
		return gameApi.findGameById(id);
	}

	@GetMapping("/findGamePlayByGameCode")
	@ResponseBody
	public Result findGamePlayByGameCode(String gameCode) {
		return gameApi.findGamePlayByGameCode(gameCode);
	}

	@GetMapping("/findGamePlayDetailsById")
	@ResponseBody
	public Result findGamePlayDetailsById(String id) {
		return gameApi.findGamePlayDetailsById(id);
	}

	@GetMapping("/updateGamePlayState")
	@ResponseBody
	public Result updateGamePlayState(String id, String state) {
		return gameApi.updateGamePlayState(id, state);
	}

	@PostMapping("/addOrUpdateGamePlay")
	@ResponseBody
	public Result addOrUpdateGamePlay(@RequestBody GamePlayParam param) {
		return gameApi.addOrUpdateGamePlay(param);
	}

	@GetMapping("/delGamePlayById")
	@ResponseBody
	public Result delGamePlayById(String id) {
		return gameApi.delGamePlayById(id);
	}

	@GetMapping("/findAllGameCategory")
	@ResponseBody
	public Result findAllGameCategory() {
		return gameApi.findAllGameCategory();
	}

	@PostMapping("/addOrUpdateGameCategory")
	@ResponseBody
	public Result addOrUpdateGameCategory(@RequestBody GameCategoryParam param) {
		return gameApi.addOrUpdateGameCategory(param);
	}

	@GetMapping("/delGameCategoryById")
	@ResponseBody
	public Result delGameCategoryById(String id) {
		return gameApi.delGameCategoryById(id);
	}

	@GetMapping("/findGameCategoryById")
	@ResponseBody
	public Result findGameCategoryById(String id) {
		return gameApi.findGameCategoryById(id);
	}

}
