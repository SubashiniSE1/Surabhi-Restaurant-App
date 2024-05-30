package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService;

import java.util.List;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodOrder;

public interface CustomerOrderService {

	public void orderFoodItem(FoodOrder foodOrder);

	public List<FoodOrder> getFoodItemtodayMyBill(String Username);

	public List<FoodOrder> getFoodItemMonthlyBill();

	public List<FoodOrder> getFoodItemtodayBill();

	public String getUsername();

	public String deleteFoodOrder(FoodOrder foodOrder);
}
