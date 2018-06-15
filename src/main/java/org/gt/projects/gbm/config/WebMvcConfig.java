package org.gt.projects.gbm.config;

import org.gt.projects.gbm.config.interceptor.RequestLogInterceptor;
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
	}
}
