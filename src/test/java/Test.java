import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

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
//		account.setAccountName("aName");

		TestResponse.PortfolioBean portfolio1 = new TestResponse.PortfolioBean();
		portfolio1.setId("p1");
		portfolio1.setPortfolioName("hhh");
		TestResponse.PortfolioBean portfolio2 = new TestResponse.PortfolioBean();
//		portfolio2.setId("p2");
//		portfolio2.setPortfolioName("yyy");
		List<TestResponse.PortfolioBean> portfolioBeans = new ArrayList<>();
		portfolioBeans.add(portfolio1);
		portfolioBeans.add(portfolio2);

		testResponse.setAccount(account);
		testResponse.setPortfolioBeans(portfolioBeans);
		
		testResponse.setName("张三");

		Test test = new Test();
//		System.out.println(testResponse);
//		System.out.println();
//		System.out.println();
//		System.out.println();
		test.printBean(testResponse);
		
		
		System.out.println("第一种："+Assert.class);
		Class clazz = Test.class;
		Object test2 = clazz.newInstance();
		System.out.println("class:"+test2);

		TestEnum testEnum = TestEnum.valueOf("TEST1");
		System.out.println(testEnum.getName()+" : "+testEnum.getPassword());	
		if(testEnum.equals(TestEnum.TEST1)){
			System.out.println("Is Test1");
		}
		switch (testEnum) {
		case TEST1:
			System.out.println("Is Test1");
			break;

		default:
			System.out.println("Is Test2");
			break;
		}
//		System.out.println(TestResponse.class.getSimpleName());
//		System.out.println(TestResponse.AccountBean.class);
//		System.out.println(DateFormatUtils.format(new Date(1533882667*1000L), "yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public String toString() {
		return "HAHAHA";
	}

	public void printBean(Object object) {
		String message = "";
		checkPropertie(object, message);
		if(!message.equals("")) {
			System.out.println("Properties verify not pass! "+message);
		}
	}
	
	public void checkPropertie(Object object, String message) {
		try {
			Class clazz = object.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				Autowired annotation = field.getAnnotation(Autowired.class);
				if(annotation != null) {
					
				}
				
//				Method method = clazz.getMethod(makeGetMethodName(field));
//				Object filedValue = method.invoke(object);
				field.setAccessible(true);
				Object filedValue = field.get(object);
				if(filedValue == null) {
					message += "\n[" + clazz.getSimpleName() + "] Field ["+field.getName()+"] value is null!";
					continue;
				}
//				assertTrue("[" + clazz.getSimpleName() + "] Field ["+field.getName()+"] value is null!", filedValue != null);
				
				if (filedValue instanceof Collection) {
					for (Object o : (Collection) filedValue) {
//						System.out.println("object:"+o);
						checkPropertie(o, message);
					}
				}
				
				if(filedValue.getClass().toString().contains(clazz.getSimpleName()+"$")) {
					checkPropertie(filedValue, message);
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
