package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.FoodItemEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;

@Repository(value = "foodItemDAO")
public class FoodItemDAOImpl implements FoodItemDAO{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public int addFoodItems(FoodItem foodItem) {

		System.out.println("dao food ietm created ");
		   
		FoodItemEntity foodItemEntity = new FoodItemEntity();
		
		foodItemEntity.setFoodId(foodItem.getFoodId());
		foodItemEntity.setFoodName(foodItem.getFoodName());
		foodItemEntity.setFoodPrice(foodItem.getPrice());
		foodItemEntity.setImage(foodItem.getImage());
		foodItemEntity.setCategoryName(foodItem.getCategoryName());
		foodItemEntity.setCuisineName(foodItem.getCuisineName());
		System.out.println("value setter");
		entityManager.persist(foodItemEntity);
		System.out.println("value persisted ");
		
		return 1;
	}

	@Override
	public int editFoodItems(FoodItem foodItem) {
		
		String image;
		String categoryName;
		String cuisineName;
		String query = "update  FoodItemEntity set foodName=?1 ,foodPrice=?2,image=?3,categoryName=?4,cuisineName=?5 where foodId=?6";
		
		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, foodItem.getFoodName());
		query1.setParameter(2, foodItem.getPrice());
		query1.setParameter(3, foodItem.getImage());
		query1.setParameter(4, foodItem.getCategoryName());
		query1.setParameter(5, foodItem.getCuisineName());
		query1.setParameter(6, foodItem.getFoodId());
		return query1.executeUpdate();
	
		
	}

	@Override
	public int deleteFoodItems(int foodId) { 
		String query = "delete from FoodItemEntity where foodId=?1";
		
		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, foodId);
		return query1.executeUpdate();
		

	}

	@Override
	public List<FoodItem> getFoodItems() {
		String query = "select fe from FoodItemEntity fe";
		List<FoodItem> foodItemlist = new ArrayList<FoodItem>();
		Query query1 = entityManager.createQuery(query);
		List<FoodItemEntity> foodItemEntityList = query1.getResultList();
		for (FoodItemEntity foodent : foodItemEntityList) {
			FoodItem foodItem = new FoodItem();
			foodItem.setFoodId(foodent.getFoodId());
			foodItem.setCategoryName(foodent.getCategoryName());
			foodItem.setCuisineName(foodent.getCuisineName());
			foodItem.setFoodName(foodent.getFoodName());
			foodItem.setPrice(foodent.getFoodPrice());
			foodItem.setImage(foodent.getImage());
			foodItemlist.add(foodItem);
		}

		return foodItemlist;
	}

}
