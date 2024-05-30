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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService.UserService;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.UserEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.Users;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;
	public String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody Users users) {

		System.out.println("User is added");
		String result = userService.addUser(users);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@PostMapping("/login")
	public ResponseEntity<Users> login(@RequestBody Users user) throws Exception {

		System.out.println("login created ");
		System.out.println(user);
		int result = userService.login(user);
		System.out.println(result);
		if (result == 1) {
			System.out.println("login Success ");
			userService.addUsername(user.getUserName());
			Users user1 = new Users();
			user1.setValid("valid");
			ResponseEntity<Users> result1 = new ResponseEntity<Users>(user1, HttpStatus.OK);
			return result1;
		} else {
			Users user1 = new Users();
			user1.setValid("invalid");
			ResponseEntity<Users> result1 = new ResponseEntity<Users>(user1, HttpStatus.OK);
			return result1;

		}

	}

	@PostMapping("/editUser")
	public ResponseEntity<String> editUser(@RequestBody Users users) throws Exception {

		System.out.println("User is added");
		String result = userService.editUser(users);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@DeleteMapping("/deleteUser/{userName}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "userName") String userName) {

		System.out.println("User is added");
		String result = userService.deleteUser(userName);
		ResponseEntity<String> result1 = new ResponseEntity<String>(result, HttpStatus.OK);

		return result1;

	}

	@GetMapping("/userList")
	public ResponseEntity<List<Users>> getUserList() throws Exception {
		try {

			System.out.println("login 2 created ");
			System.out.println();
			List<Users> result = userService.getUsers();
			System.out.println(result);
			if (result != null) {
				System.out.println("Added successfully ");
				System.out.println(result);
				ResponseEntity<List<Users>> result1 = new ResponseEntity<List<Users>>(result, HttpStatus.OK);
				return result1;

			}
		} catch (Exception exception) {
			System.out.println("Adding user falied " + exception.getMessage());
			ResponseStatusException result1 = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
			throw new Exception("Invalid Data", result1);

		}
		return null;
	}

}
