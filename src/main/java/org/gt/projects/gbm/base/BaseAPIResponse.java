package org.gt.projects.gbm.base;

import java.io.Serializable;

/**
 * @author  JX.Wu
 * @date  2018年5月16日
 */
public class BaseAPIResponse<T> implements Serializable{
	private String code = "0";
	private String message = "success";
	private T data;
	
	public BaseAPIResponse() {
	}

	public BaseAPIResponse(T data) {
		super();
		this.data = data;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
