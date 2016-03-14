package model;

public abstract class Food {
	
	static protected int idCounter = 0;
	protected int id;
	protected String name;
	protected double price_per_person;
	protected int minimum_order;
	protected Catagory catagories[];
	protected int create_date;
	protected int last_modified_date;
	
	public abstract void updateDeatail(String name,Double price_per_person,int minimum_order,Catagory catagories[]);
	public abstract void updateName(String name);
	public abstract  void updatePrice(double pricePerPerson);
	public abstract void updateMinimumOrder(int minimum);
	public abstract void updateCatagories(Catagory catagories[]);
	public abstract boolean isMatch(String keyword);
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice_per_person() {
		return price_per_person;
	}

	public int getMinimum_order() {
		return minimum_order;
	}

	public Catagory[] getCatagories() {
		return catagories;
	}

	public int getCreate_date() {
		return create_date;
	}

	public int getLast_modified_date() {
		return last_modified_date;
	}
	
}
