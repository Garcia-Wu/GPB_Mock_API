package org.gt.projects.gbm.base;

import java.util.Map;

import org.gt.projects.gbm.utils.GBMConstant;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author  JX.Wu
 * @date  2018年5月16日
 */
public class BaseAPIController {

	@ExceptionHandler({Exception.class})
    @ResponseBody
    public BaseAPIResponse<String> exception(Exception ex) {
		ex.printStackTrace();
		BaseAPIResponse<String> response = new BaseAPIResponse<>();
		response.setCode(GBMConstant.GLOBAL_ERROR_CODE);
		response.setMessage(GBMConstant.GLOBAL_ERROR_MESSAGE);
		if(ex instanceof MethodArgumentTypeMismatchException) {
			response.setCode(GBMConstant.ARGUMENT_ERROR_CODE);
			response.setMessage(GBMConstant.ARGUMENT_ERROR_MESSAGE);
		}
        return response;
    }
	
	public void printJsonParams(Map<String, Object> params) {
		System.out.print("request body:\t");
		for(String key : params.keySet()) {
			System.out.print(key+"="+params.get(key)+"  ");
		}
		System.out.println();
	}
	
}
