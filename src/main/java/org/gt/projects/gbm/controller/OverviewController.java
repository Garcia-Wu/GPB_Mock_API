package org.gt.projects.gbm.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gt.projects.gbm.base.BaseAPIController;
import org.gt.projects.gbm.base.BaseAPIResponse;
import org.gt.projects.gbm.base.BaseException;
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
	public BaseAPIResponse<JSONObject> overview(@PathVariable("id") String id, @RequestParam(required=true)String currency) {
		if(Integer.valueOf(id) > 7) {
			throw new BaseException();
		}
		
		JSONObject jsonObject = JSONObject.fromObject(JsonFileUtils.readFileToString("overview"));
		jsonObject.getJSONObject("customer").put("id", id);
		if (id.equals("0")) {
			jsonObject.getJSONObject("customer").put("name", "");
			jsonObject.getJSONObject("customer").put("amount", 0);
			jsonObject.getJSONObject("customer").put("liabilitiesAmount", 1);
			jsonObject.getJSONObject("customer").put("netAssetsAmount", 0);
			jsonObject.getJSONObject("ytd").put("amount", 0);
		} else if (id.equals("2")) {
			jsonObject.getJSONObject("customer").put("name", "Mr Chen");
			jsonObject.getJSONObject("customer").put("bookingCenter", "HK Accounts");
			jsonObject.getJSONObject("customer").put("liabilitiesAmount", -0.001);
			jsonObject.getJSONObject("customer").put("netAssetsAmount", 38950392011.999);
			jsonObject.getJSONObject("ytd").put("amount", -38950392012D);
		} else if (id.equals("4")) {
			jsonObject.getJSONObject("customer").put("liabilitiesAmount", -38950392012D);
			jsonObject.getJSONObject("customer").put("netAssetsAmount", 0);
		} else if (id.equals("5") || id.equals("6") || id.equals("7")) {
//			jsonObject.getJSONObject("customer").put("amount", 13560001.01);
//			if (id.equals("6")) {
//				jsonObject.getJSONObject("customer").put("name",
//						"WwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
//			}
		} 
		if (currency != null) {
			jsonObject.getJSONObject("customer").put("currency", currency.toUpperCase());
			jsonObject.getJSONObject("customer").put("liabilitiesCurrency", currency.toUpperCase());
			jsonObject.getJSONObject("customer").put("netAssetsCurrency", currency.toUpperCase());
			jsonObject.getJSONObject("ytd").put("currency", currency.toUpperCase());
		}
		JsonFileUtils.formatObjectNumber2DP(jsonObject);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{id}/accounts", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> accounts(@PathVariable("id") String id,
			@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "15") Integer limit,
			@RequestParam(required = true)String currency, HttpServletRequest request, HttpServletResponse response) {
		
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
			JSONObject oneItem = JsonFileUtils.getFilterObject(jsonArray, "id", "3");
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		} else if ("7".equals(id)) {
			// For a timeout
			JSONObject account = JsonFileUtils.getFilterObject(jsonArray, "id", "0");
			account.put("id", "16");
			account.put("name", "B5ED76G ***");
			account.put("externalId", "B5ED76G");
			jsonArray.add(account);
			
			// fix for noTruncation
			// jsonArray.getJSONObject(0).put("name", "Ada");
			// for (int i = 0; i < jsonArray.size() - 1; i++) {
			// JSONObject jsonObject = jsonArray.getJSONObject(i);
			// jsonObject.put("id", String.valueOf((15 + jsonObject.getInt("id"))));
			// }
		}

		if (currency != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("currency", currency.toUpperCase());
			}
		}

		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		for (int i = 0; i < pageJson.size(); i++) {
			pageJson.getJSONObject(i).remove("ytd");
			pageJson.getJSONObject(i).remove("liabilitiesAmount");
			pageJson.getJSONObject(i).remove("liabilitiesCurrency");
			pageJson.getJSONObject(i).remove("netAssetsAmount");
			pageJson.getJSONObject(i).remove("netAssetsCurrency");
		}
		JsonFileUtils.formatArrayNumber2DP(pageJson);
		jsonObject.put("accounts", pageJson);
		jsonObject.put("totalSize", jsonArray.size());

		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{id}/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocation(@PathVariable("id") String id,
			// @RequestParam(defaultValue="0")Integer offset,
			// @RequestParam(defaultValue="15")Integer limit,
			@RequestParam(required=true)String currency, String category, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject result = new JSONObject();
		JSONArray classList = JSONObject.fromObject(JsonFileUtils.readFileToString("hasSubClass_list"))
				.getJSONArray("clazz");
		JSONArray regionList = JSONObject.fromObject(JsonFileUtils.readFileToString("region_list"))
				.getJSONArray("region");
		JSONArray currencyList = new JSONArray();

		if ("0".equals(id)) {
			classList.clear();
			regionList.clear();
		} else if ("1".equals(id) || "4".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("7currency_list"))
					.getJSONArray("currency");
		} else if ("2".equals(id) || "5".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list"))
					.getJSONArray("currency");
		} else if ("3".equals(id) || "6".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("9currency_list"))
					.getJSONArray("currency");
		} else {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list"))
					.getJSONArray("currency");

			// fix for noTruncation
			// if("7".equals(id)) {
			// classList.getJSONObject(0).put("name", "Liquidity and Money");
			// classList.getJSONObject(0).getJSONArray("nodes").getJSONObject(0).put("name",
			// "Futures on Forex");
			// currencyList.getJSONObject(0).put("name", "Hong Kong Dollar");
			// regionList.getJSONObject(0).put("name", "Europe");
			// }

		}

		if (currency != null) {
			JsonFileUtils.replaceProperty(classList, "currency", currency.toUpperCase());
			for (int i = 0; i < classList.size(); i++) {
				JsonFileUtils.replaceProperty(classList.getJSONObject(i).getJSONArray("nodes"), "currency",
						currency.toUpperCase());
			}
			JsonFileUtils.replaceProperty(currencyList, "currency", currency.toUpperCase());
			JsonFileUtils.replaceProperty(regionList, "currency", currency.toUpperCase());
		}
		
		if(currencyList.size() > 8) {
			StringBuilder currencyId = new StringBuilder();
			double currencyAmount = 0;
			double currencyWeight = 0;
			String currencyName = "Other";
			for (int i = 7; i < currencyList.size(); i++) {
				currencyId.append(currencyList.getJSONObject(i).getString("id"));
				if(i != currencyList.size() - 1) {
					currencyId.append(",");
				}
				currencyAmount += currencyList.getJSONObject(i).getDouble("amount");
				currencyWeight += currencyList.getJSONObject(i).getDouble("weight");
			}
			JSONObject otherCurrency = new JSONObject();
			otherCurrency.put("id", currencyId.toString());
			otherCurrency.put("amount", currencyAmount);
			otherCurrency.put("name", currencyName);
			otherCurrency.put("currency", currency.toUpperCase());
			otherCurrency.put("weight", currencyWeight);
			
			currencyList = JsonFileUtils.getPageJsonArray(currencyList, 0, 7);
			currencyList.add(otherCurrency);
		}

		result.put("clazz", classList);
		result.put("currency", currencyList);
		result.put("region", regionList);

		if (category != null) {
			JSONArray nullList = new JSONArray();
			if (category.equalsIgnoreCase("ASSET")) {
				result.put("currency", nullList);
				result.put("region", nullList);
			} else if (category.equalsIgnoreCase("CURRENCY")) {
				result.put("clazz", nullList);
				result.put("region", nullList);
			} else if (category.equalsIgnoreCase("REGION")) {
				result.put("clazz", nullList);
				result.put("currency", nullList);
			}
		}
		JsonFileUtils.formatObjectNumber2DP(result);
		return new BaseAPIResponse<JSONObject>(result);
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

		JSONArray jsonArray = jsonObject.getJSONArray("currencies");
		Collections.sort(jsonArray, JsonCompare.getLetterOrderAsc("code"));

		if ("1".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		}

		jsonObject.put("currencies", jsonArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "userprofile", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> userprofile(HttpServletRequest request, HttpServletResponse response) {
//		Enumeration<String> headerNames = request.getHeaderNames();
//		System.out.println("request header: ");
//	    while (headerNames.hasMoreElements()) {
//	        String key = (String) headerNames.nextElement();
//	        System.out.println(key+":"+request.getHeader(key));
//	    }
		
		String id = request.getHeader("AMSESSION");
		if(id == null) {
			throw new BaseException("Required 'AMSESSION' is not present!");
		}
		
		response.addHeader("AMSESSION", id + "_AMSESSION");
		response.addHeader("LtpaToken2", id + "_LtpaToken2");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userName", "Jones");
//		if ("6".equals(id)) {
//			jsonObject.put("userName", "WwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
//		} 
		jsonObject.put("lastLoginTime", 1533882667);
		jsonObject.put("id", id);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{id}/holdings/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocationHoldingList(@PathVariable("id") String id, @RequestParam(required = true)String currency,
			@RequestParam(required = true) String category, @RequestParam(required = true) String categoryId,
			@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "15") Integer limit) {
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
		
		JSONObject jsonObject = new JSONObject();
		if(category.equalsIgnoreCase("CURRENCY") && categoryId.contains(",")) {
			String[] categoryIds = categoryId.split(",");
			double categoryAmount = 0;
			for (String cId : categoryIds) {
				JSONObject categoryObject = JsonFileUtils.getFilterObject(jsonArray, "id", cId);
				categoryAmount += categoryObject.getDouble("amount");
			}
			
			jsonObject.put("name", "Other");
			jsonObject.put("amount", categoryAmount);
		} else {
			jsonObject = JsonFileUtils.getFilterObject(jsonArray, "id", categoryId);
		}
		
		allocation.put("name", jsonObject.getString("name"));
		allocation.put("amount", jsonObject.getDouble("amount"));
		allocation.put("currency", currency.toUpperCase());
		resultJson.put("allocation", allocation);

		JSONArray holdingJson = JSONObject.fromObject(json).getJSONArray("holdings");
		JsonFileUtils.removeFilterObject(holdingJson, "id", new String[] { "11", "12" });
		resultJson.put("holdings", JsonFileUtils.getPageJsonArray(holdingJson, offset, limit));
		resultJson.put("totalSize", holdingJson.size());
		JsonFileUtils.formatObjectNumber2DP(resultJson, new String[] { "type", "totalSize" });
		return new BaseAPIResponse<JSONObject>(resultJson);
	}

}
