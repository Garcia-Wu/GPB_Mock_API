import java.text.Collator;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainTest {
	public static void main(String[] args) throws ParseException {
		String[] arrays = new String[] { "gyu", "sdf", "azf", "大同", "收到", "地方", "三等分", "的人", "反对高铁", "泛代数", "上的投入", "和国家" };
		/*设置语言环境*/
		Comparator<Object> com = Collator.getInstance(java.util.Locale.ENGLISH);
		Arrays.sort(arrays, com);
		Collections.sort(new ArrayList<>(), com);
		for (String item:arrays) {
			System.out.print(item+" ");
		}
		
		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd");
//		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println("data: "+simpleDateFormat.parse("2011-Jul-9"));
//		System.out.println("data: "+simpleDateFormat2.format(simpleDateFormat.parse("2011-Jul-9")));
	}
}
