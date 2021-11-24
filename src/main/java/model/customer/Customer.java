package model.customer;

public class Customer {
	private int id;
	private int codeCust;
	private String tel;
	private FullName fullName;
	private String card;
    private String email;
	private Address address;
	private Account account;
	public Customer(int id,int codeCust, String tel, FullName fullName, String card, String email, Address address,
			Account account) {
		super();
		this.id = id;
		this.codeCust = codeCust;
		this.tel = tel;
		this.fullName = fullName;
		this.card = card;
		this.email = email;
		this.address = address;
		this.account = account;
	}
	public Customer(String tel, FullName fullName, String email, Address address, Account account) {
		super();
		this.tel = tel;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.account = account;
	}
	public Customer() {

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodeCust() {
		return codeCust;
	}
	public void setCodeCust(int codeCust) {
		this.codeCust = codeCust;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
    
}
