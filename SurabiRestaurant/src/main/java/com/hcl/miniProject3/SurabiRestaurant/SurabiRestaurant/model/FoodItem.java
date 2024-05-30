package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model;

public class FoodItem {
	
	int foodId;
	String foodName;
//	String foodDesc;
	int price;
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
	 
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
		return "FoodItem [foodId=" + foodId + ", foodName=" + foodName + ",  price="
				+ price + ", image=" + image + ", categoryName=" + categoryName + ", cuisineName=" + cuisineName
				+ "]";
	}
	
	

}
