package org.gt.projects.gbm.utils.comparable;

import java.util.Comparator;

import net.sf.json.JSONObject;

/**
 * @author  JX.Wu
 * @date  2018年7月25日
 */
public class HoldingsComparable implements Comparator<JSONObject>{

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		if(o1.getDouble("reprotAmount") > o2.getDouble("reprotAmount")) {
			return -1;
		} else if (o1.getDouble("reprotAmount") < o2.getDouble("reprotAmount")) {
			return 1;
		}
		return 0;
	}

}

