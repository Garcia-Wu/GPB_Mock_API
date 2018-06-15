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
@RequestMapping("/api/account")
public class AccountController extends BaseAPIController{

//	@RequestMapping(value = "/overview", method = {RequestMethod.POST})
//	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params) {
//		String fileName = "";
//		String id = params.get("id").toString();
//		if ("0".equals(id)) {
//			fileName = "account_portfoliolist_noData";
//		} else {
//			fileName = "account_portfoliolist";
//		}
//		String json = JsonFileUtils.readFileToString(fileName);
//		if(params.get("currency") != null) {
//			json = json.replaceAll("GBP", params.get("currency").toString());
//		}
//		return new BaseAPIResponse<JSONObject>(json);
//	}
	
	@RequestMapping(value = "/overview", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params) {
		printParams(params);
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
	
	@RequestMapping(value = "/portfolios", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> portfolios(@RequestBody Map<String, Object> params) {
		printParams(params);
		String json = JsonFileUtils.readFileToString("account_portfolio_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("portfolios");
		String id = params.get("id").toString();
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
		jsonObject.put("portfolios", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "/allocation", method = {RequestMethod.POST})
	public BaseAPIResponse<JSONObject> allocation(@RequestBody Map<String, Object> params) {
		printParams(params);
		String fileName = "";
		String id = params.get("id").toString();
		if("0".equals(id)) {
			fileName = "allocation_noData";
		} else if ("1".equals(id) || "4".equals(id)) {
			fileName = "breakDown_hasSubClass_7currency";
		} else if ("2".equals(id) || "5".equals(id)) {
			fileName = "breakDown_hasSubClass_8currency";
		} else if ("3".equals(id) || "6".equals(id)) {
			fileName = "breakDown_hasSubClass_9currency";
		} else {
			fileName = "breakDownDefault";
		}
		String json = JsonFileUtils.readFileToString(fileName);
		if(params.get("currency") != null) {
			json = json.replaceAll("GBP", params.get("currency").toString());
		} 
		if(params.get("category") != null) {
			String category = params.get("category").toString();
			String jsonField = "";
			if(category.equalsIgnoreCase("ASSET")) {
				jsonField = "clazz";
			}else if(category.equalsIgnoreCase("CURRENCY")) {
				jsonField = "currency";
			}else if(category.equalsIgnoreCase("REGION")) {
				jsonField = "region";
			}
			if(!jsonField.equals("")) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put(jsonField, JSONObject.fromObject(json).get(jsonField));
				json = jsonObject.toString();
			}
		}
		return new BaseAPIResponse<JSONObject>(json);
	}

}
