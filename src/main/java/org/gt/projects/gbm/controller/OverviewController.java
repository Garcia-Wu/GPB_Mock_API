package org.gt.projects.gbm.controller;

import java.util.Collections;

import org.gt.projects.gbm.base.BaseAPIController;
import org.gt.projects.gbm.base.BaseAPIResponse;
import org.gt.projects.gbm.base.comparable.JsonCompare;
import org.gt.projects.gbm.utils.JsonFileUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/mobile/v1/customer")
public class OverviewController extends BaseAPIController {

	@RequestMapping(value = "{id}/overview", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> overview(@PathVariable("id") String id, String currency) {
		JSONObject jsonObject = JSONObject.fromObject(JsonFileUtils.readFileToString("overview"));
		jsonObject.getJSONObject("customer").put("id", id);
		if (id.equals("0")) {
			jsonObject.getJSONObject("asset").put("amount", 0);
		} else if (id.equals("5") || id.equals("6") || id.equals("7")) {
			jsonObject.getJSONObject("asset").put("amount", 13560001.01);
			if(id.equals("6")) {
				jsonObject.getJSONObject("customer").put("name", "WwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
			}
		}
		if (currency != null) {
			jsonObject.getJSONObject("asset").put("currency", currency);
		}
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{id}/accounts", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> accounts(@PathVariable("id") String id,
												@RequestParam(defaultValue="0")Integer offset,
												@RequestParam(defaultValue="15")Integer limit,
															String currency) {
		String json = JsonFileUtils.readFileToString("overview_account_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("accounts");
		
		if ("0".equals(id)) {
			jsonArray.clear();
		} else if ("1".equals(id)) {
			JSONObject oneItem = (JSONObject) jsonArray.get(0);
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		} else if ("2".equals(id)) {
			// 获取ID为7与8的数据（ID为7对应的portfolioNumber为2）
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 3, 2);
		} else if ("3".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 13);
		} else if ("4".equals(id)) {
			// 获取对应portfolioNum为1的account
			JSONObject oneItem = (JSONObject) jsonArray.get(2);
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		} else if ("7".equals(id)) {
			// fix for noTruncation
			jsonArray.getJSONObject(0).put("name", "Ada");
			for (int i = 0; i < jsonArray.size() - 1; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				jsonObject.put("id", String.valueOf((15 + jsonObject.getInt("id"))));
			}
		}
		
		
		if (currency != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("currency", currency);
			}
		}

		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		jsonObject.put("accounts", pageJson);
		jsonObject.put("totalSize", jsonArray.size());

		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{id}/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocation(@PathVariable("id") String id,
//												@RequestParam(defaultValue="0")Integer offset,
//												@RequestParam(defaultValue="15")Integer limit,
												String currency, String category) {
		JSONObject result = new JSONObject();
		JSONArray classList = JSONObject.fromObject(JsonFileUtils.readFileToString("hasSubClass_list")).getJSONArray("clazz");
		JSONArray regionList = JSONObject.fromObject(JsonFileUtils.readFileToString("region_list")).getJSONArray("region");
		JSONArray currencyList = new JSONArray();
		
		if ("0".equals(id)) {
			classList.clear();
			regionList.clear();
		} else if ("1".equals(id) || "4".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("7currency_list")).getJSONArray("currency");
		} else if ("2".equals(id) || "5".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
		} else if ("3".equals(id) || "6".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("9currency_list")).getJSONArray("currency");
		} else {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
			
			// fix for noTruncation
			if("7".equals(id)) {
				classList.getJSONObject(0).put("name", "Liquidity and Money");
				classList.getJSONObject(0).getJSONArray("nodes").getJSONObject(0).put("name", "Futures on Forex");
				currencyList.getJSONObject(0).put("name", "Hong Kong Dollar");
				regionList.getJSONObject(0).put("name", "Europe");
			}
			
		}

		if (currency != null) {
			JsonFileUtils.replaceProperty(classList, "currency", currency);
			for (int i = 0; i < classList.size(); i++) {
				JsonFileUtils.replaceProperty(classList.getJSONObject(i).getJSONArray("nodes"), "currency", currency);
			}
			JsonFileUtils.replaceProperty(currencyList, "currency", currency);
			JsonFileUtils.replaceProperty(regionList, "currency", currency);
		}
		
		result.put("clazz", classList);
		result.put("currency", currencyList);
		result.put("region", regionList);

		if (category != null) {
			if (category.equalsIgnoreCase("ASSET")) {
				result.remove("currency");
				result.remove("region");
			} else if (category.equalsIgnoreCase("CURRENCY")) {
				result.remove("clazz");
				result.remove("region");
			} else if (category.equalsIgnoreCase("REGION")) {
				result.remove("clazz");
				result.remove("currency");
			}
		}
		return new BaseAPIResponse<JSONObject>(result);
	}
	
	@RequestMapping(value = "{id}/currency", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> currency(@PathVariable("id") String id) {
		if("2".equals(id)) {
			BaseAPIResponse<JSONObject> response = new BaseAPIResponse<>();
			response.setCode("1001");
			response.setMessage("error!");
			return response;
		} else if("3".equals(id)) {
			BaseAPIResponse<JSONObject> response = new BaseAPIResponse<>();
			response.setCode("1002");
			response.setMessage("error!");
			return response;
		} 
		
		String json = JsonFileUtils.readFileToString("currency");
		JSONObject jsonObject = JSONObject.fromObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray("currencies");
		Collections.sort(jsonArray, JsonCompare.getLetterOrderAsc("code"));
		
		if("1".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		}
		
		jsonObject.put("currencies", jsonArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

}
