package org.gt.projects.gbm.utils;

import java.util.Collections;

import org.gt.projects.gbm.base.BaseAPIResponse;
import org.gt.projects.gbm.base.BaseException;
import org.gt.projects.gbm.base.comparable.JsonCompare;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author JX.Wu
 * @date 2019年1月3日
 */
public class CommonUtil {

	public static BaseAPIResponse<JSONObject> getAllocationData(String id, String currency, String category) {
		// 默认视为5
		if (Integer.valueOf(id) > 7) {
			id = "5";
		}

		JSONObject result = new JSONObject();
		JSONArray classList = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/class/class_" + id))
				.getJSONArray("clazz");
		JSONArray currencyList = JSONObject
				.fromObject(JsonFileUtils.readFileToString("allocation/currency/currency_" + id))
				.getJSONArray("currency");
		JSONArray regionList = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/region/region_" + id))
				.getJSONArray("region");

		// replace currency
		JsonFileUtils.replaceProperty(classList, "currency", currency.toUpperCase());
		for (int i = 0; i < classList.size(); i++) {
			JsonFileUtils.replaceProperty(classList.getJSONObject(i).getJSONArray("nodes"), "currency",
					currency.toUpperCase());
		}
		JsonFileUtils.replaceProperty(currencyList, "currency", currency.toUpperCase());
		JsonFileUtils.replaceProperty(regionList, "currency", currency.toUpperCase());

		if (currencyList.size() > 8) {
			StringBuilder currencyId = new StringBuilder();
			double currencyAmount = 0;
			double currencyWeight = 0;
			String currencyName = "Others";
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

			currencyList = JsonFileUtils.getCommonPageJsonArray(currencyList, 0, 7);
			currencyList.add(otherCurrency);
		}

		Collections.sort(classList, JsonCompare.getNumberDescThenLetterAsc("amount", "name"));
		for (Object clazz : classList) {
			Collections.sort(((JSONObject) clazz).getJSONArray("nodes"),
					JsonCompare.getNumberDescThenLetterAsc("amount", "name"));
		}
		// 将Others放在列表最后
		// for (Object object : classList) {
		// if(((JSONObject)object).getString("name").equals("Others")) {
		// classList.remove(object);
		// classList.add(object);
		// break;
		// }
		// }

		Collections.sort(currencyList, JsonCompare.getNumberDescThenLetterAsc("amount", "name"));
		Collections.sort(regionList, JsonCompare.getNumberDescThenLetterAsc("amount", "name"));

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

	public static BaseAPIResponse<JSONObject> getAllocationHoldings(String id, String currency, String category,
			String categoryId, Integer offset, Integer limit) {
		String json = JsonFileUtils.readFileToString("portfolio_holding_list");
		JSONArray holdingJson = JSONObject.fromObject(json).getJSONArray("holdings");
		JSONObject resultJson = new JSONObject();
		JSONObject allocation = new JSONObject();

		// 默认视为5(currency有可能多个ID拼接情况)
		if (id.contains(",") || Integer.valueOf(id) > 7) {
			id = "5";
		}

		JSONArray jsonArray = null;
		if (category.equalsIgnoreCase("ASSET")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/class/class_" + id))
					.getJSONArray("clazz");
		} else if (category.equalsIgnoreCase("CURRENCY")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/currency/currency_" + id))
					.getJSONArray("currency");
		} else if (category.equalsIgnoreCase("REGION")) {
			jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/region/region_" + id))
					.getJSONArray("region");
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

			jsonObject.put("name", "Others");
			jsonObject.put("amount", categoryAmount);
		} else {
			jsonObject = JsonFileUtils.getFilterObject(jsonArray, "id", categoryId);
		}

		allocation.put("name", jsonObject.getString("name"));
		allocation.put("amount", jsonObject.getDouble("amount"));
		allocation.put("currency", currency.toUpperCase());
		resultJson.put("allocation", allocation);

		// allocation holdingList需去除Futures以及Foreign Exchange类型的holding
		JsonFileUtils.removeFilterObject(holdingJson, "id", new String[] { "11", "12" });

		JSONArray resultHolding = new JSONArray();
		if (category.equalsIgnoreCase("asset")) {
			JSONArray simpleHolding = JsonFileUtils.getPageJsonArray(holdingJson, 0, 2);
			JSONArray nodeList = jsonObject.getJSONArray("nodes");
			for (int i = 0; i < nodeList.size(); i++) {
				// 除了第二个，其他所有asset class的第一个subClass拥有全部holding，其余只获取前2个
				JSONArray nodeHoldingList;
				if (i == 0 && !categoryId.endsWith("2")) {
					nodeHoldingList = holdingJson;
				} else {
					nodeHoldingList = simpleHolding;
				}

				// 加上索引以区分
				// for(int j = 0; j < nodeHoldingList.size(); j++) {
				// String holdingName = nodeHoldingList.getJSONObject(j).getString("name");
				// if(holdingName.indexOf("_") == -1) {
				// nodeHoldingList.getJSONObject(j).put("name", i + "_" + holdingName);
				// } else {
				// nodeHoldingList.getJSONObject(j).put("name", i + "_" +
				// holdingName.substring(holdingName.indexOf("_") + 1));
				// }
				// }
				resultHolding.addAll(nodeHoldingList);
			}
		} else {
			// 实现数据变动
			int categoryIdNum = Integer.valueOf(categoryId.substring(0, 1));
			if (categoryIdNum > 1 && categoryIdNum < 19) {
				resultHolding = JsonFileUtils.getSubList(holdingJson, categoryIdNum - 1);
			} else {
				resultHolding = holdingJson;
			}
		}
		Collections.sort(resultHolding, JsonCompare.getNumberOrderDesc("reportAmount"));
		resultJson.put("totalSize", resultHolding.size());
		resultHolding = JsonFileUtils.getPageJsonArray(resultHolding, offset, limit);
		resultJson.put("holdings", resultHolding);
		JsonFileUtils.formatObjectNumber2DP(resultJson, "type", "totalSize");
		return new BaseAPIResponse<JSONObject>(resultJson);
	}

	public static BaseAPIResponse<JSONObject> getAllocationHoldingGroup(String id, String currency, String category,
			String categoryId, Integer offset, Integer limit) {
		if(!category.equalsIgnoreCase("asset")) {
			throw new BaseException("category not support!");
		} 
		JSONArray holdingJson = JSONObject.fromObject(JsonFileUtils.readFileToString("portfolio_holding_list")).getJSONArray("holdings");
		// allocation holdingList需去除Futures以及Foreign Exchange类型的holding
		JsonFileUtils.removeFilterObject(holdingJson, "id", new String[] { "11", "12" });
		JSONArray simpleHolding = JsonFileUtils.getPageJsonArray(holdingJson, 0, 2);
		JSONObject resultJson = new JSONObject();

		JSONArray jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/class/class_"+id)).getJSONArray("clazz");
		JSONArray nodeList = JsonFileUtils.getFilterObject(jsonArray, "id", categoryId).getJSONArray("nodes");
		JSONArray holdingGroups = new JSONArray();
		int totalSize = 0;
		for (int i = 0; i < nodeList.size(); i++) {
			JSONObject node = nodeList.getJSONObject(i);
			JSONObject holdingGroup = new JSONObject();
			holdingGroup.put("subAssetId", node.get("id"));
			holdingGroup.put("subAssetName", node.get("name"));
			holdingGroup.put("subAssetAmount", node.get("amount"));
			holdingGroup.put("subAssetCurrency", currency.toUpperCase());
			
			// 除了第二个，其他所有asset class的第一个subClass拥有全部holding，其余只获取前2个
			JSONArray nodeHoldingList = new JSONArray();
			if(i == 0 && !categoryId.endsWith("2")) {
				nodeHoldingList = holdingJson;
			} else {
				nodeHoldingList = simpleHolding;
			}
			
			holdingGroup.put("holdings", nodeHoldingList);
			holdingGroups.add(holdingGroup);
			totalSize += nodeHoldingList.size();
		}
		
		holdingGroups = getPageHoldingGroup(holdingGroups, offset, limit);
		resultJson.put("holdingGroup", holdingGroups);
		resultJson.put("totalSize", totalSize);
		JsonFileUtils.formatObjectNumber2DP(resultJson, "type", "totalSize");
		return new BaseAPIResponse<JSONObject>(resultJson);
	}
	
	private static JSONArray getPageHoldingGroup(JSONArray holdingGroups, Integer offset, Integer limit) {
		JSONArray resultGroups = new JSONArray();
		int totalNum = 0;
		for (int i = 0; i < holdingGroups.size(); i++) {
			JSONArray holdings = holdingGroups.getJSONObject(i).getJSONArray("holdings");
			JSONArray newHoldings = new JSONArray();
			for(int j = 0; j < holdings.size(); j++) {
				if(totalNum >= offset && totalNum < offset + limit) {
					newHoldings.add(holdings.getJSONObject(j));
				}
				totalNum += 1;
			}
			if(newHoldings.size() > 0) {
				holdingGroups.getJSONObject(i).put("holdings", newHoldings);
				resultGroups.add(holdingGroups.getJSONObject(i));
			}
		}
		return resultGroups;
	}

}
