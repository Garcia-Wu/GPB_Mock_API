package org.gt.projects.gbm.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.sf.json.JSONArray;

public class JsonFileUtils {

	/**
	 * 读取文件，返回字符串
	 * @param fileName 文件名
	 * @return 文件字符串
	 */
	public static String readFileToString(String fileName) {
		String filePath = "resultJson"+ File.separator + fileName + ".json";
		// 获取项目下文件的输入流
		InputStream input = JsonFileUtils.class.getClassLoader().getResourceAsStream(filePath);
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
	
}
