package interactor;

import java.util.List;

import entity.Food;

public interface MenuBoundaryInterface {
	
	public List<Food> getMenu();
	public Food getMenuItem(int id) throws RuntimeException;

}
