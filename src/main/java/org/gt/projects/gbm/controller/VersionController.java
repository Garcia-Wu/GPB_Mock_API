package org.gt.projects.gbm.controller;

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
public class VersionController extends BaseAPIController{
	
	@RequestMapping(value = "version", method = { RequestMethod.GET })
	public BaseAPIResponse<JSONObject> version() {
		String json = JsonFileUtils.readFileToString("version");
		return new BaseAPIResponse<JSONObject>(JSONObject.fromObject(json));
	}
}

