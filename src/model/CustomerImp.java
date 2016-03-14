package model;

public class CustomerImp implements Customer {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	public CustomerImp(String firstName,String lastName,String phoneNumber,String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public boolean isMatch(String keyword) {
		//According to requirement, first name will not be search
		if(this.lastName.matches(keyword)
				|| this.email.equals(keyword)
				|| this.phoneNumber.equals(keyword))
			return true;
		return false;
	}

}
