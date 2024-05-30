package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService.CustomerOrderService;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodOrder;

@RestController
@RequestMapping("/foodOrderPage")
@CrossOrigin(origins = "*")
public class CustomerOrderController {
	@Autowired
	UserController userController;
	@Autowired
	private CustomerOrderService customerOrderService;

	@PostMapping("/orderPage")
	public ResponseEntity<String> orderFoodItem(@RequestBody FoodOrder foodOrder) throws Exception {
		try {
			System.out.println(" ordering food controller");
			foodOrder.setUserName(customerOrderService.getUsername());
			System.out.println(customerOrderService.getUsername());
			customerOrderService.orderFoodItem(foodOrder);
			ResponseEntity<String> result1 = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			return result1;

		} catch (Exception exception) {
			System.out.println("Adding food item falied " + exception.getMessage());
			ResponseStatusException result1 = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
			throw new Exception("Invalid Data", result1);

		}
	}

	@PostMapping("/deleteOrderItem")
	public ResponseEntity<String> deleteFoodItem(@RequestBody FoodOrder foodOrder) {
		System.out.println("delee function");
		System.out.println(foodOrder);

		String result = customerOrderService.deleteFoodOrder(foodOrder);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@GetMapping("/todayMyBill")
	public ResponseEntity<List<FoodOrder>> getFoodItemtodayMYBill() {
		String userName = customerOrderService.getUsername();
		System.out.println(userName + " vjevnioevneiu controller");
		List<FoodOrder> fooditem = customerOrderService.getFoodItemtodayMyBill(userName);
		ResponseEntity<List<FoodOrder>> result1 = new ResponseEntity<List<FoodOrder>>(fooditem, HttpStatus.OK);
		return result1;

	}

	@GetMapping("/todayBill/")
	public ResponseEntity<List<FoodOrder>> getFoodItemtodayBill() {

		System.out.println(" vjevnioevneiu controller");
		List<FoodOrder> fooditem = customerOrderService.getFoodItemtodayBill();
		ResponseEntity<List<FoodOrder>> result1 = new ResponseEntity<List<FoodOrder>>(fooditem, HttpStatus.OK);
		return result1;


	}

	@GetMapping("/monthlyBill/")
	public ResponseEntity<List<FoodOrder>> getFoodItemMonthlyBill() {

		List<FoodOrder> fooditem = customerOrderService.getFoodItemMonthlyBill();
		ResponseEntity<List<FoodOrder>> result1 = new ResponseEntity<List<FoodOrder>>(fooditem, HttpStatus.OK);
		return result1;

	}
}
