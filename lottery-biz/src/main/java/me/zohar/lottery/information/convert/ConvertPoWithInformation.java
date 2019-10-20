package me.zohar.lottery.information.convert;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.information.domain.InformationCrawler;
import me.zohar.lottery.information.domain.LotteryInformation;
import me.zohar.lottery.information.param.AddOrUpdateInformationCrawlerParam;
import me.zohar.lottery.information.param.AddOrUpdateInformationParam;
import me.zohar.lottery.information.param.SyncInformationParam;

public class ConvertPoWithInformation {

	public static InformationCrawler convertToPo(AddOrUpdateInformationCrawlerParam param) {
		InformationCrawler po = new InformationCrawler();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setCreateTime(new Date());
		return po;
	}

	public static LotteryInformation convertToPo(AddOrUpdateInformationParam param) {
		LotteryInformation po = new LotteryInformation();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

	public static LotteryInformation convertToPo(SyncInformationParam param) {
		LotteryInformation po = new LotteryInformation();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

}
