package interactor;

import entity.Food;

public interface AdminBoundaryInterface {
	public int addFoodToMenu(Food food) throws RuntimeException;
	public void editFoodInMenu(int id,double price_per_person) throws RuntimeException;
	public double getSurcharge() throws RuntimeException;
	public void changeSurcharge(double surcharge) throws RuntimeException;
}
