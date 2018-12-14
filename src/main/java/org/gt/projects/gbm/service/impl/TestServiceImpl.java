package org.gt.projects.gbm.service.impl;

import org.gt.projects.gbm.aop.TestAnnotation;
import org.gt.projects.gbm.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author  JX.Wu
 * @date  2018年12月14日
 */
@Service
public class TestServiceImpl implements TestService{

	@Override
	public void testSave() {
		System.out.println("save 操作...");
	}
	
	@TestAnnotation
	public void testAnnotation() {
		System.out.println("has Annotation 操作...");
	}
	
}

