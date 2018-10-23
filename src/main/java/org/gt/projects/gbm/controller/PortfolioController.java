package org.gt.projects.gbm.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.gt.projects.gbm.base.BaseAPIController;
import org.gt.projects.gbm.base.BaseAPIResponse;
import org.gt.projects.gbm.base.BaseException;
import org.gt.projects.gbm.base.comparable.JsonCompare;
import org.gt.projects.gbm.utils.GBMConstant;
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
public class PortfolioController extends BaseAPIController {

	@RequestMapping(value = "portfolio/overview", method = { RequestMethod.POST })
	public BaseAPIResponse<JSONObject> overview(@RequestBody Map<String, Object> params, HttpServletRequest request) {
		printJsonParams(params);
		if (params.get("accountId") == null) {
			throw new BaseException();
		}
		List<String> ids = (List<String>) params.get("portfolioIds");
		String json = JsonFileUtils.readFileToString("account_portfolio_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("portfolios");
		JSONArray resultArray = JsonFileUtils.getIdsArray(jsonArray, ids);

		// fix for noTruncation
		// if(Integer.valueOf(ids.get(0)) > 15) {
		// for (int i = 0; i < ids.size(); i++) {
		// if(!ids.get(i).equals("0")) {
		// ids.set(i, String.valueOf(Integer.valueOf(ids.get(i)) - 15));
		// }
		// }
		// resultArray = JsonFileUtils.getIdsArray(jsonArray, ids);
		// if(resultArray.getJSONObject(0).getInt("id") == 1) {
		// resultArray.getJSONObject(0).put("name", "FX Portfolio 1");
		// }
		// }

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
			resultArray.getJSONObject(i).remove("weight");
			resultArray.getJSONObject(i).remove("mandateType");
			resultArray.getJSONObject(i).put("updateDate", "24 May 2018");
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
		} else if (Integer.valueOf(id) > 15) {
			// fix for noTruncation
			// jsonArray.getJSONObject(0).put("name", "SNE 0.001USD Sony Corp ADR Each Rep 1
			// Ord NPV (CDI)LUHSony Corp ADR Each Rep 1");
		}

		// if(currency != null) {
		// for (int i = 0; i < jsonArray.size(); i++) {
		// jsonArray.getJSONObject(i).put("currency", currency.toUpperCase());
		// }
		// }

		JsonCompare numCompare = JsonCompare.getNumberOrderDesc("reportAmount");
		Collections.sort(jsonArray, numCompare);

		JSONObject jsonObject = new JSONObject();
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		JsonFileUtils.formatArrayNumber2DP(pageJson, new String[] { "type" });

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
		JSONObject result = new JSONObject();
		JSONArray classList = JSONObject.fromObject(JsonFileUtils.readFileToString("hasSubClass_list"))
				.getJSONArray("clazz");
		JSONArray regionList = JSONObject.fromObject(JsonFileUtils.readFileToString("region_list")).getJSONArray("region");
		JSONArray currencyList = new JSONArray();

		if ("0".equals(id)) {
			classList.clear();
			regionList.clear();
		} else if ("1".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("7currency_list"))
					.getJSONArray("currency");
		} else if ("2".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list"))
					.getJSONArray("currency");
		} else if ("3".equals(id)) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("9currency_list"))
					.getJSONArray("currency");
		} else if ("4".equals(id)) {
			classList.clear();
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("7currency_list"))
					.getJSONArray("currency");
		} else if ("5".equals(id)) {
			// currencyList =
			// JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list")).getJSONArray("currency");
		} else if ("6".equals(id)) {
			regionList.clear();
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("9currency_list"))
					.getJSONArray("currency");
//		} else if ("15".equals(id)) {
//			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list"))
//					.getJSONArray("currency");
//			classList.getJSONObject(0).put("name", "Liquidity and Money");
//			classList.getJSONObject(0).getJSONArray("nodes").getJSONObject(0).put("name", "Futures on Forex");
//			currencyList.getJSONObject(0).put("name", "Hong Kong Dollar");
//			regionList.getJSONObject(0).put("name", "Europe");
		} else {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("8currency_list"))
					.getJSONArray("currency");

			// fix for noTruncation
			// if (Integer.valueOf(id) > 15) {
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

		if (currencyList.size() > 8) {
			StringBuilder currencyId = new StringBuilder();
			double currencyAmount = 0;
			double currencyWeight = 0;
			String currencyName = "Other";
			for (int i = 7; i < currencyList.size(); i++) {
				currencyId.append(currencyList.getJSONObject(i).getString("id"));
				if (i != currencyList.size() - 1) {
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
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 13);
		} else if ("3".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		} else if ("4".equals(id)) {
			// JSONObject oneItem = (JSONObject) jsonArray.get(0);
			// jsonArray = new JSONArray();
			// jsonArray.add(oneItem);
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "cash movements", 1);
		} else if ("5".equals(id)) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "purchases", 1);
		} else if ("6".equals(id)) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", "sales", 1);
		} else if (Integer.valueOf(id) > 15) {
			// fix for noTruncation
			// jsonArray.getJSONObject(0).put("type", "Cash movements1 GBP");
			// jsonArray.getJSONObject(0).put("description", "Transaction Description: This
			// is the Cash movements description, please see the description of the Cash
			// movements 1 item");
			// jsonArray.getJSONObject(1).put("type", "Purchases1 USD");
			// jsonArray.getJSONObject(1).put("description", "Transaction Description: This
			// is the purchase description, please see the description of the purchase 1
			// item");
			// jsonArray.getJSONObject(2).put("type", "Sales1 JPY");
			// jsonArray.getJSONObject(2).put("description", "Transaction Description: This
			// is the sales description, please see the description of the sales 1 item");
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
		if(isAsia(request)) {
			transactionCompare = new JsonCompare(new String[] { "tradeDate", "description" },
					new String[] { JsonCompare.NUMBER, JsonCompare.LETTER },
					new String[] { JsonCompare.DESC, JsonCompare.ASC });
		}
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

	@RequestMapping(value = "holdings/detail", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> holdingsDetail(@RequestParam(required = true) String holdingid,
			String currency) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_detail_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("holdings");
		jsonArray = JsonFileUtils.getFilterArray(jsonArray, "id", holdingid, 1);

		// fix for noTruncation
		// if(Integer.valueOf(id) > 15 && Integer.valueOf(holdingid) == 1) {
		// jsonArray.getJSONObject(0).put("name", "TESLA, INC.");
		// }

		JSONObject jsonObject = new JSONObject();
		JsonFileUtils.formatArrayNumber2DP(jsonArray, new String[] { "category", "number" });
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
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		}

		jsonObject.put("currencies", jsonArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}

	@RequestMapping(value = "portfolio/{id}/holdings/allocation", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> allocationHoldingList(@RequestParam(required = true) String currency,
			@PathVariable("id") String id, @RequestParam(required = true) String category,
			@RequestParam(required = true) String categoryId, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_list");
		JSONObject resultJson = new JSONObject();
		JSONObject allocation = new JSONObject();

		JSONArray jsonArray = null;
		if (category.equalsIgnoreCase("ASSET")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allClass_list")).getJSONArray("clazz");
		} else if (category.equalsIgnoreCase("CURRENCY")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allCurrency_list"))
					.getJSONArray("currency");
		} else if (category.equalsIgnoreCase("REGION")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("region_list")).getJSONArray("region");
		} else {
			throw new BaseException();
		}

		JSONObject jsonObject = new JSONObject();
		if (category.equalsIgnoreCase("CURRENCY") && categoryId.contains(",")) {
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

}
