package org.gt.projects.gbm.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.gt.projects.gbm.GbmApplication;
import org.springframework.boot.ApplicationHome;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonFileUtils {

	public static final String JAR_PATH = new ApplicationHome(JsonFileUtils.class).getSource().getParentFile().toString();

	/**
	 * 读取文件，返回字符串
	 * @param fileName 文件名
	 * @return 文件字符串
	 */
	public static String readFileToString(String fileName) {
		String filePath = "resultJson"+ File.separator + fileName + ".json";	
		InputStream input = null;
		try {
			if(GbmApplication.JSON_IN_PROJECT) {
				// 获取项目下文件的输入流
				input = JsonFileUtils.class.getClassLoader().getResourceAsStream(filePath);
			} else {
				// 获取项目外文件的输入流（jar包同级目录下）
				filePath = JAR_PATH + File.separator +filePath;
				input = new FileInputStream(new File(filePath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		byte[] bcache = new byte[2048];  
	    int readSize = 0;//每次读取的字节长度  
	    ByteArrayOutputStream infoStream = new ByteArrayOutputStream(); 
	    String result = "";
	    try {
			while ((readSize = input.read(bcache)) > 0) {
			    //将bcache中读取的input数据写入infoStream  
			    infoStream.write(bcache,0,readSize);  
			}
			result = infoStream.toString("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//	    System.out.println(result);
	    return result;
	}

	/**
	 * 获取分页数组
	 * @param jsonArray
	 * @param page 
	 * @param pageSize 
	 * @return
	 */
	public static JSONArray getPageJsonArray(JSONArray jsonArray, int page, int pageSize) {
		if(pageSize == -1) {
			return jsonArray;
		}
		JSONArray result = new JSONArray();
		int fromIndex = page * pageSize;
		int toIndex = page * pageSize + pageSize;
		for(int i = 0; i < jsonArray.size(); i++) {
			if (i >= toIndex) {
				break;
			}
			if(i >= fromIndex && i < toIndex) {
				result.add(jsonArray.get(i));
			}
		}
		jsonArray = result;
		return result;
	}
	
	public static JSONArray subJsonArray(JSONArray jsonArray, int startIndex, int endIndex) {
		JSONArray result = new JSONArray();
		for(int i = startIndex; i < jsonArray.size(); i++) {
			if (i >= endIndex) {
				break;
			}
			result.add(jsonArray.get(i));
		}
		jsonArray = result;
		return result;
	}


	public static JSONArray getIdsArray(JSONArray jsonArray, List<String> ids) {
		JSONArray result = new JSONArray();
		for (String id : ids) {
			for (int i = 0; i < jsonArray.size(); i++) {
				String jsonId = jsonArray.getJSONObject(i).get("id").toString();
				if(id.equals(jsonId)) {
					result.add(jsonArray.getJSONObject(i));
				}
			}
		}
		return result;
	}
	
	/**
	 * 根据数组属性筛选
	 * @param jsonArray
	 * @param filterKey
	 * @param filterValue
	 * @return
	 */
	public static JSONArray getFilterArray(JSONArray jsonArray, String filterKey, String filterValue) {
		JSONArray result = new JSONArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			if(jsonArray.getJSONObject(i).getString(filterKey).equalsIgnoreCase(filterValue)) {
				result.add(jsonArray.getJSONObject(i));
			}
		}
		return result;
	}
	
	/**
	 * 根据数组属性筛选
	 * @param jsonArray
	 * @param filterKey
	 * @param filterValue
	 * @param resultCount 获取多少个
	 * @return
	 */
	public static JSONArray getFilterArray(JSONArray jsonArray, String filterKey, String filterValue, int resultCount) {
		JSONArray result = new JSONArray();
		int count = 0;
		for (int i = 0; i < jsonArray.size(); i++) {
			if(count >= resultCount) {
				break;
			}
			if(jsonArray.getJSONObject(i).getString(filterKey).equalsIgnoreCase(filterValue)) {
				result.add(jsonArray.getJSONObject(i));
				count++;
			}
		}
		return result;
	}
	
	public static JSONObject getFilterObject(JSONArray jsonArray, String filterKey, String filterValue) {
		return getFilterArray(jsonArray, filterKey, filterValue, 1).getJSONObject(0);
	}
	
	/**
	 * 替换数组属性值
	 * @param jsonArray
	 * @param property
	 * @param replaceValue
	 * @return
	 */
	public static JSONArray replaceProperty(JSONArray jsonArray, String property, Object replaceValue) {
		for (int i = 0; i < jsonArray.size(); i++) {
			jsonArray.getJSONObject(i).put(property, replaceValue);
		}
		return jsonArray;
	}
	
	/**
	 * 将json数组下所有数字格式化为保留2位小数
	 * @param jsonArray
	 * @return
	 */
	public static JSONArray formatArrayNumber2DP(JSONArray jsonArray) {
		return formatArrayNumber2DP(jsonArray, null);
	}
	
	/**
	 * 将json对象下所有数字格式化为保留2位小数
	 * @param jsonObject
	 * @return
	 */
	public static JSONObject formatObjectNumber2DP(JSONObject jsonObject) {
		return formatObjectNumber2DP(jsonObject, null);
	}
	
	/**
	 * 将json对象下所有数字格式化为保留2位小数
	 * @param jsonObject
	 * @param exceptField 指定不格式化的属性
	 * @return
	 */
	public static JSONObject formatObjectNumber2DP(JSONObject jsonObject, String[] exceptField) {
		Set<String> set = jsonObject.keySet();
		forObjectSet: for (String key : set) {
			if(exceptField != null && exceptField.length > 0) {
				for (String field : exceptField) {
					if(key.equals(field)) {
						continue forObjectSet;
					}
				}
			}
			if(jsonObject.get(key).getClass().equals(JSONArray.class)) {
				formatArrayNumber2DP(jsonObject.getJSONArray(key), exceptField);
			}
			if(jsonObject.get(key).getClass().equals(JSONObject.class)) {
				formatObjectNumber2DP(jsonObject.getJSONObject(key), exceptField);
			}
			if(jsonObject.get(key).getClass().equals(Integer.class) || jsonObject.get(key).getClass().equals(Double.class)) {
		        BigDecimal d1=new BigDecimal(String.valueOf(jsonObject.get(key))).setScale(2, BigDecimal.ROUND_HALF_UP);
		        jsonObject.put(key, d1);
			}
		}
		return jsonObject;
	}
	
	/**
	 * 将json数组下所有数字格式化为保留2位小数
	 * @param jsonArray
	 * @param exceptField 指定不格式化的属性
	 * @return
	 */
	public static JSONArray formatArrayNumber2DP(JSONArray jsonArray, String[] exceptField) {
		for (int i = 0; i < jsonArray.size(); i++) {
			formatObjectNumber2DP(jsonArray.getJSONObject(i), exceptField);
		}
		return jsonArray;
	}
	
	public static JSONArray removeFilterObject(JSONArray jsonArray, String filterKey, String filterValue) {
		return removeFilterObject(jsonArray, filterKey, new String[] {filterValue});
	}

	public static JSONArray removeFilterObject(JSONArray jsonArray, String filterKey, String[] filterValues) {
		for (int i = 0; i < jsonArray.size(); i++) {
			for (String filterValue : filterValues) {
				if(jsonArray.getJSONObject(i).getString(filterKey).equalsIgnoreCase(filterValue)) {
					jsonArray.remove(i);
				}
			}
		}
		return jsonArray;
	}
	
}
