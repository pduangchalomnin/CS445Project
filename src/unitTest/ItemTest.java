package unitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.Catagory;
import entity.Food;
import entity.FoodImp;
import entity.Item;

public class ItemTest {

	private static final double DELTA = 1e-15;
	
	Food food;
	Item item;
	@Before
	public void createItem(){
		food = new FoodImp("Food1", 1.99, 3, new Catagory[]{new Catagory("Cat1")});
		item = new Item(food,2);
	}
	
	@Test
	public void testGetCount() {
		assertEquals(2, item.getCount());
	}
	
	@Test
	public void testGetFood() {
		assertEquals(food, item.getFood());
	}
	
	@Test
	public void testGetAmount() {
		assertEquals(1.99*2, item.getAmount(),DELTA);
	}
	
	@Test
	public void testGetMinimumOrder() {
		assertEquals(3, item.getItemMinimumOrder());
	}
}
