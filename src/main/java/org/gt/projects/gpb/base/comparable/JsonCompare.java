package org.gt.projects.gpb.base.comparable;

import java.util.Comparator;

import org.gt.projects.gpb.base.BaseException;

import net.sf.json.JSONObject;

/**
 * @author  JX.Wu
 * @date  2018年7月27日
 */
public class JsonCompare implements Comparator<JSONObject>{
	
	public static final String DESC = "desc";
	public static final String ASC = "asc";
	
	public static final String NUMBER = "number";
	// not support Chinese
	public static final String LETTER = "letter";
	
	protected String[] orderField;
	protected String[] orderFieldType = {NUMBER};
	protected String[] sequence;
	
	private static JsonCompare jsonCompare;
	
	/**
	 * 根据数字属性排序
	 * @param orderField 数字属性名
	 * @param sequence 排序方式
	 */
	public JsonCompare(String orderField, String sequence) {
		super();
		this.orderField = new String[] {orderField};
		this.sequence = new String[] {sequence};
	}
	
	/**
	 * 单属性自定义排序
	 * @param orderField 排序属性名
	 * @param orderFieldType 排序属性类型
	 * @param sequence 排序方式
	 */
	public JsonCompare(String orderField, String orderFieldType, String sequence) {
		super();
		this.orderField = new String[] {orderField};
		this.orderFieldType = new String[] {orderFieldType};
		this.sequence = new String[] {sequence};
	}
	
	/**
	 * 多属性排序
	 * @param orderField 排序属性名数组
	 * @param orderFieldType 排序属性排序类型数组（如JsonCompare.LETTER）
	 * @param sequence 排序方式（升序或降序）
	 * eg: 
	 *  JsonCompare compare = new JsonCompare(new String[] { "amount", "type", "description" },
				new String[] { JsonCompare.NUMBER, JsonCompare.LETTER, JsonCompare.LETTER },
				new String[] { JsonCompare.DESC, JsonCompare.ASC, JsonCompare.ASC });
	 */
	public JsonCompare(String orderField[], String orderFieldType[], String sequence[]) {
		super();
		this.orderField = orderField;
		this.orderFieldType = orderFieldType;
		this.sequence = sequence;
	}
	
	/**
	 * 根据数字属性降序排序
	 * @param orderField 数字属性名
	 * @return
	 */
	public static JsonCompare getNumberOrderDesc(String orderField) {
		jsonCompare = new JsonCompare(orderField, DESC);
		return jsonCompare;
	}
	
	/**
	 * 根据数字属性升序排序
	 * @param orderField 数字属性名
	 * @return
	 */
	public static JsonCompare getNumberOrderAsc(String orderField) {
		jsonCompare = new JsonCompare(orderField, ASC);
		return jsonCompare;
	}
	
	/**
	 * 根据数字属性升序排序再按英文属性升序排序
	 * @param orderField 数字属性名
	 * @return
	 */
	public static JsonCompare getNumberAscThenLetterAsc(String numberField, String letterField) {
		String[] fields = {numberField, letterField};
		String[] fieldTypes = {JsonCompare.NUMBER, JsonCompare.LETTER};
		String[] fieldOrders = {JsonCompare.ASC, JsonCompare.ASC};
		jsonCompare = new JsonCompare(fields, fieldTypes, fieldOrders);
		return jsonCompare;
	}
	
	/**
	 * 根据数字属性降序排序再按英文属性升序排序
	 * @param orderField 数字属性名
	 * @return
	 */
	public static JsonCompare getNumberDescThenLetterAsc(String numberField, String letterField) {
		String[] fields = {numberField, letterField};
		String[] fieldTypes = {JsonCompare.NUMBER, JsonCompare.LETTER};
		String[] fieldOrders = {JsonCompare.DESC, JsonCompare.ASC};
		jsonCompare = new JsonCompare(fields, fieldTypes, fieldOrders);
		return jsonCompare;
	}
	
	/**
	 * 根据英文属性降序排序 （Z-A）
	 * @param orderField 英文属性名
	 * @return
	 */
	public static JsonCompare getLetterOrderDesc(String orderField) {
		jsonCompare = new JsonCompare(orderField, LETTER, DESC);
		return jsonCompare;
	}
	
	/**
	 * 根据英文属性升序排序 （A-Z）
	 * @param orderField 英文属性名
	 * @return
	 */
	public static JsonCompare getLetterOrderAsc(String orderField) {
		jsonCompare = new JsonCompare(orderField, LETTER, ASC);
		return jsonCompare;
	}
	
	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		if(orderField.length != orderFieldType.length || orderFieldType.length != sequence.length) {
			throw new BaseException("The arrays length should be consistent！");
		}
		int result = 0;
		for (int i = 0; i < orderField.length; i++) {
			if(NUMBER.equals(orderFieldType[i])) {
				int numCompare = this.getNumCompare(o1.getDouble(orderField[i]), o2.getDouble(orderField[i]), sequence[i]);
				if(numCompare != 0) {
					result = numCompare;
					break;
				} else {
					continue;
				}
			} else if (LETTER.equals(orderFieldType[i])){
				int letterCompare = this.getLetterCompare(o1.getString(orderField[i]), o2.getString(orderField[i]), sequence[i]);
				if(letterCompare != 0) {
					result = letterCompare;
					break;
				} else {
					continue;
				}
			}
		}
//		System.out.println("["+o1+"] and ["+o2+"] :return ["+result+"]");
		return result;
	}
	
	public int getNumCompare(double num1, double num2, String sequence) {
		if(num1 > num2) {
			if(DESC.equals(sequence)) {
				return -1;
			} else {
				return 1;
			}
		} else if (num1 < num2) {
			if(DESC.equals(sequence)) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
	}
	
	public int getLetterCompare(String str1, String str2, String sequence) {
		if(str1.compareTo(str2) > 0) {
			if(DESC.equals(sequence)) {
				return -1;
			} else {
				return 1;
			}
		} else if (str1.compareTo(str2) < 0) {
			if(DESC.equals(sequence)) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
	}

	public String[] getOrderField() {
		return orderField;
	}

	public void setOrderField(String[] orderField) {
		this.orderField = orderField;
	}

	public String[] getOrderFieldType() {
		return orderFieldType;
	}

	public void setOrderFieldType(String[] orderFieldType) {
		this.orderFieldType = orderFieldType;
	}

	public String[] getSequence() {
		return sequence;
	}

	public void setSequence(String[] sequence) {
		this.sequence = sequence;
	}
}

