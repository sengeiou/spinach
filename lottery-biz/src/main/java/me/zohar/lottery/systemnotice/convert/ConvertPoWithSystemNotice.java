package me.zohar.lottery.systemnotice.convert;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.systemnotice.domain.SystemNotice;
import me.zohar.lottery.systemnotice.param.AddOrUpdateSystemNoticeParam;

public class ConvertPoWithSystemNotice {

	public static SystemNotice convertToPo(AddOrUpdateSystemNoticeParam param) {
		SystemNotice po = new SystemNotice();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		po.setCreateTime(new Date());
		po.setPublishDate(DateUtil.parse(param.getPublishDate(), DatePattern.NORM_DATE_PATTERN));
		return po;
	}

}
