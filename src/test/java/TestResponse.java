import java.util.List;

/**
 * @author  JX.Wu
 * @date  2018年8月31日
 */
public class TestResponse {
	
	@MyTest(name = "haha")
	private String code;
	
	private String name;
	private Integer id;
	private AccountBean account;
	private List<PortfolioBean> portfolioBeans;
	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public AccountBean getAccount() {
		return account;
	}


	public void setAccount(AccountBean account) {
		this.account = account;
	}


	public List<PortfolioBean> getPortfolioBeans() {
		return portfolioBeans;
	}


	public void setPortfolioBeans(List<PortfolioBean> portfolioBeans) {
		this.portfolioBeans = portfolioBeans;
	}


	public static class AccountBean{
		private String id;
		private String accountName;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		@Override
		public String toString() {
			return "AccountBean [id=" + id + ", accountName=" + accountName + "]";
		}
		
		
	}
	public static class PortfolioBean{
		private String id;
		private String portfoiloName;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPortfolioName() {
			return portfoiloName;
		}
		public void setPortfolioName(String portfoiloName) {
			this.portfoiloName = portfoiloName;
		}
		@Override
		public String toString() {
			return "PortfolioBean [id=" + id + ", portfoiloName=" + portfoiloName + "]";
		}
		
	}
	
	@Override
	public String toString() {
		return "TestResponse [code=" + code + ", name=" + name + ", id=" + id + ", account=" + account
				+ ", portfolioBeans=" + portfolioBeans + "]";
	}

}

