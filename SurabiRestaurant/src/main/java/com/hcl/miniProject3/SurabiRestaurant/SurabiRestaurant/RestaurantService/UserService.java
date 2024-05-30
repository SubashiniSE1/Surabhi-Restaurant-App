package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService;

import java.util.List;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.UserEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.Users;

public interface UserService {

	public int login(Users user) throws Exception;

	public List<Users> getUsers();

	public String addUser(Users users);

	public String editUser(Users users);

	public String deleteUser(String userName);

	public void addUsername(String userName);

}
