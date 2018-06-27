package org.gt.projects.gbm.controller;

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
@RequestMapping("/api/customer")
public class OverviewController extends BaseAPIController {

	@RequestMapping(value = "/overview", method = { RequestMethod.POST })
	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params) {
		printParams(params);
		JSONObject jsonObject = JSONObject.fromObject(JsonFileUtils.readFileToString("overview"));
		String id = params.get("id").toString();
		jsonObject.getJSONObject("customer").put("id", id);
		if (id.equals("5") || id.equals("6")) {
			jsonObject.getJSONObject("asset").put("amount", 13560001.01);
		}
		if (params.get("currency") != null) {
			jsonObject.getJSONObject("asset").put("currency", params.get("currency"));
		}
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "/accounts", method = { RequestMethod.POST })
	public BaseAPIResponse<JSONObject> accounts(@RequestBody Map<String, Object> params) {
		printParams(params);
		String json = JsonFileUtils.readFileToString("overview_account_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("accounts");
		
		String id = params.get("id").toString();
		if ("0".equals(id)) {
			jsonArray.clear();
		} else if ("1".equals(id)) {
			JSONObject oneItem = (JSONObject) jsonArray.get(0);
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		} else if ("2".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		} else if ("3".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 13);
		} else if ("4".equals(id)) {
			// 获取对应portfolioNum为1的account
			JSONObject oneItem = (JSONObject) jsonArray.get(2);
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
		}
		if (params.get("currency") != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("currency", params.get("currency"));
			}
		}

		int page = 0;
		int pageSize = 15;
		if (params.get("page") != null) {
			page = (int) params.get("page");
		}
		if (params.get("pageSize") != null) {
			pageSize = (int) params.get("pageSize");
		}

		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, page, pageSize);
		jsonObject.put("accounts", pageJson);
		jsonObject.put("totalSize", jsonArray.size());

		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "/allocation", method = { RequestMethod.POST })
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
		} else if ("1".equals(id) || "4".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("7currency_list")).getJSONArray("currency");
		} else if ("2".equals(id) || "5".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
		} else if ("3".equals(id) || "6".equals(id)) {
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

	// @RequestMapping(value = "/allocation", method = { RequestMethod.POST })
	// public BaseAPIResponse<JSONObject> allocation(@RequestBody Map<String,
	// Object> params) {
	// printParams(params);
	// String fileName = "";
	// String id = params.get("id").toString();
	// if("0".equals(id)) {
	// fileName = "allocation_noData";
	// } else if ("1".equals(id) || "4".equals(id)) {
	// fileName = "breakDown_hasSubClass_7currency";
	// } else if ("2".equals(id) || "5".equals(id)) {
	// fileName = "breakDown_hasSubClass_8currency";
	// } else if ("3".equals(id) || "6".equals(id)) {
	// fileName = "breakDown_hasSubClass_9currency";
	// } else {
	// fileName = "breakDownDefault";
	// }
	//
	// String json = JsonFileUtils.readFileToString(fileName);
	// if (params.get("currency") != null) {
	// json = json.replaceAll("GBP", params.get("currency").toString());
	// }
	//
	// if (params.get("category") != null) {
	// String category = params.get("category").toString();
	// String jsonField = "";
	// if (category.equalsIgnoreCase("ASSET")) {
	// jsonField = "clazz";
	// } else if (category.equalsIgnoreCase("CURRENCY")) {
	// jsonField = "currency";
	// } else if (category.equalsIgnoreCase("REGION")) {
	// jsonField = "region";
	// }
	// if (!jsonField.equals("")) {
	// JSONObject jsonObject = new JSONObject();
	// jsonObject.put(jsonField, JSONObject.fromObject(json).get(jsonField));
	// json = jsonObject.toString();
	// }
	// }
	// return new BaseAPIResponse<JSONObject>(json);
	// }

}
