import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author JX.Wu
 * @date 2018年7月25日
 */
public class Test {

	public static void main(String[] args) throws Exception {
		
		for(int i=1; i<=100;i++) {
			System.out.print("C"+UUID.randomUUID().toString().substring(0, 6).toUpperCase()+"\t");
			if(i % 10 == 0)
			System.out.println();
		}
		
	}

}
