package org.gt.projects.gbm.controller;

import javax.servlet.http.HttpServletRequest;

import org.gt.projects.gbm.base.BaseAPIController;
import org.gt.projects.gbm.base.BaseAPIResponse;
import org.gt.projects.gbm.utils.JsonFileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/**
 * @author  JX.Wu
 * @date  2018年9月14日
 */
@RestController
@RequestMapping("/mobile/v1")
public class CommonController extends BaseAPIController{
	
	@RequestMapping(value = "version", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> version() {
		String json = JsonFileUtils.readFileToString("version");
		return new BaseAPIResponse<JSONObject>(JSONObject.fromObject(json));
	}
	
	@RequestMapping(value = "logout", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> logout(HttpServletRequest request) {
		String amsession = request.getHeader("AMSESSION");
		String customerId = amsession.substring(amsession.indexOf("_") + 1, amsession.lastIndexOf("_"));
		JSONObject jsonObject = new JSONObject();
		if(customerId.equals("0")) {
			jsonObject.put("username", "");
		} else if (customerId.equals("2")) {
			jsonObject.put("username", "Mr Chen");
		} else if (customerId.equals("6")) {
			jsonObject.put("username", "Jones WwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		} else {
			jsonObject.put("username", "Jones");
		}
		return new BaseAPIResponse<JSONObject>(jsonObject);
	}
}

