package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="foodItems")
public class FoodItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int foodId;
	String foodName;
	int foodPrice;
	String image;
	String categoryName;
	String cuisineName;
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCuisineName() {
		return cuisineName;
	}
	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}
	@Override
	public String toString() {
		return "FoodItemEntity [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice="
				+ foodPrice + ", image=" + image + ", categoryName=" + categoryName + ", cuisineName=" + cuisineName
				+ "]";
	}
	
	
	
	
	
	
}
