package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO;

import java.util.List;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;

public interface FoodItemDAO {
	public int addFoodItems(FoodItem foodItem);

	public int editFoodItems(FoodItem foodItem);

	public int deleteFoodItems(int foodId);

	public List<FoodItem> getFoodItems();

}
