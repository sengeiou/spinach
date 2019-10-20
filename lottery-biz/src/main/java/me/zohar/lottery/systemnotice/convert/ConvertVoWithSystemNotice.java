package me.zohar.lottery.systemnotice.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.systemnotice.domain.SystemNotice;
import me.zohar.lottery.systemnotice.vo.SystemNoticeVO;

public class ConvertVoWithSystemNotice {

	public static List<SystemNoticeVO> convertFor(List<SystemNotice> systemNotices) {
		if (CollectionUtil.isEmpty(systemNotices)) {
			return new ArrayList<>();
		}
		List<SystemNoticeVO> vos = new ArrayList<>();
		for (SystemNotice systemNotice : systemNotices) {
			vos.add(convertFor(systemNotice));
		}
		return vos;
	}

	public static SystemNoticeVO convertFor(SystemNotice systemNotice) {
		if (systemNotice == null) {
			return null;
		}
		SystemNoticeVO vo = new SystemNoticeVO();
		BeanUtils.copyProperties(systemNotice, vo);
		return vo;
	}
}