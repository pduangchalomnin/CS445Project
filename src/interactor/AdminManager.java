package interactor;

import entity.Food;
import entity.Menu;
import entity.MenuImp;

public class AdminManager implements AdminBoundaryInterface {
	
	private static AdminBoundaryInterface instance = null;
	private Menu menu = null;
	
	private AdminManager(){
		menu = MenuImp.getInstance();
	}
	
	public static AdminBoundaryInterface getInstance(){
		if(instance == null)
		{
			instance = new AdminManager();
		}
		return instance;
	}

	public int addFoodToMenu(Food food) throws RuntimeException {
		if(food.getName().isEmpty()
			|| food.getPrice_per_person() < 0.00
			|| food.getMinimum_order() < 1) {
			throw new RuntimeException();
		}
		return menu.addItem(food);
	}

	public void editFoodInMenu(int id,double price_per_person) throws RuntimeException {
		Food foodToBeEdited = menu.searchItemById(id);
		if(foodToBeEdited.isNil() || price_per_person < 0.00)
		{
			throw new RuntimeException();
		}
		else
		{
			foodToBeEdited.updatePrice_per_person(price_per_person);
		}
	}

	public double getSurcharge() throws RuntimeException {
		return menu.getSurcharge();
	}

	public void changeSurcharge(double surcharge) throws RuntimeException {
		if(surcharge < 0.00)
			throw new RuntimeException();
		menu.setSurcharge(surcharge);
	}

}
