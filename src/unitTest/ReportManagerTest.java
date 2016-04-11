package unitTest;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.Address;
import entity.Catagory;
import entity.Customer;
import entity.CustomerImp;
import entity.Food;
import entity.FoodImp;
import entity.Item;
import entity.OrdersList;
import entity.OrdersListImp;
import entity.ReportCode;
import interactor.OrderBoundaryInterface;
import interactor.OrderManager;
import interactor.ReportBoundaryInterface;
import interactor.ReportManager;

public class ReportManagerTest {
	ReportBoundaryInterface reportManager = ReportManager.getInstance();
	OrderBoundaryInterface orderManager = OrderManager.getInstance();
	static OrdersList orders = OrdersListImp.getInstance();
	static Catagory cat[] = new Catagory[]{ new Catagory("Cat1") };
	static Address add = new Address("111", "S State St", "Chicago", "IL", "60616");
	static Food food = new FoodImp("TestManagerFood",1.99,2,cat);
	static List<Item> itemList;
	static int orderId;
	
	@BeforeClass
	public static void setup() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		itemList = new ArrayList<Item>();
		itemList.add(new Item(food,2));
		Customer customer1 = new CustomerImp("John", "Doe", "312-333-4444", "john@email.com");
		orderId = orders.createOrder(dateFormat.format(date), add, customer1, "This is 1st order", itemList);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 1); 
		Date tomorrow = cal.getTime();
		Customer customer2 = new CustomerImp("Jane", "Roe", "312-333-4444", "jane@email.com");
		orderId = orders.createOrder(dateFormat.format(tomorrow), add, customer2, "This is 2nd order", itemList);
		
		date = new Date();
		cal.setTime(date);
		while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
		} 
		Date saturday = cal.getTime();
		Customer customer3 = new CustomerImp("Bob", "Smith", "312-333-4444", "bob@email.com");
		orderId = orders.createOrder(dateFormat.format(saturday), add, customer3, "This is 3nd order", itemList);
	}

	@Test
	public void testGetReportType() {
		ReportCode[] reportType = reportManager.getReportType();
		assertEquals(801,reportType[0].getCode());
		assertEquals(802,reportType[1].getCode());
		assertEquals(803,reportType[2].getCode());
		assertEquals(804,reportType[3].getCode());
		
		assertEquals("Orders to deliver today",reportType[0].getName());
		assertEquals("Orders to deliver tomorrow",reportType[1].getName());
		assertEquals("Revenue report",reportType[2].getName());
		assertEquals("Orders delivery report",reportType[3].getName());
	}
	
	@Test
	public void testGetDeliveryToday() {
		assertEquals(1, reportManager.getDeliveryToday().size());
	}
	
	@Test
	public void testGetDeliveryTomorrow() {
		assertEquals(1, reportManager.getDeliveryTomorrow().size());
	}
	
	@Test
	public void testGetDeliveryListTomorrowAndAfter() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 1); 
		Date tomorrow = cal.getTime();
		
		assertEquals(2, reportManager.getDeliveryList(dateFormat.format(tomorrow), "").size());
	}

	@Test
	public void testGetDeliveryListBeforeToday() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		assertEquals(0, reportManager.getDeliveryList("", dateFormat.format(date)).size());
	}
	
	@Test
	public void testGetDeliveryListBetweenTodayAndTomorrow() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 1); 
		Date tomorrow = cal.getTime();
		
		assertEquals(2, reportManager.getDeliveryList(dateFormat.format(date), dateFormat.format(tomorrow)).size());
	}
}
