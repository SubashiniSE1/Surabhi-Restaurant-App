package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO.FoodItemDAO;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;

@Service(value = "foodItemService")
@Transactional
public class FoodItemServiceImpl implements FoodItemService {
	
	@Autowired
	FoodItemDAO foodItemDao;

	@Override
	public int addFoodItem(FoodItem foodItem) {
		System.out.println("service add food created ");
	 return foodItemDao.addFoodItems(foodItem);
		
		
	}
	@Override
	public int editFoodItem(FoodItem foodItem) {
		System.out.println("service add food created ");
		
	 return foodItemDao.editFoodItems(foodItem);
		
		
	}

	@Override
	public int deleteFoodItem(int foodId) {
		
		System.out.println("service add food created ");
	 return foodItemDao.deleteFoodItems(foodId);
		
		
	}

	@Override
	public List<FoodItem> getFoodItem() {

		List<FoodItem> foodItemList = foodItemDao.getFoodItems();
		return foodItemList;

	}
	
	

}
