package org.gt.projects.gpb.base.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author JX.Wu
 * @date 2019年2月28日
 */
public class DelayInterceptor extends HandlerInterceptorAdapter {

	// 随机延迟10秒返回数据
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			double random = Math.random() * 20;
			long sleepTime = (long) (random * 1000L);
			System.out.println("sleep time: "+ sleepTime / 1000 + "s");
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return super.preHandle(request, response, handler);
	}
}
