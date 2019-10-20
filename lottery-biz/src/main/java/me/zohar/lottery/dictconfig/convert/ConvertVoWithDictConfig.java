package me.zohar.lottery.dictconfig.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.collection.CollectionUtil;
import me.zohar.lottery.dictconfig.domain.ConfigItem;
import me.zohar.lottery.dictconfig.domain.DictItem;
import me.zohar.lottery.dictconfig.domain.DictType;
import me.zohar.lottery.dictconfig.vo.ConfigItemVO;
import me.zohar.lottery.dictconfig.vo.DictItemVO;
import me.zohar.lottery.dictconfig.vo.DictTypeVO;

public class ConvertVoWithDictConfig {

	public static List<ConfigItemVO> convertConfigItem(List<ConfigItem> configItems) {
		if (CollectionUtil.isEmpty(configItems)) {
			return new ArrayList<>();
		}
		List<ConfigItemVO> vos = new ArrayList<>();
		for (ConfigItem configItem : configItems) {
			vos.add(convertConfigItem(configItem));
		}
		return vos;
	}

	public static ConfigItemVO convertConfigItem(ConfigItem configItem) {
		if (configItem == null) {
			return null;
		}
		ConfigItemVO vo = new ConfigItemVO();
		BeanUtils.copyProperties(configItem, vo);
		return vo;
	}
	
	public static List<DictItemVO> convertDictItem(List<DictItem> dictItems) {
		if (CollectionUtil.isEmpty(dictItems)) {
			return new ArrayList<>();
		}
		List<DictItemVO> vos = new ArrayList<>();
		for (DictItem dictItem : dictItems) {
			vos.add(convertDictItem(dictItem));
		}
		return vos;
	}

	public static DictItemVO convertDictItem(DictItem dictItem) {
		if (dictItem == null) {
			return null;
		}
		DictItemVO vo = new DictItemVO();
		BeanUtils.copyProperties(dictItem, vo);
		return vo;
	}
	
	public static List<DictTypeVO> convertDictType(List<DictType> dictTypes) {
		if (CollectionUtil.isEmpty(dictTypes)) {
			return new ArrayList<>();
		}
		List<DictTypeVO> vos = new ArrayList<>();
		for (DictType dictType : dictTypes) {
			vos.add(convertDictType(dictType));
		}
		return vos;
	}

	public static DictTypeVO convertDictType(DictType dictType) {
		if (dictType == null) {
			return null;
		}
		DictTypeVO vo = new DictTypeVO();
		BeanUtils.copyProperties(dictType, vo);
		return vo;
	}

}
