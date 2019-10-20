package me.zohar.lottery.game.convert;

import org.springframework.beans.BeanUtils;

import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.game.domain.Game;
import me.zohar.lottery.game.domain.GameCategory;
import me.zohar.lottery.game.domain.GamePlay;
import me.zohar.lottery.game.domain.NumLocate;
import me.zohar.lottery.game.domain.OptionalNum;
import me.zohar.lottery.game.param.GameCategoryParam;
import me.zohar.lottery.game.param.GameParam;
import me.zohar.lottery.game.param.GamePlayParam;
import me.zohar.lottery.game.param.NumLocateParam;
import me.zohar.lottery.game.param.OptionalNumParam;

public class ConvertPoWithGame {

	public static GameCategory convertToPo(GameCategoryParam param) {
		GameCategory po = new GameCategory();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

	public static Game convertToPo(GameParam param) {
		Game po = new Game();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

	public static GamePlay convertToPo(GamePlayParam param) {
		GamePlay po = new GamePlay();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

	public static NumLocate convertToPo(NumLocateParam param) {
		NumLocate po = new NumLocate();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

	public static OptionalNum convertToPo(OptionalNumParam param) {
		OptionalNum po = new OptionalNum();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

}
