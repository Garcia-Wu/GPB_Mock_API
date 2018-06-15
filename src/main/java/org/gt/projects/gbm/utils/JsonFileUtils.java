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
	 * @param filePath 文件项目路径
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
	
	public static JSONArray getFilterArray(JSONArray jsonArray, String filterKey, String filterValue) {
		JSONArray result = new JSONArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			if(jsonArray.getJSONObject(i).getString(filterKey).equalsIgnoreCase(filterValue)) {
				result.add(jsonArray.getJSONObject(i));
			}
		}
		return result;
	}
	
}
