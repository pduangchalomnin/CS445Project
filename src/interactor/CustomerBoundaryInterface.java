package interactor;

import java.util.List;

import entity.Customer;

public interface CustomerBoundaryInterface {
	
	public List<Customer> getCustomerList();
	public List<Customer> getCustomerByKeyword(String keyword);
	public Customer getCustomerById(int id) throws RuntimeException;
}
