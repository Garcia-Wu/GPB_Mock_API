package org.gt.projects.gpb.controller;

import java.io.File;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.gt.projects.gpb.base.BaseAPIController;
import org.gt.projects.gpb.base.BaseAPIResponse;
import org.gt.projects.gpb.base.BaseException;
import org.gt.projects.gpb.base.comparable.JsonCompare;
import org.gt.projects.gpb.utils.CommonUtil;
import org.gt.projects.gpb.utils.GBMConstant;
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
@RequestMapping("/mobile/v1/customer")
public class OverviewController extends BaseAPIController {

	@RequestMapping(value = "{id}/overview", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> overview(@PathVariable("id") String id,
			@RequestParam(required = true) String currency, HttpServletRequest request) throws ParseException {
		if (Integer.valueOf(id) > 7) {
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
			jsonObject.getJSONObject("customer").put("liabilitiesAmount", -0.001);
			jsonObject.getJSONObject("customer").put("netAssetsAmount", 38950392011.999);
			jsonObject.getJSONObject("ytd").put("amount", -38950392012D);
		} else if (id.equals("3")) {
			jsonObject.getJSONObject("customer").put("liabilitiesAmount", -38950392012D);
			jsonObject.getJSONObject("customer").put("netAssetsAmount", 0);
		} else if (id.equals("4")) {
			jsonObject.put("hasLiabilities", false);
//			jsonObject.getJSONObject("customer").put("liabilitiesAmount", 1);
			jsonObject.getJSONObject("customer").put("netAssetsAmount", 0);
		} else if (id.equals("5")) {
			jsonObject.getJSONObject("customer").put("liabilitiesAmount", -48086438537.35);
			jsonObject.getJSONObject("customer").put("netAssetsAmount", -9136046525.35);
		} else if (id.equals("6")) {
			jsonObject.getJSONObject("customer").put("name","Jones WwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		} else if(id.equals("7")) {
			jsonObject.getJSONObject("ytd").put("amount", 0);
			jsonObject.getJSONObject("ytd").put("currency", "");
		}
		if (currency != null) {
			jsonObject.getJSONObject("customer").put("currency", currency.toUpperCase());
			jsonObject.getJSONObject("customer").put("liabilitiesCurrency", currency.toUpperCase());
			jsonObject.getJSONObject("customer").put("netAssetsCurrency", currency.toUpperCase());
			if(StringUtils.isNotBlank(jsonObject.getJSONObject("ytd").getString("currency"))) {
				jsonObject.getJSONObject("ytd").put("currency", currency.toUpperCase());
			}
		}

		if (isUK(request)) {
			jsonObject.getJSONObject("customer").put("bookingCenter", "UK Accounts");
		} else if (isHK(request)) {
			jsonObject.getJSONObject("customer").put("bookingCenter", "HK Accounts");
		} else {
			jsonObject.getJSONObject("customer").put("bookingCenter", "SG Accounts");
		}
		
		// update time
//		BaseAPIResponse<JSONObject> accountsResponse = this.accounts(id, 0, 1000, currency, true, request);
//		JSONArray accounts = accountsResponse.getData().getJSONArray("accounts");
//		String updateDate = "";
//		for(Object account : accounts) {
//			String accountUpdateDate = ((JSONObject)account).getString("updateDate");
//			if(accountUpdateDate.equals("")) {
//				// account list其中有一个没有更新时间，则更新时间为空
//				updateDate = "";
//				break;
//			} else {
//				// 获取最小的更新时间
//				Date accountDate = GBMConstant.SIM_MONTH_FORMAT.parse(accountUpdateDate);
//				if(updateDate.equals("")) {
//					updateDate = GBMConstant.SIM_MONTH_FORMAT.format(accountDate);
//				} else {
//					Date lastDate = GBMConstant.SIM_MONTH_FORMAT.parse(updateDate);
//					if(accountDate.getTime() < lastDate.getTime()) {
//						updateDate = GBMConstant.SIM_MONTH_FORMAT.format(accountDate);
//					}
//				}
//			}
//		}
//		// 设置更新时间
//		jsonObject.getJSONObject("customer").put("updateDate", updateDate);
//		if(id.equals("3")) {
//			jsonObject.getJSONObject("customer").put("updateDate", "01 Dec 2018");
//		} else if(id.equals("4")){
//			jsonObject.getJSONObject("customer").put("updateDate", "");
//		}

		JsonFileUtils.formatObjectNumber2DP(jsonObject, "newDocumentCount");
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{id}/accounts", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> accounts(@PathVariable("id") String id,
			@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "15") Integer limit,
			@RequestParam(required = true) String currency, @RequestParam(required = false, defaultValue = "false")boolean hasUpdateDate, HttpServletRequest request) {

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
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 3, 2);
		} else if ("3".equals(id)) {
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 0, 13);
		} else if ("4".equals(id)) {
			// 获取对应portfolioNum为1的account
			JSONObject oneItem = JsonFileUtils.getFilterObject(jsonArray, "id", "3");
			JSONObject item = JsonFileUtils.getFilterObject(jsonArray, "id", "4");
			jsonArray = new JSONArray();
			jsonArray.add(oneItem);
			jsonArray.add(item);
		} else if ("7".equals(id)) {
			// For timeout
//			JSONObject account = JsonFileUtils.getFilterObject(jsonArray, "id", "0");
//			account.put("id", "16");
//			account.put("name", "B5ED76G ***");
//			account.put("externalId", "B5ED76G");
//			jsonArray.add(account);
		}

		if (currency != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.getJSONObject(i).put("currency", currency.toUpperCase());
			}
		}

		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);

		// for ASIA
		if (isAsia(request)) {
			for (int i = 0; i < pageJson.size(); i++) {
				pageJson.getJSONObject(i).put("weight", "");
			}
		}

		for (int i = 0; i < pageJson.size(); i++) {
			pageJson.getJSONObject(i).remove("ytd");
			if(!hasUpdateDate) {
				pageJson.getJSONObject(i).remove("updateDate");
			}
			pageJson.getJSONObject(i).remove("liabilitiesAmount");
			pageJson.getJSONObject(i).remove("liabilitiesCurrency");
			pageJson.getJSONObject(i).remove("netAssetsAmount");
			pageJson.getJSONObject(i).remove("netAssetsCurrency");
		}

		JsonFileUtils.formatArrayNumber2DP(pageJson);
		Collections.sort(pageJson, JsonCompare.getNumberDescThenLetterAsc("amount", "name"));
		jsonObject.put("accounts", pageJson);
		jsonObject.put("totalSize", jsonArray.size());

		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{id}/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocation(@PathVariable("id") String id,
			// @RequestParam(defaultValue="0")Integer offset,
			// @RequestParam(defaultValue="15")Integer limit,
			@RequestParam(required = true) String currency, String category) {
		return CommonUtil.getAllocationData(id, currency, category);
	}
	
	@RequestMapping(value = "{id}/xrate", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> currency(@PathVariable("id") String id, HttpServletRequest request) {

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

		JSONArray jsonArray;
		jsonArray = jsonObject.getJSONArray("currencies");
		if (isAsia(request)) {
			jsonObject.getJSONObject("base").put("code", "USD");
			jsonArray = JsonFileUtils.removeFilterObject(jsonArray, "code", "USD");
			JSONObject gbpCurrency = new JSONObject();
			gbpCurrency.put("code", "GBP");
			gbpCurrency.put("rate", 1.3156);
			jsonArray.add(gbpCurrency);
		}

		Collections.sort(jsonArray, JsonCompare.getLetterOrderAsc("code"));

		if ("1".equals(id)) {
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 0, 5);
		}

		jsonObject.put("currencies", jsonArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "userprofile", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> userprofile(HttpServletRequest request, HttpServletResponse response) {
		 Enumeration<String> headerNames = request.getHeaderNames();
		 System.out.println("request header: ");
		 while (headerNames.hasMoreElements()) {
		 String key = (String) headerNames.nextElement();
		 System.out.println(key+":"+request.getHeader(key));
		 }

		String id = request.getHeader("AMSESSION");
		if (id == null) {
			throw new BaseException("Required 'AMSESSION' is not present!");
		} else {
			System.out.println("AMSESSION:" + id);
		}
		System.out.println("region:" + request.getHeader("region"));

		// for SIT test
		if(!id.endsWith("_UK") && !id.endsWith("_HK") && !id.endsWith("_SG")) {
			id = id.substring(id.length() - 1);
			if(id.equals("9")) {
				id = "5";
			}
			if(Integer.valueOf(id) < 0 || Integer.valueOf(id) > 7) {
				throw new BaseException("Id is not expected!");
			}
		}
		
		if(request.getHeader("Region") != null) {
			id += "_" + request.getHeader("Region");
		}

		response.addHeader("AMSESSION", "AMSESSION_" + id.toUpperCase());
		response.addHeader("LtpaToken2", "LtpaToken2_" + id.toUpperCase());

		if (id.indexOf("_") != -1) {
			id = id.substring(0, id.indexOf("_"));
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lastLoginTime", 1533882667);
		jsonObject.put("id", id);
		if ("0".equals(id)) {
			jsonObject.put("lastLoginTime", 0);
			jsonObject.put("userName", "");
		} else if ("2".equals(id)) {
			jsonObject.put("userName", "Mr Chen");
		} else if ("6".equals(id)) {
			jsonObject.put("userName", "Jones WwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		} else {
			jsonObject.put("userName", "Jones");
		}
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{id}/holdings/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocationHoldingList(@PathVariable("id") String id,
			@RequestParam(required = true) String currency, @RequestParam(required = true) String category,
			@RequestParam(required = true) String categoryId, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit) {
		return CommonUtil.getAllocationHoldings(id, currency, category, categoryId, offset, limit);
	}

	@RequestMapping(value = "{customerId}/documents", method = { RequestMethod.POST })
	public BaseAPIResponse<JSONObject> document(@PathVariable("customerId") String customerId,
			@RequestBody Map<String, Object> params, HttpServletRequest request) {
		printJsonParams(params);
		
		String fileName = "documents" + File.separator + "document_";
		if(isUK(request)) {
			fileName = fileName + "uk";
		} else if (isHK(request)) {
			fileName = fileName + "hk";
		} else if (isSG(request)){
			fileName = fileName + "sg";
		}
		JSONObject jsonObject = JSONObject
				.fromObject(JsonFileUtils.readFileToString(fileName + File.separator + "document_" + customerId));
		JSONArray documentsGroup = jsonObject.getJSONArray("documentsGroup");

		List<String> accountIds = (List<String>) params.get("accountIds");
		List<String> categories = (List<String>) params.get("categories");
		// 去除accountId以及categories的document
		documentsGroup = getExcludeDocument(documentsGroup, accountIds, categories);

		int allDocumentsSize = 0;
		int unReadNum = 0;
		int flaggedNum = 0;
		for (int i = 0; i < documentsGroup.size(); i++) {
			allDocumentsSize += documentsGroup.getJSONObject(i).getJSONArray("documents").size();
			JSONArray documents = documentsGroup.getJSONObject(i).getJSONArray("documents");
			for (int j = 0; j < documents.size(); j++) {
				if (!documents.getJSONObject(j).getBoolean("isRead")) {
					unReadNum++;
				}
				if (documents.getJSONObject(j).getBoolean("isFlag")) {
					flaggedNum++;
				}
			}
		}
		
		jsonObject.put("totalSize", allDocumentsSize);
//		if(customerId.equals("4")) {
//			unReadNum = unReadNum + 9997;
//			flaggedNum = flaggedNum + 9997;
//		}
		
		jsonObject.put("unreadNum", unReadNum);
		jsonObject.put("flaggedNum", flaggedNum);

		String docType = params.get("docType").toString();
		// 筛选document type
		getDocTypeDocument(documentsGroup, docType);

		return new BaseAPIResponse<>(jsonObject);
	}
	
	private JSONArray getExcludeDocument(JSONArray documentsGroup, List<String> accountIds, List<String> categories) {
		JSONArray removeArray = new JSONArray();
		for (int i = 0; i < documentsGroup.size(); i++) {
			JSONArray documents = documentsGroup.getJSONObject(i).getJSONArray("documents");
			
			JSONArray removeDocuments = new JSONArray();
			for (int j = 0; j < documents.size(); j++) {
				for (String accountId : accountIds) {
					if(accountId.equals(documents.getJSONObject(j).getString("accountId"))) {
						removeDocuments.add(documents.getJSONObject(j));
					}
				}
				for (String category : categories) {
					if(documents.getJSONObject(j).getString("category").equals(category)) {
						removeDocuments.add(documents.getJSONObject(j));
					}
				}
			}
			
			documents.removeAll(removeDocuments);
			if (documents.size() == 0) {
				removeArray.add(documentsGroup.getJSONObject(i));
			} 
		}
		documentsGroup.removeAll(removeArray);
		return documentsGroup;
	}

	public void getDocTypeDocument(JSONArray documentsGroup, String docType) {
		JSONArray removeArray = new JSONArray();
		Boolean resultMatch = false;
		String key = "isRead";
		if (docType.equalsIgnoreCase("UNREAD") || docType.equalsIgnoreCase("FLAGGED")) {
			if (docType.equalsIgnoreCase("FLAGGED")) {
				resultMatch = true;
				key = "isFlag";
			}
		} else {
			return;
		}
		for (int i = 0; i < documentsGroup.size(); i++) {
			JSONArray documents = documentsGroup.getJSONObject(i).getJSONArray("documents");
			JSONArray resultDocuments = new JSONArray();
			for (int j = 0; j < documents.size(); j++) {
				if (documents.getJSONObject(j).getBoolean(key) == resultMatch) {
					resultDocuments.add(documents.getJSONObject(j));
				}
			}
			if (resultDocuments.size() == 0) {
				removeArray.add(documentsGroup.getJSONObject(i));
			} else {
				documentsGroup.getJSONObject(i).put("documents", resultDocuments);
			}
		}
		documentsGroup.removeAll(removeArray);
	}

	@RequestMapping(value = "{customerId}/documents/accounts", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> documentAccounts(@PathVariable("customerId") String customerId, HttpServletRequest request) {
		String fileName = "documents/accounts_";
		if(isUK(request)) {
			fileName = fileName + "uk";
		} else if (isAsia(request)) {
			fileName = fileName + "asia";
		}
		JSONObject jsonObject = JSONObject.fromObject(JsonFileUtils.readFileToString(fileName + "/accounts_"+customerId));
		JSONArray accountList = jsonObject.getJSONArray("accounts");
		Collections.sort(accountList, JsonCompare.getLetterOrderAsc("name"));
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{customerId}/documents/categories", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> documentCategories(@PathVariable("customerId") String customerId) {
		JSONObject jsonObject = JSONObject.fromObject(JsonFileUtils.readFileToString("documents/categories"));
		JsonCompare letterCompare = JsonCompare.getLetterOrderAsc("name");
		for (Object category : jsonObject.getJSONArray("categories")) {
			Collections.sort(((JSONObject)category).getJSONArray("subCategories"), letterCompare);
		}
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "{customerId}/documents/flag", method = { RequestMethod.POST })
	public BaseAPIResponse<JSONObject> documentFlag(@PathVariable("customerId") String customerId,
			@RequestBody Map<String, Object> params, HttpServletRequest request) {
		printJsonParams(params);
		String documentId = params.get("documentId").toString();
		boolean status = Boolean.valueOf(params.get("status").toString());
		boolean isFind = false;

		String fileName = "documents" + File.separator + "document_";
		if(isUK(request)) {
			fileName = fileName + "uk";
		} else if (isHK(request)) {
			fileName = fileName + "hk";
		} else {
			fileName = fileName + "sg";
		}
		fileName = fileName + File.separator + "document_" + customerId;
			
		JSONObject jsonObject = JSONObject.fromObject(JsonFileUtils.readFileToString(fileName));
		JSONArray documentsGroup = jsonObject.getJSONArray("documentsGroup");
		documentsGroupFor: for (int i = 0; i < documentsGroup.size(); i++) {
			JSONArray documents = documentsGroup.getJSONObject(i).getJSONArray("documents");
			for (int j = 0; j < documents.size(); j++) {
				if (documents.getJSONObject(j).getString("id").equals(documentId)) {
					documents.getJSONObject(j).put("isFlag", status);
					isFind = true;
					break documentsGroupFor;
				}
			}
		}

		if (!isFind) {
			throw new BaseException("The document corresponding to this ID does not exist!");
		} else {
			// 将修改后的json覆盖原json文件
			JsonFileUtils.writeJsonFile(jsonObject, fileName);
		}
		return new BaseAPIResponse<>();
	}
	
	@RequestMapping("{id}/holdings/allocation/group")
	public BaseAPIResponse<JSONObject> holdingAllocationGroup(@PathVariable String id,
			@RequestParam(required = true) String currency, @RequestParam(required = true) String category,
			@RequestParam(required = true) String categoryId, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit){
		return CommonUtil.getAllocationHoldingGroup(id, currency, category, categoryId, offset, limit);
	}

}
