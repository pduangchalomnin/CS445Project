package entity;

public interface Customer {
	public String getFirstName();
	public String getLastName();
	public String getEmail();
	public String getPhoneNumber();
	public boolean isMatch(String keyword);
}
