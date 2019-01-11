package org.gt.projects.gpb.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/mobile/v1")
public class PortfolioController extends BaseAPIController {

	@RequestMapping(value = "portfolio/overview", method = { RequestMethod.POST })
	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params, HttpServletRequest request) {
		printJsonParams(params);
		if (params.get("accountId") == null) {
			throw new BaseException();
		}
		String accountId = params.get("accountId").toString();
		List<String> ids = (List<String>) params.get("portfolioIds");
		String json = JsonFileUtils.readFileToString("account_portfolio_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("portfolios");
		JSONArray resultArray = JsonFileUtils.getIdsArray(jsonArray, ids);

		if (params.get("currency") != null) {
			for (int i = 0; i < resultArray.size(); i++) {
				resultArray.getJSONObject(i).put("currency", params.get("currency").toString().toUpperCase());
				resultArray.getJSONObject(i).put("liabilitiesCurrency",
						params.get("currency").toString().toUpperCase());
				resultArray.getJSONObject(i).put("netAssetsCurrency", params.get("currency").toString().toUpperCase());
				resultArray.getJSONObject(i).getJSONObject("ytd").put("currency",
						params.get("currency").toString().toUpperCase());
			}
		}

		JSONArray accounts = JSONObject.fromObject(JsonFileUtils.readFileToString("overview_account_list")).getJSONArray("accounts");
		String updateDate = JsonFileUtils.getFilterObject(accounts, "id", accountId).getString("updateDate");
		for (int i = 0; i < resultArray.size(); i++) {
			JSONObject portfolioObjcet = resultArray.getJSONObject(i);
			if (isAsia(request)) {
				// for ASIA
				if (portfolioObjcet.getString("mandateType").equals("Advisory")) {
					portfolioObjcet.put("name", "Advisory");
				}
				if(portfolioObjcet.getString("id").equals("0") || portfolioObjcet.getString("id").equals("15")) {
					portfolioObjcet.getJSONObject("ytd").put("weight", "");
				}
			} 
			resultArray.getJSONObject(i).remove("baseCurrency");
			resultArray.getJSONObject(i).remove("weight");
			resultArray.getJSONObject(i).remove("mandateType");
		
			resultArray.getJSONObject(i).put("updateDate", updateDate);
		}

		JSONObject jsonObject = new JSONObject();
		JsonFileUtils.formatArrayNumber2DP(resultArray);
		jsonObject.put("portfolios", resultArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "portfolio/{id}/holdings", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> holdings(@PathVariable("id") String id,
			@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "100") Integer limit,
			String currency) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("holdings");
		if ("0".equals(id) || "3".equals(id)) {
			jsonArray.clear();
		} 

		JsonCompare numCompare = JsonCompare.getNumberOrderDesc("reportAmount");
		Collections.sort(jsonArray, numCompare);

		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		JsonFileUtils.formatArrayNumber2DP(pageJson, "type");

		jsonObject.put("holdings", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		jsonObject.put("hasLiability", "Y");
		if ("0".equals(id) || "4".equals(id)) {
			jsonObject.put("hasLiability", "N");
		}
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "portfolio/{id}/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocation(@PathVariable("id") String id,
			// @RequestParam(defaultValue="0")Integer offset,
			// @RequestParam(defaultValue="15")Integer limit,
			@RequestParam(required = true) String currency, String category) {
		return CommonUtil.getAllocationData(id, currency, category);
	}

	// @RequestMapping(value = "portfolio/{id}/liabilities", method =
	// {RequestMethod.GET})
	// public BaseAPIResponse<JSONObject> liabilityDetail(@PathVariable("id") String
	// id,
	// @RequestParam(defaultValue="0")Integer offset,
	// @RequestParam(defaultValue="15")Integer limit,
	// String currency) {
	// String jsonName = "contingent_liabilities_list_USD";
	// String reportCurrency = "USD";
	// if ("2".equals(id) || "3".equals(id)) {
	// jsonName = "contingent_liabilities_list_GBP";
	// reportCurrency = "GBP";
	// }
	// String json = JsonFileUtils.readFileToString(jsonName);
	// JSONArray jsonArray =
	// JSONObject.fromObject(json).getJSONArray("liabilities");
	//
	// if ("1".equals(id)) {
	// jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 13);
	// } else if ("2".equals(id)) {
	// jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
	// } else if ("3".equals(id)) {
	// JSONObject oneItem = (JSONObject) jsonArray.get(0);
	// jsonArray = new JSONArray();
	// jsonArray.add(oneItem);
	// } else if (Integer.valueOf(id) > 15) {
	// // fix for noTruncation
	//// jsonArray.getJSONObject(0).put("description", "BRQ227M Caisse
	// d'Amortissement de la Dette Sociale");
	// }
	//
	// JSONObject commiment = new JSONObject();
	// commiment.put("currency", reportCurrency);
	//// if (currency != null) {
	//// for (int i = 0; i < jsonArray.size(); i++) {
	//// jsonArray.getJSONObject(i).put("baseCurrency", currency.toUpperCase());
	//// jsonArray.getJSONObject(i).put("remainingBaseCurrency",
	// currency.toUpperCase());
	//// }
	//// }
	//
	// JsonCompare numCompare =
	// JsonCompare.getNumberOrderDesc("remainingBaseAmount");
	// Collections.sort(jsonArray, numCompare);
	//
	// JSONObject jsonObject = new JSONObject();
	// JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset,
	// limit);
	//
	// for (int i = 0; i< pageJson.size(); i++) {
	// String valueDate =
	// GBMConstant.ALL_MONTH_FORMAT.format(pageJson.getJSONObject(i).getLong("valueDate")
	// * 1000);
	// pageJson.getJSONObject(i).put("valueDate", valueDate);
	// }
	//
	// jsonObject.put("liabilities", pageJson);
	// jsonObject.put("totalSize", jsonArray.size());
	//
	// double amount = 0;
	// for (int i = 0; i < jsonArray.size(); i++) {
	// amount += jsonArray.getJSONObject(i).getDouble("remainingReportAmount");
	// }
	// commiment.put("amount", amount);
	// jsonObject.put("commiment", commiment);
	// JsonFileUtils.formatObjectNumber2DP(jsonObject);
	// return new BaseAPIResponse<JSONObject>(jsonObject);
	// }

	@RequestMapping(value = "portfolio/{id}/transactions", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> transactions(@PathVariable("id") String id,
			@RequestParam(defaultValue = "all") String type, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit, String currency, HttpServletRequest request) {
		String json = JsonFileUtils.readFileToString("portfolio_transactions_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("transactions");
		if (id.equals("0")) {
			jsonArray.clear();
		} else if ("2".equals(id)) {
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 0, 13);
		} else if ("3".equals(id)) {
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 0, 5);
		} else if ("4".equals(id)) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "cash movements", 1);
		} else if ("5".equals(id)) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "purchases", 1);
		} else if ("6".equals(id)) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "sales", 1);
		} 

		// if (currency != null) {
		// for (int i = 0; i < jsonArray.size(); i++) {
		// jsonArray.getJSONObject(i).put("currency", currency.toUpperCase());
		// }
		// }

		if (!type.equalsIgnoreCase("all")) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", type);
		}

		JsonCompare transactionCompare = new JsonCompare(new String[] { "tradeDate", "type", "description" },
				new String[] { JsonCompare.NUMBER, JsonCompare.LETTER, JsonCompare.LETTER },
				new String[] { JsonCompare.DESC, JsonCompare.ASC, JsonCompare.ASC });
//		if(isAsia(request)) {
//			transactionCompare = new JsonCompare(new String[] { "tradeDate", "description" },
//					new String[] { JsonCompare.NUMBER, JsonCompare.LETTER },
//					new String[] { JsonCompare.DESC, JsonCompare.ASC });
//		}
		Collections.sort(jsonArray, transactionCompare);

		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);

		for (int i = 0; i < pageJson.size(); i++) {
			String tradeDate = GBMConstant.SIM_MONTH_FORMAT
					.format(pageJson.getJSONObject(i).getLong("tradeDate") * 1000);
			pageJson.getJSONObject(i).put("tradeDate", tradeDate);
			if (pageJson.getJSONObject(i).getLong("settlementDate") == 0) {
				pageJson.getJSONObject(i).put("settlementDate", "");
			} else {
				String settlementDate = GBMConstant.SIM_MONTH_FORMAT
						.format(pageJson.getJSONObject(i).getLong("settlementDate") * 1000);
				pageJson.getJSONObject(i).put("settlementDate", settlementDate);
			}
		}

		JsonFileUtils.formatArrayNumber2DP(pageJson, new String[] { "units" });
		jsonObject.put("transactions", pageJson);
		jsonObject.put("totalSize", jsonArray.size());
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "holdings/{id}/detail", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> holdingsDetail(@PathVariable("id") String id,
			String currency) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_detail_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("holdings");
		jsonArray = JsonFileUtils.getFilterArray(jsonArray, "id", id, 1);

		JSONObject jsonObject = new JSONObject();
		JsonFileUtils.formatArrayNumber2DP(jsonArray, "category", "number");
		jsonObject.put("holding", jsonArray.get(0));
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "portfolio/{id}/xrate", method = { RequestMethod.GET })
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

		jsonObject.getJSONObject("base").put("code", "JPY");
		JSONArray jsonArray = jsonObject.getJSONArray("currencies");
		jsonArray = JsonFileUtils.removeFilterObject(jsonArray, "code", "JPY");
		JSONObject gbpCurrency = new JSONObject();
		gbpCurrency.put("code", "GBP");
		gbpCurrency.put("rate", 1.3156);
		jsonArray.add(gbpCurrency);
		Collections.sort(jsonArray, JsonCompare.getLetterOrderAsc("code"));

		if ("1".equals(id)) {
			jsonArray = JsonFileUtils.getCommonPageJsonArray(jsonArray, 0, 5);
		}

		jsonObject.put("currencies", jsonArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "portfolio/{id}/holdings/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocationHoldingList(@RequestParam(required = true) String currency,
			@PathVariable("id") String id, @RequestParam(required = true) String category,
			@RequestParam(required = true) String categoryId, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit) {
		return CommonUtil.getAllocationHoldings(id, currency, category, categoryId, offset, limit);
	}

	@RequestMapping(value = "portfolio/{id}/liabilities", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> liabilities(@PathVariable("id") String id,
			@RequestParam(required = true) String currency) {
		String json = JsonFileUtils.readFileToString("portfolio_liabilities_list");
		JSONObject jsonObject = JSONObject.fromObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray("liabilities");

		if (id.equals("0")) {
			jsonArray.clear();
		} else if (id.equals("2")) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "liabilityType", "Call loan");
		} else if (id.equals("3")) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "liabilityType", "Fixed loan");
		}

		JsonFileUtils.replaceProperty(jsonArray, "baseCurrency", currency.toUpperCase());

		Collections.sort(jsonArray, JsonCompare.getNumberOrderAsc("baseAmount"));
		JsonFileUtils.formatArrayNumber2DP(jsonArray);
		jsonObject.put("liabilities", jsonArray);
		jsonObject.put("totalSize", jsonArray.size());
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "liabilities/{id}/detail", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> liabilitiesDetail(@PathVariable("id") String id,
			@RequestParam(required = true) String currency) {
		String json = JsonFileUtils.readFileToString("portfolio_liabilities_list");
		JSONArray liabilitiesList = JSONObject.fromObject(json).getJSONArray("liabilities");

		JSONObject liabilities = JsonFileUtils.getFilterObject(liabilitiesList, "liabilityId", id);
		JSONObject resultObject = new JSONObject();
		resultObject.put("description", liabilities.get("liabilities"));
		resultObject.put("type", liabilities.get("liabilityType"));
		resultObject.put("principalAmount", -11000);
		resultObject.put("principalCurrency", liabilities.get("currency"));
		resultObject.put("accruedInterestAmount", -500);
		resultObject.put("accruedInterestCurrency", liabilities.get("currency"));
		resultObject.put("totalAmount", liabilities.get("amount"));
		resultObject.put("totalCurrency", liabilities.get("currency"));
		resultObject.put("totalBaseAmount", liabilities.get("baseAmount"));
		resultObject.put("totalBaseCurrency", currency.toUpperCase());

		JsonFileUtils.formatObjectNumber2DP(resultObject);
		return new BaseAPIResponse<JSONObject>(resultObject);
	}
	
	@RequestMapping("portfolio/{id}/holdings/allocation/group")
	public BaseAPIResponse<JSONObject> holdingAllocationGroup(@PathVariable String id,
			@RequestParam(required = true) String currency, @RequestParam(required = true) String category,
			@RequestParam(required = true) String categoryId, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit){
		return CommonUtil.getAllocationHoldingGroup(id, currency, category, categoryId, offset, limit);
	}

}
