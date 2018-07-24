package org.gt.projects.gbm.utils.comparable;

import java.util.Comparator;

import net.sf.json.JSONObject;

public class LiabilitiesComparable implements Comparator<JSONObject>{

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		if(o1.getDouble("remainingBaseAmount") > o2.getDouble("remainingBaseAmount")) {
			return -1;
		} else if (o1.getDouble("remainingBaseAmount") < o2.getDouble("remainingBaseAmount")) {
			return 1;
		}
		return 0;
	}

}
