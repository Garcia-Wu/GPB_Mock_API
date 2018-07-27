package org.gt.projects.gbm.utils.comparable;

import java.util.Comparator;

import net.sf.json.JSONObject;

/**
 * @author  JX.Wu
 * @date  2018年7月26日
 */
public class CurrencyComparable implements Comparator<JSONObject>{

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		if(o1.getString("code").compareTo(o2.getString("code")) < 0) {
			return -1;
		} else if (o1.getString("code").compareTo(o2.getString("code")) > 0) {
			return 1;
		}
		return 0;
	}

}

