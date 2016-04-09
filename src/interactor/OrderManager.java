package interactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.Address;
import entity.Customer;
import entity.Item;
import entity.Order;

public class OrderManager implements OrderBoundaryInterface {

	public static OrderBoundaryInterface instance;
	private List<Order> orders;
	
	private OrderManager() {
		orders = new ArrayList<Order>();
		
	}
	
	public static OrderBoundaryInterface getInstance(){
		if(instance==null) {
			instance = new OrderManager();
		}
		return instance;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public List<Order> getOrdersByDate(String delivery_date) throws RuntimeException {
		List<Order> output = new ArrayList<Order>();
		int year = Integer.parseInt(delivery_date.substring(0, 3));
		int month = Integer.parseInt(delivery_date.substring(4,5));
		int day = Integer.parseInt(delivery_date.substring(6,7));
		if(delivery_date.length() != 8 || month < 1 || month > 12 || day < 1 || day > 31 || year < 0){
			throw new RuntimeException();
		}
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
			Order tmpOrder = it.next();
			if(tmpOrder.getDeliveryDate().equals(delivery_date)) {
				output.add(tmpOrder);
			}
		}
		return output;
	}

	@Override
	public int createOrder(String delivery_date, Address delivery_address, Customer personal_info, String note,
			Item[] order_details) throws RuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order getOrderById(int id) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancleOrder(int id) throws RuntimeException {
		// TODO Auto-generated method stub

	}

}
