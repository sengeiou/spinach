package me.zohar.lottery.game.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.dictconfig.DictHolder;
import me.zohar.lottery.game.domain.Game;
import me.zohar.lottery.game.domain.GameCategory;
import me.zohar.lottery.game.domain.GamePlay;
import me.zohar.lottery.game.domain.GameSituation;
import me.zohar.lottery.game.domain.NumLocate;
import me.zohar.lottery.game.domain.OptionalNum;
import me.zohar.lottery.game.vo.GameCategoryVO;
import me.zohar.lottery.game.vo.GamePlayVO;
import me.zohar.lottery.game.vo.GameSituationVO;
import me.zohar.lottery.game.vo.GameVO;
import me.zohar.lottery.game.vo.NumLocateVO;
import me.zohar.lottery.game.vo.OptionalNumVO;

public class ConvertVoWithGame {
	
	public static List<GameCategoryVO> convertGameCategory(Collection<GameCategory> gameCategorys) {
		if (CollectionUtil.isEmpty(gameCategorys)) {
			return new ArrayList<>();
		}
		List<GameCategoryVO> vos = new ArrayList<>();
		for (GameCategory gameCategory : gameCategorys) {
			vos.add(convertGameCategory(gameCategory));
		}
		return vos;
	}

	public static GameCategoryVO convertGameCategory(GameCategory gameCategory) {
		if (gameCategory == null) {
			return null;
		}
		GameCategoryVO vo = new GameCategoryVO();
		BeanUtils.copyProperties(gameCategory, vo);
		return vo;
	}
	
	public static List<GameVO> convertGame(Collection<Game> games) {
		if (CollectionUtil.isEmpty(games)) {
			return new ArrayList<>();
		}
		List<GameVO> vos = new ArrayList<>();
		for (Game game : games) {
			vos.add(convertGame(game));
		}
		return vos;
	}

	public static GameVO convertGame(Game game) {
		if (game == null) {
			return null;
		}
		GameVO vo = new GameVO();
		BeanUtils.copyProperties(game, vo);
		vo.setStateName(DictHolder.getDictItemName("gameState", vo.getState()));
		if (game.getGameCategory() != null) {
			vo.setGameCategoryCode(game.getGameCategory().getGameCategoryCode());
			vo.setGameCategoryName(game.getGameCategory().getGameCategoryName());
		}
		return vo;
	}
	
	public static List<NumLocateVO> convertNumLocate(Collection<NumLocate> numLocates) {
		if (CollectionUtil.isEmpty(numLocates)) {
			return new ArrayList<>();
		}
		List<NumLocateVO> vos = new ArrayList<>();
		for (NumLocate numLocate : numLocates) {
			vos.add(convertNumLocate(numLocate));
		}
		return vos;
	}

	public static NumLocateVO convertNumLocate(NumLocate numLocate) {
		if (numLocate == null) {
			return null;
		}
		NumLocateVO vo = new NumLocateVO();
		BeanUtils.copyProperties(numLocate, vo);
		return vo;
	}
	
	public static List<OptionalNumVO> convertOptionalNum(Collection<OptionalNum> optionalNums) {
		if (CollectionUtil.isEmpty(optionalNums)) {
			return new ArrayList<>();
		}
		List<OptionalNumVO> vos = new ArrayList<>();
		for (OptionalNum optionalNum : optionalNums) {
			vos.add(convertOptionalNum(optionalNum));
		}
		return vos;
	}

	public static OptionalNumVO convertOptionalNum(OptionalNum optionalNum) {
		if (optionalNum == null) {
			return null;
		}
		OptionalNumVO vo = new OptionalNumVO();
		BeanUtils.copyProperties(optionalNum, vo);
		return vo;
	}
	
	
	public static GamePlayVO convertGamePlay(GamePlay gamePlay) {
		if (gamePlay == null) {
			return null;
		}
		GamePlayVO vo = new GamePlayVO();
		BeanUtils.copyProperties(gamePlay, vo);
		vo.setStateName(DictHolder.getDictItemName("gamePlayState", vo.getState()));
		return vo;
	}

	public static GamePlayVO buildGamePlayDetails(GamePlay gamePlay) {
		GamePlayVO vo = convertGamePlay(gamePlay);
		for (NumLocate numLocate : gamePlay.getNumLocates()) {
			NumLocateVO numLocateVO = convertNumLocate(numLocate);
			numLocateVO.setOptionalNums(convertOptionalNum(numLocate.getOptionalNums()));
			vo.getNumLocates().add(numLocateVO);
		}
		return vo;
	}
	
	public static List<GameSituationVO> convertGameSituation(Collection<GameSituation> hotGames) {
		if (CollectionUtil.isEmpty(hotGames)) {
			return new ArrayList<>();
		}
		List<GameSituationVO> vos = new ArrayList<>();
		for (GameSituation hotGame : hotGames) {
			vos.add(convertGameSituation(hotGame));
		}
		return vos;
	}

	public static GameSituationVO convertGameSituation(GameSituation hotGame) {
		if (hotGame == null) {
			return null;
		}
		GameSituationVO vo = new GameSituationVO();
		BeanUtils.copyProperties(hotGame, vo);
		return vo;
	}
	
}
