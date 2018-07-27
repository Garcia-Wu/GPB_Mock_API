import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author  JX.Wu
 * @date  2018年7月25日
 */
public class Test {

	public static void main(String[] args) {
		String s1 = "123,293.98 GBP";
		String s2 = "123,293.98  GBP";
		String s3 = "(123293.98 GBP)*";
		String s4 = "(123293.98  GBP)*";
		String s5 = "8,123,293.98";
		System.out.println(getAmount(s1));
		System.out.println(getAmount(s2));
		System.out.println(getAmount(s3));
		System.out.println(getAmount(s4));
		System.out.println(getAmount(s5));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MMM dd");
		try {
			System.out.println(simpleDateFormat.parse("99991 June 444"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("comp: "+"aa".compareTo("ab"));
	}
	
	public static double getAmount(String amount){
        amount = amount.replace("  ", " ").replace("(", "").replaceAll(",", "");
        if(amount.contains(" ")) {
            amount = amount.substring(0, amount.indexOf(" "));
        }
        return Double.valueOf(amount.trim());
    }
	
}

