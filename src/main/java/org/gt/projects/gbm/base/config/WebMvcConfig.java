package org.gt.projects.gbm.base.config;

import org.gt.projects.gbm.base.config.interceptor.HeaderInterceptor;
import org.gt.projects.gbm.base.config.interceptor.RequestLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author  JX.Wu
 * @date  2018年3月7日
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestLogInterceptor());
		registry.addInterceptor(new HeaderInterceptor()).excludePathPatterns("/mobile/v1/customer/userprofile");
	}
}
