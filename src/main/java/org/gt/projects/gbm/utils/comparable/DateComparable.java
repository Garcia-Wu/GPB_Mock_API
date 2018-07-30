package org.gt.projects.gbm.utils.comparable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import net.sf.json.JSONObject;

/**
 * @author  JX.Wu
 * @date  2018年7月27日
 */
public class DateComparable implements Comparator<JSONObject>{
	
	public static final String DESC = "desc";
	public static final String ASC = "asc";
	
	protected String orderField;
	protected String sequence;
	
	private String dateFormat;
	
	public DateComparable(String orderField, String sequence, String dateFormat) {
		super();
		this.orderField = orderField;
		this.sequence = sequence;
		this.dateFormat = dateFormat;
	}

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = simpleDateFormat.parse(o1.getString(orderField));
			date2 = simpleDateFormat.parse(o2.getString(orderField));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("时间格式化错误，属性分别为："+o1.getString(orderField) + "   "+o2.getString(orderField));
		}
		if(date1.getTime() > date2.getTime()) {
			if(DESC.equals(sequence)) {
				return -1;
			} else {
				return 1;
			}
		} else if (date1.getTime() < date2.getTime()) {
			if(DESC.equals(sequence)) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
	}
	
	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

}

