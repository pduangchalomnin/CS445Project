package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodImp extends Food {

	public FoodImp(String name,Double price_per_person,int minimum_order,Catagory catagories[]){
		this.id = idCounter++;
		this.name = name;
		this.price_per_person = price_per_person;
		this.minimum_order = minimum_order;
		this.catagories = catagories;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		this.create_date = this.last_modified_date = Integer.valueOf(dateFormat.format(date));
	}
	
	public void updateDeatail(String name,Double price_per_person,int minimum_order,Catagory catagories[]) {
		this.name = name;
		this.price_per_person = price_per_person;
		this.minimum_order = minimum_order;
		this.catagories = catagories;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		this.last_modified_date = Integer.valueOf(dateFormat.format(date));
	}

	public void updateName(String name) {
		this.name = name;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		this.last_modified_date = Integer.valueOf(dateFormat.format(date));
	}

	public void updatePrice_per_person(double pricePerPerson) {
		this.price_per_person = pricePerPerson;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		this.last_modified_date = Integer.valueOf(dateFormat.format(date));
	}

	public void updateMinimumOrder(int minimum) {
		this.minimum_order = minimum;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		this.last_modified_date = Integer.valueOf(dateFormat.format(date));
	}

	public void updateCatagories(Catagory[] catagories) {
		this.catagories = catagories;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		this.last_modified_date = Integer.valueOf(dateFormat.format(date));
	}

	public boolean isMatch(String keyword) {
		if(this.name.matches(keyword))
			return true;
		else if(Integer.toString(id).matches(keyword))
			return true;
		else if(Double.toString(price_per_person).equals(keyword))
			return true;
		else if(Integer.toString(minimum_order).equals(keyword))
			return true;
		else if(Integer.toString(create_date).matches(keyword))
			return true;
		else if(Integer.toString(last_modified_date).matches(keyword))
			return true;
		for(int i=0;i<catagories.length;i++)
		{
			if(catagories[0].toString().matches(keyword))
				return true;
		}
		return false;
	}
}
