package org.gt.projects.gbm.utils;

import java.util.Comparator;

import net.sf.json.JSONObject;

public class TransactionComparable implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		JSONObject object1 = (JSONObject) o1;
		JSONObject object2 = (JSONObject) o2;
		if(object1.getLong("tradeDate") >= object2.getLong("tradeDate")) {
			// date一样时再进行比较下一层
			if(object1.getLong("tradeDate") == object2.getLong("tradeDate")) {
				// 如果type一样。则比较description，否则比较type
				if(object1.getString("type").equals(object2.getString("type"))) {
					// 比较description( >0顺序在前 )
					if(object1.getString("description").compareToIgnoreCase(object2.getString("description")) > 0) {
						return 1;
					} else if (object1.getString("description").compareToIgnoreCase(object2.getString("description")) < 0){
						return -1;
					} else {
						return 0;
					}
				} else {
					// 比较type( >0顺序在前 )
					if(object1.getString("type").compareToIgnoreCase(object2.getString("type")) > 0) {
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
