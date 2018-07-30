package org.gt.projects.gbm.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.gt.projects.gbm.responseObject.BaseAPIResponse;
import org.gt.projects.gbm.utils.GBMConstant;
import org.gt.projects.gbm.utils.JsonFileUtils;
import org.gt.projects.gbm.utils.comparable.JsonCompare;
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
		
		// fix for noTruncation
		if(Integer.valueOf(ids.get(0)) > 15) {
			for (int i = 0; i < ids.size(); i++) {
				if(!ids.get(i).equals("0")) {
					ids.set(i, String.valueOf(Integer.valueOf(ids.get(i)) - 15));
				}
			}
			resultArray = JsonFileUtils.getIdsArray(jsonArray, ids);
			if(resultArray.getJSONObject(0).getInt("id") == 1) {
				resultArray.getJSONObject(0).put("name", "FX Portfolio 1");
			}
		}
		
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
												@RequestParam(defaultValue="100")Integer limit,
															String currency) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_list");
		JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("holdings");
		if ("0".equals(id) || "3".equals(id)) {
			jsonArray.clear();
		} else if (Integer.valueOf(id) > 15) {
			// fix for noTruncation
			jsonArray.getJSONObject(0).put("name", "SNE 0.001USD Sony Corp ADR Each Rep 1 Ord NPV (CDI)LUHSony Corp ADR Each Rep 1");
		}
		
//		if(currency != null) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				jsonArray.getJSONObject(i).put("currency", currency);
//			}
//		}
		
		JsonCompare numCompare = JsonCompare.getNumberOrderDesc("reprotAmount");
		Collections.sort(jsonArray, numCompare);
		
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
			
			// fix for noTruncation
			if (Integer.valueOf(id) > 15) {
				classList.getJSONObject(0).put("name", "Liquidity and Money");
				classList.getJSONObject(0).getJSONArray("nodes").getJSONObject(0).put("name", "Futures on Forex");
				currencyList.getJSONObject(0).put("name", "Hong Kong Dollar");
				regionList.getJSONObject(0).put("name", "Europe");
			}
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
		} else if (Integer.valueOf(id) > 15) {
			// fix for noTruncation
			jsonArray.getJSONObject(0).put("description", "BRQ227M Caisse d'Amortissement de la Dette Sociale");
		}
		
		JSONObject commiment = new JSONObject();
		commiment.put("currency", reportCurrency);
//		if (currency != null) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				jsonArray.getJSONObject(i).put("baseCurrency", currency);
//				jsonArray.getJSONObject(i).put("remainingBaseCurrency", currency);
//			}
//		}
		
		JsonCompare numCompare = JsonCompare.getNumberOrderDesc("remainingBaseAmount");
		Collections.sort(jsonArray, numCompare);
		
		JSONObject jsonObject = new JSONObject();	
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		
		for (int i = 0; i< pageJson.size(); i++) {
			String valueDate = GBMConstant.ALL_MONTH_FORMAT.format(pageJson.getJSONObject(i).getLong("valueDate") * 1000);
			pageJson.getJSONObject(i).put("valueDate", valueDate);
		}
		
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
		} else if (Integer.valueOf(id) > 15) {
			// fix for noTruncation
			jsonArray.getJSONObject(0).put("type", "Cash movements1 GBP");
			jsonArray.getJSONObject(0).put("description", "Transaction Description: This is the Cash movements description, please see the description of the Cash movements 1 item");
			jsonArray.getJSONObject(1).put("type", "Purchases1 USD");
			jsonArray.getJSONObject(1).put("description", "Transaction Description: This is the purchase description, please see the description of the purchase 1 item");
			jsonArray.getJSONObject(2).put("type", "Sales1 JPY");
			jsonArray.getJSONObject(2).put("description", "Transaction Description: This is the sales description, please see the description of the sales 1 item");
		}
		
//		if (currency != null) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				jsonArray.getJSONObject(i).put("currency", currency);
//			}
//		}

		if(!type.equalsIgnoreCase("all")) {
			jsonArray = JsonFileUtils.getFilterArray(jsonArray, "filterType", type);
		}
		
		JsonCompare transactionCompare = new JsonCompare(new String[] { "tradeDate", "type", "description" },
				new String[] { JsonCompare.NUMBER, JsonCompare.LETTER, JsonCompare.LETTER },
				new String[] { JsonCompare.DESC, JsonCompare.ASC, JsonCompare.ASC });
		Collections.sort(jsonArray, transactionCompare);
		
		JSONObject jsonObject = new JSONObject();	
		JSONArray pageJson = JsonFileUtils.getPageJsonArray(jsonArray, offset, limit);
		
		for (int i = 0; i< pageJson.size(); i++) {
			String tradeDate = GBMConstant.SIM_MONTH_FORMAT.format(pageJson.getJSONObject(i).getLong("tradeDate") * 1000);
			pageJson.getJSONObject(i).put("tradeDate", tradeDate);
		}
		
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
		
		// fix for noTruncation
		if(Integer.valueOf(id) > 15 && Integer.valueOf(holdingid) == 1) {
			jsonArray.getJSONObject(0).put("name", "TESLA, INC.");
		}
		
		JSONObject jsonObject = new JSONObject();	
		jsonObject.put("holding", jsonArray.get(0));
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
	
	@RequestMapping(value = "portfolio/{id}/currency", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> currency(@PathVariable("id") String id) {
		if("2".equals(id)) {
			BaseAPIResponse<JSONObject> response = new BaseAPIResponse<>();
			response.setCode("1001");
			response.setMessage("error!");
			return response;
		} else if("3".equals(id)) {
			BaseAPIResponse<JSONObject> response = new BaseAPIResponse<>();
			response.setCode("1002");
			response.setMessage("error!");
			return response;
		}
		
		String json = JsonFileUtils.readFileToString("currency");
		JSONObject jsonObject = JSONObject.fromObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray("currencies");
		Collections.sort(jsonArray, JsonCompare.getLetterOrderAsc("code"));
		
		if("1".equals(id)) {
			jsonArray = JsonFileUtils.getPageJsonArray(jsonArray, 0, 5);
		}
		
		jsonObject.put("currencies", jsonArray);
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
}
