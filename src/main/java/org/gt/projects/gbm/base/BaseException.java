package org.gt.projects.gbm.base;

/**
 * @author  JX.Wu
 * @date  2018年7月27日
 */
public class BaseException extends RuntimeException{
	
	private String code;

	public BaseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String code, String message) {
		super(message);
		this.code = code;
	}

	public BaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}

