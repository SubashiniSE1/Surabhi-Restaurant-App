package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService.FoodItemService;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.Users;

@RestController
@RequestMapping("/foodItemsPage")
@CrossOrigin(origins ="*")
public class FoodItemController<FoodMenu> {
	
	
	@Autowired
	FoodItemService foodItemService;
	
	@PostMapping("/foodPage")
	public  ResponseEntity<String> addFoodMenu(@RequestBody FoodItem foodItem) throws Exception {
		try {
			System.out.println("orderng ============================================== ");
//		System.out.println(foodItem);
		int result = foodItemService.addFoodItem(foodItem);
//		System.out.println(result);
		if(result ==1) {
			System.out.println("Added successfully ");
			ResponseEntity<String> result1 = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			return result1;
		
			
		}
		}catch(Exception exception) {
			System.out.println("Adding food item falied " + exception.getMessage());
			ResponseStatusException result1 = new 
					ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Data");
			throw new Exception("Invalid Data" , result1) ;
			
		}
		return null;
		
		
	}
	
@PostMapping("/editfood")
	public  ResponseEntity<String> editFoodMenu(@RequestBody FoodItem foodItem) throws Exception {
		try {
			
		
		System.out.println("login 2 created ");
		System.out.println(foodItem);
		int result = foodItemService.editFoodItem(foodItem);
		System.out.println(result);
		if(result ==1) {
			System.out.println("Added successfully ");
			ResponseEntity<String> result1 = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			return result1;
		
			}
		}catch(Exception exception) {
			System.out.println("Adding food item falied " + exception.getMessage());
			ResponseStatusException result1 = new 
					ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Data");
			throw new Exception("Invalid Data" , result1) ;
			
		}
		return null;
		}


@PostMapping("/deletefood")
	public  ResponseEntity<String> deleteFoodMenu(@RequestBody FoodItem foodItem) throws Exception {
		try {
			System.out.println("delet 2 created ");
		System.out.println(foodItem.getFoodId());
		int result = foodItemService.deleteFoodItem(foodItem.getFoodId());
		System.out.println(result);
		if(result ==1) {
			System.out.println("Added successfully ");
			ResponseEntity<String> result1 = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			return result1;
		}
		}catch(Exception exception) {
			System.out.println("Adding food item falied " + exception.getMessage());
			ResponseStatusException result1 = new 
					ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Data");
			throw new Exception("Invalid Data" , result1) ;
			
		}
		return null;
		
		
	}


@GetMapping("/foodMenu")
	public  ResponseEntity<List<FoodItem>> getFoodMenu() throws Exception {
		
		try {
			UserController uc = new UserController();
			System.out.println("Getting food items for");
	        System.out.println(uc.getUserName());
	        List<FoodItem> result = foodItemService.getFoodItem();

		if(result !=null) {
		
			System.out.println(result);
			ResponseEntity<List<FoodItem>> result1 = new ResponseEntity<List<FoodItem>>(result,HttpStatus.OK);
			return result1;
		
			
		}
		}catch(Exception exception) {
			System.out.println("Adding food item falied " + exception.getMessage());
			ResponseStatusException result1 = new 
					ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Data");
			throw new Exception("Invalid Data" , result1) ;
			
		}
		return null;
		
		
	}


	@GetMapping("/userName")
	public ResponseEntity<String> getUserName() throws Exception {
		try {
			System.out.println("login 2 created ");
			System.out.println();
			UserController uc = new UserController();
			String Username = uc.getUserName();
			ResponseEntity<String> result1 = new ResponseEntity<String>(Username, HttpStatus.OK);
			return result1;

		} catch (Exception exception) {
			System.out.println("Adding food item falied " + exception.getMessage());
			ResponseStatusException result1 = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
			throw new Exception("Invalid Data", result1);

		}

	}
	

}
