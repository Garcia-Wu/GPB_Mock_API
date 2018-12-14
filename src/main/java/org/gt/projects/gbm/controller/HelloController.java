package org.gt.projects.gbm.controller;

import org.gt.projects.gbm.aop.TestAnnotation;
import org.gt.projects.gbm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  JX.Wu
 * @date  2018年12月14日
 */
@RestController
public class HelloController {
	
	@Autowired
	private TestService testService;
	
	@TestAnnotation
	@RequestMapping("hello")
	public String hello() {
		testService.testSave();
		return "hello aop!";
	}
	
//	@TestAnnotation
	@RequestMapping("hi")
	public String hi() {
		testService.testAnnotation();
		return "hello aop!";
	}
	
}

