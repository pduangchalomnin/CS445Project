package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuImp implements Menu {

	private List<Food> menuList;
	public static Menu menu;
	
	private MenuImp(){
		menuList = new ArrayList<Food>();
	}
	
	
	public static Menu getInstance(){
		if(menu == null)
			menu = new MenuImp();
		return menu;
			
	}
	public List<Food> listMenu() {
		return menuList;
	}

	public int addItem(String name,Double price_per_person,int minimum_order,Catagory catagories[]) {
		Food food = new FoodImp(name,price_per_person,minimum_order,catagories);
		menuList.add(food);
		return food.getId();
	}

	public boolean deleteItem(int id) {
		Iterator<Food> it = menuList.iterator();
		while(it.hasNext()){
			Food tmpFood = it.next();
			if(tmpFood.getId() == id)
			{
				menuList.remove(tmpFood);
				return true;
			}
		}
		return false;
	}

	public List<Food> searchItem(String keyword) {
		List<Food> foodList = new ArrayList<Food>();
		Iterator<Food> it = menuList.iterator();
		while(it.hasNext()){
			Food tmpFood = it.next();
			if(tmpFood.isMatch(keyword))
			{
				menuList.add(tmpFood);
			}
		}
		return foodList;
	}

}
