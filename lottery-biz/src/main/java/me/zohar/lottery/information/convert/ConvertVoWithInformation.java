package me.zohar.lottery.information.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.information.domain.InformationCrawler;
import me.zohar.lottery.information.domain.LotteryInformation;
import me.zohar.lottery.information.vo.LotteryInformationCrawlerVO;
import me.zohar.lottery.information.vo.LotteryInformationVO;

public class ConvertVoWithInformation {

	public static List<LotteryInformationCrawlerVO> convertLotteryInformationCrawler(
			List<InformationCrawler> lotteryInformationCrawlers) {
		if (CollectionUtil.isEmpty(lotteryInformationCrawlers)) {
			return new ArrayList<>();
		}
		List<LotteryInformationCrawlerVO> vos = new ArrayList<>();
		for (InformationCrawler lotteryInformationCrawler : lotteryInformationCrawlers) {
			vos.add(convertLotteryInformationCrawler(lotteryInformationCrawler));
		}
		return vos;
	}

	public static LotteryInformationCrawlerVO convertLotteryInformationCrawler(
			InformationCrawler lotteryInformationCrawler) {
		if (lotteryInformationCrawler == null) {
			return null;
		}
		LotteryInformationCrawlerVO vo = new LotteryInformationCrawlerVO();
		BeanUtils.copyProperties(lotteryInformationCrawler, vo);
		return vo;
	}

	public static List<LotteryInformationVO> convertLotteryInformation(List<LotteryInformation> lotteryInformations) {
		if (CollectionUtil.isEmpty(lotteryInformations)) {
			return new ArrayList<>();
		}
		List<LotteryInformationVO> vos = new ArrayList<>();
		for (LotteryInformation lotteryInformation : lotteryInformations) {
			vos.add(convertLotteryInformation(lotteryInformation));
		}
		return vos;
	}

	public static LotteryInformationVO convertLotteryInformation(LotteryInformation lotteryInformation) {
		if (lotteryInformation == null) {
			return null;
		}
		LotteryInformationVO vo = new LotteryInformationVO();
		BeanUtils.copyProperties(lotteryInformation, vo);
		return vo;
	}

	public static LotteryInformation convertToPo(LotteryInformationVO vo) {
		LotteryInformation po = new LotteryInformation();
		BeanUtils.copyProperties(vo, po);
		po.setId(IdUtils.getId());
		return po;
	}

}
