package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO.CustomerOrderDAO;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodOrder;

@Service(value = "customerOrderService")
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDAO customerOrderDAO;

	@Override
	public void orderFoodItem(FoodOrder foodOrder) {
		System.out.println("addfood in order service layer");
		customerOrderDAO.orderFoodItem(foodOrder);
	}

	@Override
	public List<FoodOrder> getFoodItemtodayMyBill(String Username) {
		return customerOrderDAO.getFoodItemtodayMyBill(Username);
	}

	@Override
	public List<FoodOrder> getFoodItemMonthlyBill() {
		return customerOrderDAO.getFoodItemMonthlyBill();
	}

	@Override
	public List<FoodOrder> getFoodItemtodayBill() {
		return customerOrderDAO.getFoodItemtodayBill();
	}

	@Override
	public String getUsername() {
		return customerOrderDAO.getUsername();
	}

	@Override
	public String deleteFoodOrder(FoodOrder foodOrder) {
		int resp = customerOrderDAO.deleteFoodOrdered(foodOrder);

		return null;
	}

}
