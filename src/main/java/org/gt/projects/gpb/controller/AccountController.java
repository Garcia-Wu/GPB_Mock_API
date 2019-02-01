package org.gt.projects.gpb.controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.gt.projects.gpb.base.BaseAPIController;
import org.gt.projects.gpb.base.BaseAPIResponse;
import org.gt.projects.gpb.base.BaseException;
import org.gt.projects.gpb.base.comparable.JsonCompare;
import org.gt.projects.gpb.utils.CommonUtil;
import org.gt.projects.gpb.utils.JsonFileUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/mobile/v1/account")
public class AccountController extends BaseAPIController{
	
	@RequestMapping(value = "overview", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params) {
		printJsonParams(params);
		List<String> ids = (List<String>) params.get("ids");
		String json = JsonFileUtils.readFileToString("overview_account_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("accounts");
		JSONArray resultArray = JsonFileUtils.getIdsArray(jsonArray, ids);
		
		if(params.get("currency") != null) {
			for (int i = 0; i < resultArray.size(); i++) {
				resultArray.getJSONObject(i).put("currency", params.get("currency").toString().toUpperCase());
				resultArray.getJSONObject(i).put("liabilitiesCurrency", params.get("currency").toString().toUpperCase());
				resultArray.getJSONObject(i).put("netAssetsCurrency", params.get("currency").toString().toUpperCase());
				resultArray.getJSONObject(i).getJSONObject("ytd").put("currency", params.get("currency").toString().toUpperCase());
			}
		}
		
		for (int i = 0; i < resultArray.size(); i++) {
			resultArray.getJSONObject(i).remove("baseCurrency");
			resultArray.getJSONObject(i).remove("weight");
		}
		JSONObject jsonObject = new JSONObject();
		
		// 计算amount
		for (Object object : resultArray) {
			JSONObject account = (JSONObject) object;
			BaseAPIResponse<JSONObject> allocation = CommonUtil.getAllocationData(account.getString("id"), params.get("currency").toString(), "ASSET");
			BigDecimal amount = new BigDecimal("0");
			for (Object clazz : allocation.getData().getJSONArray("clazz")) {
				JSONObject clazzJson = (JSONObject) clazz;
				amount = amount.add(new BigDecimal(clazzJson.get("amount") + ""));
			}
			account.put("amount", amount);
		}
		
		JsonFileUtils.formatArrayNumber2DP(resultArray);
		jsonObject.put("accounts", resultArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "{id}/portfolios", method = {RequestMethod.GET})
	public BaseAPIResponse<JSONObject> portfolios(@PathVariable("id") String id,
												@RequestParam(defaultValue="0")Integer offset,
												@RequestParam(defaultValue="15")Integer limit,
												@RequestParam(required=true)String currency, HttpServletRequest request) {
		String json = JsonFileUtils.readFileToString("account_portfolio_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("portfolios");
		if ("0".equals(id)) {
			jsonArray.clear();
		} else if ("1".equals(id)) {
//			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 0, 13);
		} else if ("2".equals(id)) {
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 1, 5);
		} else if ("3".equals(id)) {
			JSONObject oneItem = JsonFileUtils.getFilterObject(jsonArray, "id", "0");
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		} else if ("7".equals(id)) {
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 0, 2);
		} else if ("16".equals(id)) {
//			try {
//				Thread.sleep(100 * 1000L);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		} 
		
		if(currency != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("currency", currency.toUpperCase());
			}
		}
		
		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		
		if(isAsia(request)) {
			for (int i = 0; i < pageJson.size(); i++) {
				if(pageJson.getJSONObject(i).getString("mandateType").equals("Advisory")) {
					pageJson.getJSONObject(i).put("name", "Advisory");
				}
				if(pageJson.getJSONObject(i).getString("id").equals("0") || pageJson.getJSONObject(i).getString("id").equals("15")) {
					pageJson.getJSONObject(i).put("weight", "");
				}
			}
		}
		
		for (int i = 0; i < pageJson.size(); i++) {
			pageJson.getJSONObject(i).remove("ytd");
			pageJson.getJSONObject(i).remove("liabilitiesAmount");
			pageJson.getJSONObject(i).remove("liabilitiesCurrency");
			pageJson.getJSONObject(i).remove("netAssetsAmount");
			pageJson.getJSONObject(i).remove("netAssetsCurrency");
		}
		
//		Collections.sort(pageJson, JsonCompare.getNumberDescThenLetterAsc("amount", "name"));

		// 计算amount
		for (Object object : pageJson) {
			JSONObject portfolio = (JSONObject) object;
			BaseAPIResponse<JSONObject> allocation = CommonUtil.getAllocationData(id, currency, "ASSET");
			BigDecimal amount = new BigDecimal("0");
			for (Object clazz : allocation.getData().getJSONArray("clazz")) {
				JSONObject clazzJson = (JSONObject) clazz;
				amount = amount.add(new BigDecimal(clazzJson.get("amount") + ""));
			}
			portfolio.put("amount", amount);
		}
		
		JsonFileUtils.formatArrayNumber2DP(pageJson);
		jsonObject.put("portfolios", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "{id}/allocation", method = {RequestMethod.GET})
	public BaseAPIResponse<JSONObject> allocation(@PathVariable("id") String id,
//												@RequestParam(defaultValue="0")Integer offset,
//												@RequestParam(defaultValue="15")Integer limit,
			@RequestParam(required=true)String currency, @RequestParam(required = true)String category) {
		return CommonUtil.getAllocationData(id, currency, category);
	}
	
	@RequestMapping(value = "{id}/xrate", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> currency(@PathVariable("id") String id) {
		String json = JsonFileUtils.readFileToString("currency");
		JSONObject jsonObject = JSONObject.fromObject(json);
		
		if ("2".equals(id)) {
			BaseAPIResponse<JSONObject> response = new BaseAPIResponse<>();
			response.setCode("1001");
			response.setMessage("error!");
			jsonObject.remove("currencies");
			jsonObject.remove("updateDate");
			response.setData(jsonObject);
			return response;
		} else if ("3".equals(id)) {
			BaseAPIResponse<JSONObject> response = new BaseAPIResponse<>();
			response.setCode("1002");
			response.setMessage("error!");
			jsonObject.remove("currencies");
			jsonObject.remove("updateDate");
			response.setData(jsonObject);
			return response;
		} 
		
		jsonObject.getJSONObject("base").put("code", "USD");
		JSONArray jsonArray = jsonObject.getJSONArray("currencies");
		jsonArray = JsonFileUtils.removeFilterObject(jsonArray, "code", "USD");
		JSONObject gbpCurrency = new JSONObject();
		gbpCurrency.put("code", "GBP");
		gbpCurrency.put("rate", 1.3156);
		jsonArray.add(gbpCurrency);
		Collections.sort(jsonArray, JsonCompare.getLetterOrderAsc("code"));
		
		if("1".equals(id)) {
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 0, 5);
		}
		
		jsonObject.put("currencies", jsonArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "{id}/holdings/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocationHoldingList(@RequestParam(required = true)String currency,
															@PathVariable("id") String id,
															@RequestParam(required=true)String category, 
															@RequestParam(required=true)String categoryId, 
															@RequestParam(defaultValue="0")Integer offset,
															@RequestParam(defaultValue="15")Integer limit) {
		return CommonUtil.getAllocationHoldings(id, currency, category, categoryId, offset, limit);
	}
	
	@RequestMapping("{id}/holdings/allocation/group")
	public BaseAPIResponse<JSONObject> holdingAllocationGroup(@PathVariable String id,
			@RequestParam(required = true) String currency, @RequestParam(required = true) String category,
			@RequestParam(required = true) String categoryId, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit){
		return CommonUtil.getAllocationHoldingGroup(id, currency, category, categoryId, offset, limit);
	}

}
