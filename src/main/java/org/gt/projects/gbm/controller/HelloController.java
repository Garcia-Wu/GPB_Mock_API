package org.gt.projects.gbm.controller;

import org.gt.projects.gbm.base.BaseAPIResponse;
import org.gt.projects.gbm.utils.JsonFileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class HelloController {
	
	@RequestMapping("hello")
	public String hello() {
		return "hello spring boot";
	}
	
//	@RequestMapping("hi")
//	public Object hi(){
//		String json = JsonFileUtils.readFileToString("test");
//		JSONObject jsonObject = JSONObject.fromObject(json);
//		jsonObject.put("pop", "yu");
//		jsonObject.put("haha", new User());
//		return jsonObject;
////		String json = "[{'id':5,'name':'tom'},{'id':6,'name':'yes'}]";
////		String json = "{'id':5,'name':'tom'}";
////		JSONObject jsonObject = JSONObject.fromObject(json);
////		JSONArray jsonArray = JSONArray.fromObject(json);
////		System.out.println(jsonArray.getJSONObject(1).get("name"));
//	}
	
//	@RequestMapping("/test")
//	public BaseAPIResponse<JSONObject> test() {
//		String json = JsonFileUtils.readFileToString("test");
//		JSONObject jsonObject = JSONObject.fromObject(json);
//		return new BaseAPIResponse<JSONObject>(jsonObject);
//	}
}
