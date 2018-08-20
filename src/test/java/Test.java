import java.text.SimpleDateFormat;

/**
 * @author JX.Wu
 * @date 2018年7月25日
 */
public class Test {

	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat s = new SimpleDateFormat("dd MMM yyyy");
		String d = "29 Mar 2018";
		System.out.println(s.parse(d));
		
	}

}
