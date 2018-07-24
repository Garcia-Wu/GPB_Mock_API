package org.gt.projects.gbm.utils.comparable;

import java.util.Comparator;

import net.sf.json.JSONObject;

public class TransactionComparable implements Comparator<JSONObject>{

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		if(o1.getLong("tradeDate") >= o2.getLong("tradeDate")) {
			// date一样时再进行比较下一层
			if(o1.getLong("tradeDate") == o2.getLong("tradeDate")) {
				// 如果type一样。则比较description，否则比较type
				if(o1.getString("type").equals(o2.getString("type"))) {
					// 比较description( >0顺序在前 )
					if(o1.getString("description").compareToIgnoreCase(o2.getString("description")) > 0) {
						return 1;
					} else if (o1.getString("description").compareToIgnoreCase(o2.getString("description")) < 0){
						return -1;
					} else {
						return 0;
					}
				} else {
					// 比较type( >0顺序在前 )
					if(o1.getString("type").compareToIgnoreCase(o2.getString("type")) > 0) {
						return 1;
					} else {
						return -1;
					} 
				}
			}
			return -1;
		} else {
			return 1;
		}
	}

}
