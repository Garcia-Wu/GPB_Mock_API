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
		if(id.equals("5") || id.equals("6")) {
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
		if(params.get("page") != null) {
			page = (int) params.get("page");
		}
		if(params.get("pageSize") != null) {
			pageSize = (int) params.get("pageSize");
		}
		
		JSONObject jsonObject = new JSONObject();	
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, page, pageSize);
		jsonObject.put("accounts", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

//	@RequestMapping(value = "/{id}/accounts", method = { RequestMethod.GET })
//	public BaseAPIResponse<JSONObject> accounts(@PathVariable("id") int id, String currency,
//			@RequestParam(defaultValue = "15") Integer pageSize, @RequestParam(defaultValue = "0") Integer page) {
//		String json = JsonFileUtils.readFileToString("overview_account_list");
//		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("accounts");
//		if (id == 0) {
//			jsonArray.clear();
//		} else if (id > 0 && id < 4) {
//			JSONObject oneItem = (JSONObject) jsonArray.get(0);
//			jsonArray = new JSONArray();
//			jsonArray.add(oneItem);
//		}
//		if (StringUtils.isNotBlank(currency)) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				((JSONObject) jsonArray.get(i)).put("currency", currency);
//			}
//		}
//		JSONObject jsonObject = new JSONObject();
//
//		JSONArray pageJson = JsonFileUtils.getSubJsonArray(jsonArray, page, pageSize);
//		jsonObject.put("accounts", pageJson);
//		jsonObject.put("totalSize", jsonArray.size());
//		return new BaseAPIResponse<JSONObject>(jsonObject);
//	}
	
	@RequestMapping(value = "/allocation", method = { RequestMethod.POST })
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
		if (params.get("currency") != null) {
			json = json.replaceAll("GBP", params.get("currency").toString());
		}
		
		if (params.get("category") != null) {
			String category = params.get("category").toString();
			String jsonField = "";
			if (category.equalsIgnoreCase("ASSET")) {
				jsonField = "clazz";
			} else if (category.equalsIgnoreCase("CURRENCY")) {
				jsonField = "currency";
			} else if (category.equalsIgnoreCase("REGION")) {
				jsonField = "region";
			}
			if (!jsonField.equals("")) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put(jsonField, JSONObject.fromObject(json).get(jsonField));
				json = jsonObject.toString();
			}
		}
		return new BaseAPIResponse<JSONObject>(json);
	}

//	@RequestMapping(value = "/{id}/allocation", method = { RequestMethod.GET })
//	public BaseAPIResponse<JSONObject> allocation(@PathVariable int id, String currency, String category) {
//		String fileName = "";
//		switch (id) {
//		case 0:
//			fileName = "allocation_noData";
//			break;
//		case 1:
//			fileName = "breakDown_hasSubClass_7currency";
//			break;
//		case 2:
//			fileName = "breakDown_noSubClass_8currency";
//			break;
//		case 3:
//			fileName = "breakDown_hasSubClass_9currency";
//			break;
//		case 4:
//			fileName = "breakDown_noSubClass_7currency";
//			break;
//		case 5:
//			fileName = "breakDown_hasSubClass_8currency";
//			break;
//		case 6:
//			fileName = "breakDown_noSubClass_9currency";
//			break;
//
//		default:
//			fileName = "breakDownDefault";
//			break;
//		}
//		String json = JsonFileUtils.readFileToString(fileName);
//		if (StringUtils.isNotBlank(currency)) {
//			json = json.replaceAll("GBP", currency);
//		}
//		if (StringUtils.isNotBlank(category)) {
//			String jsonField = "";
//			if (category.equals("ASSET")) {
//				jsonField = "clazz";
//			} else if (category.equals("CURRENCY")) {
//				jsonField = "currency";
//			} else if (category.equals("REGION")) {
//				jsonField = "region";
//			}
//			if (!jsonField.equals("")) {
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put(jsonField, JSONObject.fromObject(json).get(jsonField));
//				json = jsonObject.toString();
//			}
//		}
//		return new BaseAPIResponse<JSONObject>(json);
//	}

}
