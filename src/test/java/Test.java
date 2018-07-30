import java.util.Collections;

import org.gt.projects.gbm.utils.JsonFileUtils;
import org.gt.projects.gbm.utils.comparable.JsonCompare;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author JX.Wu
 * @date 2018年7月25日
 */
public class Test {

	public static void main(String[] args) throws Exception {
//		String s1 = "123,293.98 GBP";
//		String s2 = "123,293.98  GBP";
//		String s3 = "(123293.98 GBP)*";
//		String s4 = "(123293.98  GBP)*";
//		String s5 = "8,123,293.98";
//		System.out.println(getAmount(s1));
//		System.out.println(getAmount(s2));
//		System.out.println(getAmount(s3));
//		System.out.println(getAmount(s4));
//		System.out.println(getAmount(s5));
		JSONArray jsonArray = JSONObject.fromObject(JsonFileUtils.readFileToString("test")).getJSONArray("test");
		JsonCompare compare = new JsonCompare(new String[] { "id", "name", "code" },
				new String[] { JsonCompare.NUMBER, JsonCompare.LETTER, JsonCompare.LETTER },
				new String[] { JsonCompare.DESC, JsonCompare.ASC, JsonCompare.ASC });
		Collections.sort(jsonArray, compare);
		for (Object object : jsonArray) {
			System.out.println(object);
		}
	}

	public static double getAmount(String amount) {
		amount = amount.replace("  ", " ").replace("(", "").replaceAll(",", "");
		if (amount.contains(" ")) {
			amount = amount.substring(0, amount.indexOf(" "));
		}
		return Double.valueOf(amount.trim());
	}

}
