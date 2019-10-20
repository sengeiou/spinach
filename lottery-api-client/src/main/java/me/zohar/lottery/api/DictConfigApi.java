package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.dictconfig.param.AddOrUpdateDictTypeParam;
import me.zohar.lottery.dictconfig.param.ConfigItemQueryCondParam;
import me.zohar.lottery.dictconfig.param.ConfigParam;
import me.zohar.lottery.dictconfig.param.DictTypeQueryCondParam;
import me.zohar.lottery.dictconfig.param.UpdateDictDataParam;

@FeignClient(value = "${apiName}", configuration = FeignConfiguration.class)
public interface DictConfigApi {

	@GetMapping("/dictconfig/findDictItemInCache")
	Result findDictItemInCache(@RequestParam("dictTypeCode") String dictTypeCode);

	@PostMapping("/dictconfig/updateDictData")
	Result updateDictData(@RequestBody UpdateDictDataParam param);

	@GetMapping("/dictconfig/findDictItemByDictTypeId")
	Result findDictItemByDictTypeId(@RequestParam("dictTypeId") String dictTypeId);
	
	@GetMapping("/dictconfig/delDictTypeById")
	Result delDictTypeById(@RequestParam("id") String id);
	
	@PostMapping("/dictconfig/addOrUpdateDictType")
	Result addOrUpdateDictType(@RequestBody AddOrUpdateDictTypeParam param);
	
	@GetMapping("/dictconfig/findDictTypeById")
	Result findDictTypeById(@RequestParam("id") String id);
	
	@PostMapping("/dictconfig/findDictTypeByPage")
	Result findDictTypeByPage(@RequestBody DictTypeQueryCondParam param);
	
	@PostMapping("/dictconfig/findConfigItemByPage")
	Result findConfigItemByPage(@RequestBody ConfigItemQueryCondParam param);

	@GetMapping("/dictconfig/findConfigItemById")
	Result findConfigItemById(@RequestParam("id") String id);
	
	@PostMapping("/dictconfig/addOrUpdateConfig")
	Result addOrUpdateConfig(@RequestBody ConfigParam param);
	
	@GetMapping("/dictconfig/delConfigById")
	Result delConfigById(@RequestParam("id") String id);
	
}
