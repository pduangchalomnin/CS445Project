package unitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Catagory;
import model.Food;
import model.FoodImp;

public class TestFood {

	Food testFood;
	private static final double DELTA = 1e-15;

	
	@Before
	public void createFood(){
		testFood = new FoodImp("testName", 2.99, 1, new Catagory[]{new Catagory("cat1"),new Catagory("cat2")});
	}
	
	@Test
	public void testGetName() {
		assertEquals("testName", testFood.getName());
	}
	
	@Test
	public void testGetPricePerPerson(){
		assertEquals(2.99, testFood.getPrice_per_person(),DELTA);
	}
	
	 @Test
	 public void testGetMinimumOrder(){
		 assertEquals(1, testFood.getMinimum_order());
	 }
	
	 @Test
	 public void  testGetCatagories(){
		 assertArrayEquals(new Catagory[]{new Catagory("cat1"),new Catagory("cat2")}, testFood.getCatagories());
	 }

}
