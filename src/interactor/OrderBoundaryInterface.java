package interactor;

import java.util.List;

import entity.Address;
import entity.Customer;
import entity.Item;
import entity.Order;

public interface OrderBoundaryInterface {

	public List<Order> getOrders();
	public List<Order> getOrdersByDate(String delivery_date) throws RuntimeException;
	public int createOrder(String delivery_date
			,Address delivery_address
			,Customer personal_info
			,String note
			,Item[] order_details) throws RuntimeException;
	public Order getOrderById(int id) throws RuntimeException;
	public void cancleOrder(int id)throws RuntimeException;
}
