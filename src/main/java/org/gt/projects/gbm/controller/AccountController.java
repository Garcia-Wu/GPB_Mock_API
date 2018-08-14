package org.gt.projects.gbm.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.gt.projects.gbm.base.BaseAPIController;
import org.gt.projects.gbm.base.BaseAPIResponse;
import org.gt.projects.gbm.base.BaseException;
import org.gt.projects.gbm.base.comparable.JsonCompare;
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
		
		// fix for noTruncation
//		if(Integer.valueOf(ids.get(0)) > 15) {
//			for (int i = 0; i < ids.size(); i++) {
//				if(!ids.get(i).equals("0")) {
//					ids.set(i, String.valueOf(Integer.valueOf(ids.get(i)) - 15));
//				}
//			}
//			resultArray = JsonFileUtils.getIdsArray(jsonArray, ids);
//			if(resultArray.getJSONObject(0).getInt("id") == 1) {
//				resultArray.getJSONObject(0).put("name", "Ada");
//			}
//		}
		
		for (int i = 0; i < resultArray.size(); i++) {
			resultArray.getJSONObject(i).remove("weight");
			resultArray.getJSONObject(i).put("updateDate", "24 May 2018");
		}
		
		if(params.get("currency") != null) {
			for (int i = 0; i < resultArray.size(); i++) {
				resultArray.getJSONObject(i).put("currency", params.get("currency").toString().toUpperCase());
			}
		}
		JSONObject jsonObject = new JSONObject();
		JsonFileUtils.formatArrayNumber2DP(resultArray);
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
		} else if (Integer.valueOf(id) > 15) {
			// fix for noTruncation
//			jsonArray.getJSONObject(0).put("name", "FX Portfolio 1");
//			for (int i = 0; i < jsonArray.size() - 1; i++) {
//				JSONObject jsonObject = jsonArray.getJSONObject(i);
//				jsonObject.put("id", String.valueOf((15 + jsonObject.getInt("id"))));
//			}
		}
		
		if(currency != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("currency", currency.toUpperCase());
			}
		}
		
		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		for (int i = 0; i < pageJson.size(); i++) {
			pageJson.getJSONObject(i).remove("ytd");
		}

		JsonFileUtils.formatArrayNumber2DP(pageJson);
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
			
			// fix for noTruncation
//			if (Integer.valueOf(id) > 15) {
//				classList.getJSONObject(0).put("name", "Liquidity and Money");
//				classList.getJSONObject(0).getJSONArray("nodes").getJSONObject(0).put("name", "Futures on Forex");
//				currencyList.getJSONObject(0).put("name", "Hong Kong Dollar");
//				regionList.getJSONObject(0).put("name", "Europe");
//			}
			
		}

		if (currency != null) {
			JsonFileUtils.replaceProperty(classList, "currency", currency.toUpperCase());
			for (int i = 0; i < classList.size(); i++) {
				JsonFileUtils.replaceProperty(classList.getJSONObject(i).getJSONArray("nodes"), "currency", currency.toUpperCase());
			}
			JsonFileUtils.replaceProperty(currencyList, "currency", currency.toUpperCase());
			JsonFileUtils.replaceProperty(regionList, "currency", currency.toUpperCase());
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
		JsonFileUtils.formatObjectNumber2DP(result);
		return new BaseAPIResponse<JSONObject>(result);
	}
	
	@RequestMapping(value = "account/{id}/currency", method = { RequestMethod.GET })
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
	
	@RequestMapping(value = "account/{accountId}/holdings/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocationHoldingList(String currency,
															@PathVariable("accountId") String accountId,
															@RequestParam(required=true)String category, 
															@RequestParam(required=true)String id, 
															@RequestParam(defaultValue="0")Integer offset,
															@RequestParam(defaultValue="15")Integer limit) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_list");
		JSONObject resultJson = new JSONObject();
		JSONObject allocation = new JSONObject();
		
		JSONArray jsonArray = null;
		if (category.equalsIgnoreCase("ASSET")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allClass_list")).getJSONArray("clazz");
		} else if (category.equalsIgnoreCase("CURRENCY")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allCurrency_list")).getJSONArray("currency");
		} else if (category.equalsIgnoreCase("REGION")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("region_list")).getJSONArray("region");
		} else {
			throw new BaseException();
		}
		JSONObject jsonObject = JsonFileUtils.getFilterObject(jsonArray, "id", id);
		
		allocation.put("name", jsonObject.getString("name"));
		allocation.put("amount", jsonObject.getDouble("amount"));
		allocation.put("currency", jsonObject.getString("currency"));
		resultJson.put("allocation", allocation);
		
		JSONArray holdingJson = JSONObject.fromObject(json).getJSONArray("holdings");
		JsonFileUtils.removeFilterObject(holdingJson, "id", new String[] {"11","12"});
		resultJson.put("holdings", JsonFileUtils.getPageJsonArray(holdingJson, offset, limit));
		resultJson.put("totalSize", holdingJson.size());
		JsonFileUtils.formatObjectNumber2DP(resultJson, new String[] {"type"});
		return new BaseAPIResponse<JSONObject>(resultJson);
	}

}
