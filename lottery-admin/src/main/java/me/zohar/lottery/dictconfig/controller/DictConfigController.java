package me.zohar.lottery.dictconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.DictConfigApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.dictconfig.param.AddOrUpdateDictTypeParam;
import me.zohar.lottery.dictconfig.param.ConfigItemQueryCondParam;
import me.zohar.lottery.dictconfig.param.ConfigParam;
import me.zohar.lottery.dictconfig.param.DictTypeQueryCondParam;
import me.zohar.lottery.dictconfig.param.UpdateDictDataParam;

@Controller
@RequestMapping("/dictconfig")
public class DictConfigController {

	@Autowired
	private DictConfigApi dictConfigApi;

	@PostMapping("/updateDictData")
	@ResponseBody
	public Result updateDictData(@RequestBody UpdateDictDataParam param) {
		return dictConfigApi.updateDictData(param);
	}

	@GetMapping("/findDictItemByDictTypeId")
	@ResponseBody
	public Result findDictItemByDictTypeId(String dictTypeId) {
		return dictConfigApi.findDictItemByDictTypeId(dictTypeId);
	}

	@GetMapping("/delDictTypeById")
	@ResponseBody
	public Result delDictTypeById(String id) {
		return dictConfigApi.delDictTypeById(id);
	}

	@PostMapping("/addOrUpdateDictType")
	@ResponseBody
	public Result addOrUpdateDictType(@RequestBody AddOrUpdateDictTypeParam param) {
		return dictConfigApi.addOrUpdateDictType(param);
	}

	@GetMapping("/findDictTypeById")
	@ResponseBody
	public Result findDictTypeById(String id) {
		return dictConfigApi.findDictTypeById(id);
	}

	@PostMapping("/findDictTypeByPage")
	@ResponseBody
	public Result findDictTypeByPage(@RequestBody DictTypeQueryCondParam param) {
		return dictConfigApi.findDictTypeByPage(param);
	}

	@GetMapping("/findDictItemInCache")
	@ResponseBody
	public Result findDictItemInCache(String dictTypeCode) {
		return dictConfigApi.findDictItemInCache(dictTypeCode);
	}

	@PostMapping("/findConfigItemByPage")
	@ResponseBody
	public Result findConfigItemByPage(@RequestBody ConfigItemQueryCondParam param) {
		return dictConfigApi.findConfigItemByPage(param);
	}

	@GetMapping("/findConfigItemById")
	@ResponseBody
	public Result findConfigItemById(String id) {
		return dictConfigApi.findConfigItemById(id);
	}

	@PostMapping("/addOrUpdateConfig")
	@ResponseBody
	public Result addOrUpdateConfig(@RequestBody ConfigParam configParam) {
		return dictConfigApi.addOrUpdateConfig(configParam);
	}

	@GetMapping("/delConfigById")
	@ResponseBody
	public Result delConfigById(String id) {
		return dictConfigApi.delConfigById(id);
	}

}
