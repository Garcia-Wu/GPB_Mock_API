import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author JX.Wu
 * @date 2018年7月25日
 */
public class Test {

	public static void main(String[] args) throws Exception {
		TestResponse testResponse = new TestResponse();
		testResponse.setCode("1000");
		testResponse.setId(340);
		testResponse.setName("yes");

		TestResponse.AccountBean account = new TestResponse.AccountBean();
		account.setId("a1");
		account.setAccountName("aName");

		TestResponse.PortfolioBean portfolio1 = new TestResponse.PortfolioBean();
		portfolio1.setId("p1");
		portfolio1.setPortfolioName("hhh");
		TestResponse.PortfolioBean portfolio2 = new TestResponse.PortfolioBean();
		portfolio2.setId("p2");
		List<TestResponse.PortfolioBean> portfolioBeans = new ArrayList<>();
		portfolioBeans.add(portfolio1);
		portfolioBeans.add(portfolio2);

		testResponse.setAccount(account);
		testResponse.setPortfolioBeans(portfolioBeans);

		Test test = new Test();
//		System.out.println(testResponse);
//		System.out.println();
//		System.out.println();
//		System.out.println();
		test.printBean(testResponse);

//		System.out.println(TestResponse.class.getSimpleName());
//		System.out.println(TestResponse.AccountBean.class);
	}

	public void printBean(Object object) {
		try {
			Class clazz = object.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
//				Method method = clazz.getMethod(makeGetMethodName(field));
//				Object filedValue = method.invoke(object);
				field.setAccessible(true);
				Object filedValue = field.get(object);
				assertTrue("[" + clazz.getSimpleName() + "] Field ["+field.getName()+"] value is null!", filedValue != null);
				
				if (filedValue instanceof Collection) {
					for (Object o : (Collection) filedValue) {
//						System.out.println("object:"+o);
						printBean(o);
					}
				}
				
				if(filedValue.getClass().toString().contains(clazz.getSimpleName()+"$")) {
					printBean(filedValue);
				}
//				System.out.println("field name:"+ field.getName() +"      value:"+filedValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String makeGetMethodName(Field field) {
		String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
		return getMethodName;
	}

}
