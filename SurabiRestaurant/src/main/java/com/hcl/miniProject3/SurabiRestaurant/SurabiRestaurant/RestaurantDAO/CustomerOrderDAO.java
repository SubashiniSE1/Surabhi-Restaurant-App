package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO;

import java.util.List;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodOrder;

public interface CustomerOrderDAO {

	public int orderFoodItem(FoodOrder foodOrder);

	public List<FoodOrder> getFoodItemtodayMyBill(String Username);

	public List<FoodOrder> getFoodItemtodayBill();

	public List<FoodOrder> getFoodItemMonthlyBill();

	public String getUsername();

	public int deleteFoodOrdered(FoodOrder foodOrder);
}
