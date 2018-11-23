
/**
 * @author  JX.Wu
 * @date  2018年11月23日
 */
public enum TestEnum {
	
	TEST1("yuxuan1","123456"),
	TEST2("yuxuan2","123456");
	
	private String name;
	private String password;
	
	private TestEnum(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}

