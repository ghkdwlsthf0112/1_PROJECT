package database.dbObjects;

public class Customer {
	Integer customer_id;
	String customer_email;
	String customer_password;
	String customer_phone_number;
	String customer_name;
	String customer_yn;
	
	public Customer() {
	}
	
	public Customer(
			Integer customer_id,
			String customer_email,
			String customer_password,
			String customer_phone_number,
			String customer_name,
			String customer_yn) {
		this.customer_id = customer_id;
		this.customer_email = customer_email;
		this.customer_password = customer_password;
		this.customer_phone_number = customer_phone_number;
		this.customer_name = customer_name;
		this.customer_yn = customer_yn;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_phone_number() {
		return customer_phone_number;
	}

	public void setCustomer_phone_number(String customer_phone_number) {
		this.customer_phone_number = customer_phone_number;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_yn() {
		return customer_yn;
	}

	public void setCustomer_yn(String customer_yn) {
		this.customer_yn = customer_yn;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s", customer_name,customer_phone_number,customer_email);
	}
	
}
