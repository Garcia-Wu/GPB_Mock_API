package org.gt.projects.gbm.controller;

import java.util.List;
import java.util.Map;

import org.gt.projects.gbm.responseObject.BaseAPIResponse;
import org.gt.projects.gbm.utils.JsonFileUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/mobile/v1")
public class AccountController extends BaseAPIController{
	
	@RequestMapping(value = "accounts/overview", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params) {
		printJsonParams(params);
		List<String> ids = (List<String>) params.get("ids");
		String json = JsonFileUtils.readFileToString("overview_account_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("accounts");
		JSONArray resultArray = JsonFileUtils.getIdsArray(jsonArray, ids);
		
		if(params.get("currency") != null) {
			for (int i = 0; i < resultArray.size(); i++) {
				resultArray.getJSONObject(i).put("currency", params.get("currency"));
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("accounts", resultArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "account/{id}/portfolios", method = {RequestMethod.GET})
	public BaseAPIResponse<JSONObject> portfolios(@PathVariable("id") String id,
												@RequestParam(defaultValue="0")Integer offset,
												@RequestParam(defaultValue="15")Integer limit,
															String currency) {
		String json = JsonFileUtils.readFileToString("account_portfolio_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("portfolios");
		if ("0".equals(id)) {
			jsonArray.clear();
		} else if ("1".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 13);
		} else if ("2".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		} else if ("3".equals(id)) {
			// 获取对应liabilityNum为1的portfolio
			JSONObject oneItem = (JSONObject) jsonArray.get(2);
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		} else if ("7".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 2);
		}
		
		if(currency != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("currency", currency);
			}
		}
		
		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		jsonObject.put("portfolios", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "account/{id}/allocation", method = {RequestMethod.GET})
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
		} else if ("1".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("7currency_list")).getJSONArray("currency");
		} else if ("2".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
		} else if ("3".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("9currency_list")).getJSONArray("currency");
		} else if ("4".equals(id)) {
			classList.clear();
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("7currency_list")).getJSONArray("currency");
		} else if ("5".equals(id)) {
//			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
		} else if ("6".equals(id)) {
			regionList.clear();
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("9currency_list")).getJSONArray("currency");
		} else if ("15".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
			classList.getJSONObject(0).put("name", "Liquidity and Money");
			classList.getJSONObject(0).getJSONArray("nodes").getJSONObject(0).put("name", "Futures on Forex");
			currencyList.getJSONObject(0).put("name", "Hong Kong Dollar");
			regionList.getJSONObject(0).put("name", "Europe");
		} else {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
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

}
