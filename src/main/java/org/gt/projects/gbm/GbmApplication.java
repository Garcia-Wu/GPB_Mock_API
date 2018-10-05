package org.gt.projects.gbm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GbmApplication{

	/**
	 * 设置json数据源位置
	 * true: 位于项目路径下 src/main/resources/resultJson
	 * false: 位于jar包同级目录下 resultJson
	 */
	public static Boolean JSON_IN_PROJECT;

	@Value("${json.in.project}")
	public void setJSON_IN_PROJECT(Boolean jSON_IN_PROJECT) {
		JSON_IN_PROJECT = jSON_IN_PROJECT;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GbmApplication.class, args);
	}
}
