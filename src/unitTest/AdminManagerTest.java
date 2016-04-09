package unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Catagory;
import entity.Food;
import entity.FoodImp;
import entity.Menu;
import entity.MenuImp;
import interactor.AdminBoundaryInterface;
import interactor.AdminManager;

public class AdminManagerTest {
	
	AdminBoundaryInterface admin = AdminManager.getInstance();
	Food food = new FoodImp("Name",1.99,1,new Catagory[]{});
	Menu menu = MenuImp.getInstance();
	boolean hasToDelete;
	int foodId;
	private static final double DELTA = 1e-15;
	
	@Before
	public void setup() {
		foodId = food.getId();
		hasToDelete = false;
	}
	
	@Test(expected = RuntimeException.class)
	public void testAddFoodNameIsEmpty() {
		Food invalidFood = new FoodImp("",1.99,2,new Catagory[]{});
		admin.addFoodToMenu(invalidFood);
	}
	
	@Test(expected = RuntimeException.class)
	public void testAddFoodPriceIsLessThanZero() {
		Food invalidFood = new FoodImp("Name",-0.1,2,new Catagory[]{});
		admin.addFoodToMenu(invalidFood);
	}
	
	@Test(expected = RuntimeException.class)
	public void testAddFoodMinimumIsLessThanOne() {
		Food invalidFood = new FoodImp("Name",1.99,0,new Catagory[]{});
		admin.addFoodToMenu(invalidFood);
	}
	
	@Test
	public void testAddFoodValidData(){
		hasToDelete = true;
		int returnValue = admin.addFoodToMenu(food);
		assertEquals(foodId, returnValue);
	}
	
	@Test(expected = RuntimeException.class)
	public void testEditFoodNotFoundID(){
		admin.editFoodInMenu(99999, 9.99);
	}
	
	@Test(expected = RuntimeException.class)
	public void testEditFoodInvalidPrice(){
		hasToDelete = true;
		admin.addFoodToMenu(food);
		admin.editFoodInMenu(foodId, -0.01);
	}
	
	@Test
	public void testEditFoodValidData(){
		hasToDelete = true;
		admin.addFoodToMenu(food);
		admin.editFoodInMenu(foodId, 1.00);
		assertEquals(1.00, food.getPrice_per_person(),DELTA);
	}

	@Test(expected = RuntimeException.class)
	public void testChangeSurchargeInvalidPrice(){
		admin.changeSurcharge(-0.1);
	}
	
	@Test
	public void testChangeSurchargeValidData(){
		admin.changeSurcharge(5.99);
		assertEquals(5.99, menu.getSurcharge(),DELTA);
	}
	
	@After
	public void clearMenu(){
		if(hasToDelete){
			menu.deleteItem(foodId);
		}
	}
}
