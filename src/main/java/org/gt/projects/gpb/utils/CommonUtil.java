package org.gt.projects.gpb.utils;

import java.math.BigDecimal;
import java.util.Collections;

import org.gt.projects.gpb.base.BaseAPIResponse;
import org.gt.projects.gpb.base.BaseException;
import org.gt.projects.gpb.base.comparable.JsonCompare;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author JX.Wu
 * @date 2019年1月3日
 */
public class CommonUtil {

	public static BaseAPIResponse<JSONObject> getAllocationData(String id, String currency, String category) {
		id = handleId(id);

		if(!category.equals("ALL") && !category.equals("ASSET") && !category.equals("CURRENCY") && !category.equals("REGION")) {
			throw new BaseException("Category not support!");
		}
		
		JSONObject result = new JSONObject();
		JSONArray classList = new JSONArray();
		if(category.equals("ALL") || category.equals("ASSET")) {
			classList = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/class/class_" + id)).getJSONArray("clazz");
		}
		JSONArray currencyList = new JSONArray();
		if(category.equals("ALL") || category.equals("CURRENCY")) {
			currencyList = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/currency/currency_" + id)).getJSONArray("currency");
		}
		JSONArray regionList = new JSONArray();
		if(category.equals("ALL") || category.equals("REGION")) {
			regionList = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/region/region_" + id)).getJSONArray("region");
		}

		// replace currency
		JsonFileUtils.replaceProperty(classList, "currency", currency.toUpperCase());
		for (int i = 0; i < classList.size(); i++) {
			JsonFileUtils.replaceProperty(classList.getJSONObject(i).getJSONArray("nodes"), "currency",
					currency.toUpperCase());
		}
		JsonFileUtils.replaceProperty(currencyList, "currency", currency.toUpperCase());
		JsonFileUtils.replaceProperty(regionList, "currency", currency.toUpperCase());

		Collections.sort(classList, JsonCompare.getNumberDescThenLetterAsc("amount", "name"));
		for (Object clazz : classList) {
			Collections.sort(((JSONObject) clazz).getJSONArray("nodes"),
					JsonCompare.getNumberDescThenLetterAsc("amount", "name"));
		}
		Collections.sort(currencyList, JsonCompare.getNumberDescThenLetterAsc("amount", "name"));
		Collections.sort(regionList, JsonCompare.getNumberDescThenLetterAsc("amount", "name"));

		if (currencyList.size() > 8) {
			StringBuilder currencyId = new StringBuilder("");
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

		setAllocationOrder(classList);
		setAllocationOrder(currencyList);
		setAllocationOrder(regionList);

		setWeight(classList);
		setWeight(currencyList);
		setWeight(regionList);

		result.put("clazz", classList);
		result.put("currency", currencyList);
		result.put("region", regionList);

//		if (category != null) {
//			JSONArray nullList = new JSONArray();
//			if (category.equalsIgnoreCase("ASSET")) {
//				result.put("currency", nullList);
//				result.put("region", nullList);
//			} else if (category.equalsIgnoreCase("CURRENCY")) {
//				result.put("clazz", nullList);
//				result.put("region", nullList);
//			} else if (category.equalsIgnoreCase("REGION")) {
//				result.put("clazz", nullList);
//				result.put("currency", nullList);
//			}
//		}

//		BigDecimal total = new BigDecimal("0");
//		for (Object object : result.getJSONArray("clazz")) {
//			total = total.add(new BigDecimal(((JSONObject) object).getDouble("amount") + ""));
//		}
//		System.out.println("customerId:" + id + "  total amount:" + total.toPlainString());

		JsonFileUtils.formatObjectNumber2DP(result);
		return new BaseAPIResponse<JSONObject>(result);
	}

	private static void setAllocationOrder(JSONArray assetList) {
		// 正数从大到小排序，负数从小到大排序，最后将Others放在尾部
		JSONArray negativeList = new JSONArray();
		JSONObject otherObject = null;
		for (Object object : assetList) {
			if (((JSONObject) object).getDouble("amount") < 0) {
				negativeList.add(object);
			}
			if (((JSONObject) object).getString("name").equals("Others")) {
				otherObject = (JSONObject) object;
			}
		}

		if (negativeList.size() > 0) {
			assetList.removeAll(negativeList);
			Collections.sort(negativeList, JsonCompare.getNumberAscThenLetterAsc("amount", "name"));
			assetList.addAll(negativeList);
		}
		if (otherObject != null) {
			assetList.remove(otherObject);
			assetList.add(otherObject);
		}
	}

	private static void setWeight(JSONArray assetList) {
		BigDecimal positiveAmount = new BigDecimal("0");
		for (Object object : assetList) {
			JSONObject asset = (JSONObject) object;
			if (asset.getDouble("amount") > 0) {
				positiveAmount = positiveAmount.add(new BigDecimal(asset.getDouble("amount") + ""));
			} else if (asset.getDouble("amount") == 0) {
				asset.put("donutWeight", "0.00");
				asset.put("weight", 0.00);
			}
		}
		
		if (positiveAmount.doubleValue() > 0) {
			for (Object object : assetList) {
				JSONObject asset = (JSONObject) object;
				if (asset.getDouble("amount") >= 0) {
					BigDecimal amount = new BigDecimal(asset.getDouble("amount") + "");
					BigDecimal dountWeight = amount.divide(positiveAmount, 4, BigDecimal.ROUND_HALF_UP);
					asset.put("donutWeight", dountWeight.multiply(new BigDecimal("100")).setScale(2).toPlainString());
					asset.put("weight", dountWeight.multiply(new BigDecimal("100")).setScale(2));
				} else {
					asset.put("donutWeight", "");
				}
			}
		} else if (positiveAmount.doubleValue() < 0) {
			for (Object object : assetList) {
				JSONObject asset = (JSONObject) object;
				asset.put("donutWeight", "");
			}
		}
	}

	private static String handleId(String id) {
		if (id.contains(",")) {
			// others默认视为5(存在于currency)
			id = "5";
		} else if (Integer.valueOf(id) > 8) {
			id = Integer.valueOf(id) % 8 + "";
		}
		return id;
	}

	public static BaseAPIResponse<JSONObject> getAllocationHoldings(String id, String currency, String category,
			String categoryId, Integer offset, Integer limit) {
		id = handleId(id);
		String json = JsonFileUtils.readFileToString("portfolio_holding_list");
		JSONArray holdingJson = JSONObject.fromObject(json).getJSONArray("holdings");
		JSONObject resultJson = new JSONObject();
		JSONObject allocation = new JSONObject();

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
			JSONArray simpleHolding = JsonFileUtils.getCommonPageJsonArray(holdingJson, 1, 2);
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

		if (category.equalsIgnoreCase("currency") && !allocation.getString("name").equals("Others")) {
			for (int i = 0; i < resultHolding.size(); i++) {
				JSONObject holding = resultHolding.getJSONObject(i);
				holding.put("baseCurrency", allocation.getString("name"));
				holding.put("reportCurrency", allocation.getString("currency"));
				holding.put("performanceCurrency", allocation.getString("name"));
				if (holding.getString("baseCurrency").equals(holding.get("reportCurrency"))) {
					holding.put("baseAmount", holding.get("reportAmount"));
				}
			}
		}

		resultJson.put("holdings", resultHolding);
		JsonFileUtils.formatObjectNumber2DP(resultJson, "type", "totalSize");
		return new BaseAPIResponse<JSONObject>(resultJson);
	}

	public static BaseAPIResponse<JSONObject> getAllocationHoldingGroup(String id, String currency, String category,
			String categoryId, Integer offset, Integer limit) {
		id = handleId(id);
		if (!category.equalsIgnoreCase("asset")) {
			throw new BaseException("category not support!");
		}
		JSONArray holdingJson = JSONObject.fromObject(JsonFileUtils.readFileToString("portfolio_holding_list"))
				.getJSONArray("holdings");
		// allocation holdingList需去除Futures以及Foreign Exchange类型的holding
		JsonFileUtils.removeFilterObject(holdingJson, "id", new String[] { "11", "12" });
		JSONArray simpleHolding = JsonFileUtils.getCommonPageJsonArray(holdingJson, 1, 2);
		JSONObject resultJson = new JSONObject();

		JSONArray jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("allocation/class/class_" + id))
				.getJSONArray("clazz");
		JSONArray nodeList = JsonFileUtils.getFilterObject(jsonArray, "id", categoryId).getJSONArray("nodes");
		JSONArray holdingGroups = new JSONArray();
		int totalSize = 0;
		for (int i = 0; i < nodeList.size(); i++) {
			JSONObject node = nodeList.getJSONObject(i);
			JSONObject holdingGroup = new JSONObject();
			holdingGroup.put("subAssetId", node.get("id"));
			holdingGroup.put("subAssetName", node.get("name"));

			// 除了第二个，其他所有asset class的第一个subClass拥有全部holding，其余只获取前2个
			JSONArray nodeHoldingList = new JSONArray();
			if (i == 0 && !categoryId.endsWith("2")) {
				nodeHoldingList = holdingJson;
			} else {
				nodeHoldingList = simpleHolding;
			}

			// 计算subAssetAmount
			BigDecimal subAssetAmount = new BigDecimal("0");
			for (Object object : nodeHoldingList) {
				JSONObject holding = (JSONObject) object;
				subAssetAmount = subAssetAmount.add(new BigDecimal(holding.get("reportAmount") + ""));
			}

			holdingGroup.put("subAssetAmount", subAssetAmount.doubleValue());
			holdingGroup.put("subAssetCurrency", currency.toUpperCase());

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
			for (int j = 0; j < holdings.size(); j++) {
				if (totalNum >= offset && totalNum < offset + limit) {
					newHoldings.add(holdings.getJSONObject(j));
				}
				totalNum += 1;
			}
			if (newHoldings.size() > 0) {
				holdingGroups.getJSONObject(i).put("holdings", newHoldings);
				resultGroups.add(holdingGroups.getJSONObject(i));
			}
		}
		return resultGroups;
	}

}
