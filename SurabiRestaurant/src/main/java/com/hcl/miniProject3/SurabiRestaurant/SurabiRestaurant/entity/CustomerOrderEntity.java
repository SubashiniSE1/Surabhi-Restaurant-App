//package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//@Entity
//@Table(name = "customerorder")
//public class CustomerOrderEntity {
//	
//	@Id
//	private String customerName;
//	private Integer totalPrice;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="customer_name")
//	private List<FoodOrderEntity> foodOrderEntity;
//	public String getCustomerName() {
//		return customerName;
//	}
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//	public Integer getTotalPrice() {
//		return totalPrice;
//	}
//	public void setTotalPrice(Integer totalPrice) {
//		this.totalPrice = totalPrice;
//	}
//	public List<FoodOrderEntity> getFoodOrderEntity() {
//		return foodOrderEntity;
//	}
//	public void setFoodOrderEntity(List<FoodOrderEntity> foodOrderEntity) {
//		this.foodOrderEntity = foodOrderEntity;
//	}
//	
//	
//	
//
//}
