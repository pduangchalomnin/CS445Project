package entity;

import java.util.List;

public interface Order {

	public void changeStatus(Status status);
	public double getSurcharge();
	public String getCustomerEmail();
	public String getStatus();
	public double getTotalAmount();
	public String getDeliveryDate();
	public String getOrderDate();
	public int getID();
	public Customer getCustomer();
	public String getNote();
	public List<Item> listItem();
	public Address geteDeliveryAddress();
	public boolean isMatch(String keyword);
}
