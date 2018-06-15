package org.gt.projects.gbm.controller;

import java.util.List;
import java.util.Map;

import org.gt.projects.gbm.responseObject.BaseAPIResponse;
import org.gt.projects.gbm.utils.JsonFileUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController extends BaseAPIController{
	
	@RequestMapping(value = "/overview", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params) {
		printParams(params);
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
	
	@RequestMapping(value = "/holdings", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> holdings(@RequestBody Map<String, Object> params) {
		printParams(params);
		String json = JsonFileUtils.readFileToString("portfolio_holding_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("holdings");
		String id = "";
		if(params.get("id") != null) {
			id = params.get("id").toString();
		}
		if ("0".equals(id)) {
			jsonArray.clear();
		} else {
			// 增加数据以供测试使用
			Integer holdingId = jsonArray.getJSONObject(0).getInt("id");
			String name = jsonArray.getJSONObject(0).getString("name");
			String code = jsonArray.getJSONObject(0).getString("code");
			Double weight = jsonArray.getJSONObject(0).getDouble("weight");
			Double asset = jsonArray.getJSONObject(0).getDouble("asset");
			String holdingCurrency = jsonArray.getJSONObject(0).getString("currency");
			JSONObject holding = null;
			for (int i = 1; i <= 30; i++) {
				holding = new JSONObject();
				holding.put("id", holdingId + i);
				holding.put("name", name + i);
				holding.put("code", code + i);
				holding.put("weight", weight);
				holding.put("asset", asset);
				holding.put("currency", holdingCurrency);
				jsonArray.add(holding);
			}
		}
		
		if(params.get("currency") != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("currency", params.get("currency"));
			}
		}
		
		int page = 0;
		int pageSize = 15;
		if(params.get("page") != null) {
			page = (int) params.get("page");
		}
		if(params.get("pageSize") != null) {
			pageSize = (int) params.get("pageSize");
		}
		
		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, page, pageSize);
		jsonObject.put("holdings", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		jsonObject.put("hasLiability", "Y");
		if("0".equals(id) || "4".equals(id)) {
			jsonObject.put("hasLiability", "N");
		} 
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "/allocation", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> allocation(@RequestBody Map<String, Object> params) {
		printParams(params);
		
		JSONObject result = new JSONObject();
		JSONArray classList = JSONObject.fromObject(JsonFileUtils.readFileToString("hasSubClass_list")).getJSONArray("clazz");
		JSONArray regionList = JSONObject.fromObject(JsonFileUtils.readFileToString("region_list")).getJSONArray("region");
		JSONArray currencyList = new JSONArray();
		
		String id = params.get("id").toString();
		if ("0".equals(id)) {
			classList.clear();
			regionList.clear();
		} else if ("1".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("7currency_list")).getJSONArray("currency");
		} else if ("2".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
		} else if ("3".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("9currency_list")).getJSONArray("currency");
		} else {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
		}

		if (params.get("currency") != null) {
			JsonFileUtils.replaceProperty(classList, "currency", params.get("currency"));
			for (int i = 0; i < classList.size(); i++) {
				JsonFileUtils.replaceProperty(classList.getJSONObject(i).getJSONArray("nodes"), "currency", params.get("currency"));
			}
			JsonFileUtils.replaceProperty(currencyList, "currency", params.get("currency"));
			JsonFileUtils.replaceProperty(regionList, "currency", params.get("currency"));
		}
		
		result.put("clazz", classList);
		result.put("currency", currencyList);
		result.put("region", regionList);

		if (params.get("category") != null) {
			String category = params.get("category").toString();
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
//	
//	@RequestMapping(value = "/allocation", method = {RequestMethod.POST})
//	public BaseAPIResponse<JSONObject> allocation(@RequestBody Map<String, Object> params) {
//		printParams(params);
//		String fileName = "";
//		String id = params.get("id").toString();
//		if("0".equals(id)) {
//			fileName = "allocation_noData";
//		} else if ("1".equals(id)) {
//			fileName = "breakDown_hasSubClass_7currency";
//		} else if ("2".equals(id)) {
//			fileName = "breakDown_hasSubClass_8currency";
//		} else if ("3".equals(id)) {
//			fileName = "breakDown_hasSubClass_9currency";
//		} else {
//			fileName = "breakDownDefault";
//		}
//		String json = JsonFileUtils.readFileToString(fileName);
//		if(params.get("currency") != null) {
//			json = json.replaceAll("GBP", params.get("currency").toString());
//		} 
//		
//		if(params.get("category") != null) {
//			String category = params.get("category").toString();
//			String jsonField = "";
//			if(category.equalsIgnoreCase("ASSET")) {
//				jsonField = "clazz";
//			}else if(category.equalsIgnoreCase("CURRENCY")) {
//				jsonField = "currency";
//			}else if(category.equalsIgnoreCase("REGION")) {
//				jsonField = "region";
//			}
//			if(!jsonField.equals("")) {
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put(jsonField, JSONObject.fromObject(json).get(jsonField));
//				json = jsonObject.toString();
//			}
//		}
//		return new BaseAPIResponse<JSONObject>(json);
//	}
	
	@RequestMapping(value = "/liability/detail", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> liabilityDetail(@RequestBody Map<String, Object> params) {
		printParams(params);
		String jsonName = "contingent_liabilities_list_USD";
		String id = "0";
		String reportCurrency = "USD";
		if(params.get("id") != null) {
			id = params.get("id").toString();
		}
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
		if (params.get("currency") != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("baseCurrency", params.get("currency"));
				jsonArray.getJSONObject(i).put("remainingBaseCurrency", params.get("currency"));
			}
		}

		int page = 0;
		int pageSize = 15;
		if(params.get("page") != null) {
			page = (int) params.get("page");
		}
		if(params.get("pageSize") != null) {
			pageSize = (int) params.get("pageSize");
		}
		
		JSONObject jsonObject = new JSONObject();	
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, page, pageSize);
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
	
	@RequestMapping(value = "/transactions", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> transactions(@RequestBody Map<String, Object> params) {
		printParams(params);
		String json = JsonFileUtils.readFileToString("portfolio_transactions_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("transactions");
		String id = params.get("id").toString();
		if(id.equals("0")) {
			jsonArray.clear();
		} else if ("2".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 13);
		} else if ("3".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		} else if ("4".equals(id)) {
			JSONObject oneItem = (JSONObject) jsonArray.get(0);
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		} 
		
//		if (params.get("currency") != null) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				jsonArray.getJSONObject(i).put("currency", params.get("currency"));
//			}
//		}

		if(params.get("type") != null) {
			String type = params.get("type").toString();
			if(!type.equalsIgnoreCase("all")) {
				jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", type);
			}
		}

		int page = 0;
		int pageSize = 15;
		if(params.get("page") != null) {
			page = (int) params.get("page");
		}
		if(params.get("pageSize") != null) {
			pageSize = (int) params.get("pageSize");
		}
		
		JSONObject jsonObject = new JSONObject();	
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, page, pageSize);
		jsonObject.put("transactions", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
}
