package org.gt.projects.gbm.base.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gt.projects.gbm.base.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author  JX.Wu
 * @date  2018年9月7日
 */
public class HeaderInterceptor extends HandlerInterceptorAdapter{
	
	private final Logger requestLogger = LoggerFactory.getLogger(HeaderInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		requestLogger.info("AMSESSION:"+request.getHeader("AMSESSION"));
		requestLogger.info("LtpaToken2:"+request.getHeader("LtpaToken2"));
		
		String lackHeader = "";
		if (request.getHeader("AMSESSION") == null) {
			lackHeader += "'AMSESSION'";
		}
		if (request.getHeader("LtpaToken2") == null) {
			if(!lackHeader.equals("")) {
				lackHeader += ",";
			}
			lackHeader += "'LtpaToken2'";
		}
		
		if(!lackHeader.equals("")) {
			throw new BaseException("Required header "+lackHeader+" is not present!");
		}
		
		return super.preHandle(request, response, handler);
	}
}

