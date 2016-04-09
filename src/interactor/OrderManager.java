package interactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.Address;
import entity.Customer;
import entity.Food;
import entity.Item;
import entity.MenuImp;
import entity.NullOrder;
import entity.Order;
import entity.OrderImp;
import entity.Status;

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
		validateDateTime(delivery_date);
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
			Order tmpOrder = it.next();
			if(tmpOrder.getDeliveryDate().equals(delivery_date)) {
				output.add(tmpOrder);
			}
		}
		return output;
	}

		private void validateDateTime(String delivery_date) throws RuntimeException {
			int year = Integer.parseInt(delivery_date.substring(0, 3));
			int month = Integer.parseInt(delivery_date.substring(4,5));
			int day = Integer.parseInt(delivery_date.substring(6,7));
			if(delivery_date.length() != 8 || month < 1 || month > 12 || day < 1 || day > 31 || year < 0){
				throw new RuntimeException();
			}
		}
		

	public int createOrder(String delivery_date, Address delivery_address, Customer personal_info, String note,
			List<Item> order_details) throws RuntimeException {
		validateDateTime(delivery_date);
		validatePersonalInfo(personal_info);
		validateDeliveryAddress(delivery_address);
		validateItems(order_details);
		Order order = new OrderImp(personal_info, delivery_date, note, order_details, delivery_address, MenuImp.getInstance().getSurcharge());
		orders.add(order);
		return order.getId();
	}
	
		private void validateDeliveryAddress(Address delivery_address) throws RuntimeException {
			if(delivery_address.getHouseNumber().length() == 0
					|| delivery_address.getStreetName().length() == 0
					|| delivery_address.getCity().length() == 0
					|| delivery_address.getState().length() == 0
					|| delivery_address.getZipcode().length() == 0) {
				throw new RuntimeException();
			}
		}
		
		private void validatePersonalInfo(Customer personal_info) throws RuntimeException {
			String email_regex_patern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if(personal_info.getFirstName().length() == 0
					|| personal_info.getLastName().length() == 0
					|| personal_info.getEmail().matches(email_regex_patern)
					|| personal_info.getPhoneNumber().length() == 0) {
				throw new RuntimeException();
			}
		}
		
		private void validateItems(List<Item> order_details) throws RuntimeException{
			if(order_details.size() < 1) {
				throw new RuntimeException();
			}
			Iterator<Item> it = order_details.iterator();
			while(it.hasNext()) {
				Item item = it.next();
				Food food = item.getFood();
				if(item.getCount() < item.getItemMinimumOrder()
						|| food.getName().isEmpty()
						|| food.getPrice_per_person() < 0.00
						|| food.getMinimum_order() < 1) {
					throw new RuntimeException();
				}
			}
		}

	public Order getOrderById(int id) {
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
			Order order = it.next();
			if(order.getId() == id) {
				return order;
			}
		}
		return NullOrder.getinstance();
	}

	public void cancleOrder(int id) throws RuntimeException {
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
			Order order = it.next();
			if(order.getId() == id) {
				order.changeStatus(Status.CANCELED);
				return;
			}
		}
		throw new RuntimeException();
	}

}
