package entity;

public class Address {
	private String houseNumber;
	private String streetName;
	private String city;
	private String state;
	private String zipcode;
	
	public Address(String houseNumber, String streetName,String city, String state, String zipcode){
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public String toString(){
		return houseNumber + " " + streetName + ", " + city + " " + state + " " + zipcode;
	}
	
	public boolean isMatch(String keyword){
		if(this.toString().matches("(.*)"+keyword+"(.*)"))
			return true;
		return false;
	}
}
