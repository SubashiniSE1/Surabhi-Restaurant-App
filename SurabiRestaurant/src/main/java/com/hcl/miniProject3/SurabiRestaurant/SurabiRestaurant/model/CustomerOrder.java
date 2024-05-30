package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model;

import javax.persistence.CascadeType;


import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.FoodOrderEntity;

public class CustomerOrder {
	private String customerName;
	private Integer totalPrice;
	
	private FoodOrder foodOrder;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

}
