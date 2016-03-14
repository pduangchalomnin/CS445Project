package model;

import java.util.List;

public interface Menu {
	public List<Food> listMenu();
	public int addItem(String name,Double price_per_person,int minimum_order,Catagory catagories[]);
	public boolean deleteItem(int id);
	public List<Food> searchItem(String keyword);

}
