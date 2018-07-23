package org.gt.projects.gbm.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.gt.projects.gbm.responseObject.BaseAPIResponse;
import org.gt.projects.gbm.utils.JsonFileUtils;
import org.gt.projects.gbm.utils.TransactionComparable;
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
public class PortfolioController extends BaseAPIController{
	
	@RequestMapping(value = "portfolios/overview", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params) {
		printJsonParams(params);
		List<String> ids = (List<String>) params.get("ids");
		String json = JsonFileUtils.readFileToString("account_portfolio_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("portfolios");
		JSONArray resultArray = JsonFileUtils.getIdsArray(jsonArray, ids);
		
		if(params.get("currency") != null) {
			for (int i = 0; i < resultArray.size(); i++) {
				resultArray.getJSONObject(i).put("currency", params.get("currency"));
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("portfolios", resultArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "portfolio/{id}/holdings", method = {RequestMethod.GET})
	public BaseAPIResponse<JSONObject> holdings(@PathVariable("id") String id,
												@RequestParam(defaultValue="0")Integer offset,
												@RequestParam(defaultValue="15")Integer limit,
															String currency) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("holdings");
		if ("0".equals(id) || "3".equals(id)) {
			jsonArray.clear();
		} else {
			// 增加数据以供测试使用
//			Integer holdingId = jsonArray.getJSONObject(0).getInt("id");
//			String name = jsonArray.getJSONObject(0).getString("name");
//			String code = jsonArray.getJSONObject(0).getString("code");
//			Double weight = jsonArray.getJSONObject(0).getDouble("weight");
//			Double asset = jsonArray.getJSONObject(0).getDouble("asset");
//			String holdingCurrency = jsonArray.getJSONObject(0).getString("currency");
//			JSONObject holding = null;
//			for (int i = 1; i <= 30; i++) {
//				holding = new JSONObject();
//				holding.put("id", holdingId + i);
//				holding.put("name", name + i);
//				holding.put("code", code + i);
//				holding.put("weight", weight);
//				holding.put("asset", asset);
//				holding.put("currency", holdingCurrency);
//				jsonArray.add(holding);
//			}
		}
		
//		if(currency != null) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				jsonArray.getJSONObject(i).put("currency", currency);
//			}
//		}
		
		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		jsonObject.put("holdings", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		jsonObject.put("hasLiability", "Y");
		if("0".equals(id) || "4".equals(id)) {
			jsonObject.put("hasLiability", "N");
		} 
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "portfolio/{id}/allocation", method = {RequestMethod.GET})
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
	
	@RequestMapping(value = "portfolio/{id}/liabilities", method = {RequestMethod.GET})
	public BaseAPIResponse<JSONObject> liabilityDetail(@PathVariable("id") String id,
														@RequestParam(defaultValue="0")Integer offset,
														@RequestParam(defaultValue="15")Integer limit,
														String currency) {
		String jsonName = "contingent_liabilities_list_USD";
		String reportCurrency = "USD";
		if ("2".equals(id) || "3".equals(id)) {
			jsonName = "contingent_liabilities_list_GBP";
			reportCurrency = "GBP";
		} 
		String json = JsonFileUtils.readFileToString(jsonName);
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("liabilities");
		
		if ("1".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 13);
		} else if ("2".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		} else if ("3".equals(id)) {
			JSONObject oneItem = (JSONObject) jsonArray.get(0);
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		} 
		
		JSONObject commiment = new JSONObject();
		commiment.put("currency", reportCurrency);
//		if (currency != null) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				jsonArray.getJSONObject(i).put("baseCurrency", currency);
//				jsonArray.getJSONObject(i).put("remainingBaseCurrency", currency);
//			}
//		}
		
		JSONObject jsonObject = new JSONObject();	
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		jsonObject.put("liabilities", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		
		double amount = 0;
		for (int i = 0; i < jsonArray.size(); i++) {
			amount += jsonArray.getJSONObject(i).getDouble("remainingReportAmount");
		}
		commiment.put("amount", amount);
		jsonObject.put("commiment", commiment);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "portfolio/{id}/transactions", method = {RequestMethod.GET})
	public BaseAPIResponse<JSONObject> transactions(@PathVariable("id") String id,
													@RequestParam(defaultValue="all")String type,
													@RequestParam(defaultValue="0")Integer offset,
													@RequestParam(defaultValue="15")Integer limit,
													String currency) {
		String json = JsonFileUtils.readFileToString("portfolio_transactions_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("transactions");
		if(id.equals("0")) {
			jsonArray.clear();
		} else if ("2".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 13);
		} else if ("3".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		} else if ("4".equals(id)) {
//			JSONObject oneItem = (JSONObject) jsonArray.get(0);
//			jsonArray = new JSONArray();
//			jsonArray.add(oneItem);
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "cash movements", 1);
		} else if ("5".equals(id)) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "purchases", 1);
		} else if ("6".equals(id)) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "sales", 1);
		}
		
//		if (currency != null) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				jsonArray.getJSONObject(i).put("currency", currency);
//			}
//		}

		if(!type.equalsIgnoreCase("all")) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", type);
		}
		
		TransactionComparable com = new TransactionComparable();
		Collections.sort(jsonArray, com);
		
		JSONObject jsonObject = new JSONObject();	
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		jsonObject.put("transactions", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "portfolio/{id}/holdings/detail", method = {RequestMethod.GET})
	public BaseAPIResponse<JSONObject> holdingsDetail(@PathVariable("id") String id,
													@RequestParam(required = true)String holdingid) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_detail_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("holdings");
		jsonArray = JsonFileUtils.getFilterArray(jsonArray, "id", holdingid, 1);
		
		JSONObject jsonObject = new JSONObject();	
		jsonObject.put("holding", jsonArray.get(0));
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
}
