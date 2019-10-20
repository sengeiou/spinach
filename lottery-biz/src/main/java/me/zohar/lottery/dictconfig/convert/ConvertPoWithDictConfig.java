package me.zohar.lottery.dictconfig.convert;

import org.springframework.beans.BeanUtils;

import me.zohar.lottery.common.utils.IdUtils;
import me.zohar.lottery.dictconfig.domain.ConfigItem;
import me.zohar.lottery.dictconfig.domain.DictItem;
import me.zohar.lottery.dictconfig.domain.DictType;
import me.zohar.lottery.dictconfig.param.AddOrUpdateDictTypeParam;
import me.zohar.lottery.dictconfig.param.ConfigParam;
import me.zohar.lottery.dictconfig.param.DictDataParam;

public class ConvertPoWithDictConfig {

	public static DictType convertToPo(AddOrUpdateDictTypeParam param) {
		DictType po = new DictType();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}
	
	public static ConfigItem convertToPo(ConfigParam param) {
		ConfigItem po = new ConfigItem();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}
	
	public static DictItem convertToPo(DictDataParam param) {
		DictItem po = new DictItem();
		BeanUtils.copyProperties(param, po);
		po.setId(IdUtils.getId());
		return po;
	}

}
