package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService;

import java.util.List;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;

public interface FoodItemService {
	public int addFoodItem(FoodItem foodItem);

	public int editFoodItem(FoodItem foodItem);

	public int deleteFoodItem(int foodId);

	public List<FoodItem> getFoodItem();

}
