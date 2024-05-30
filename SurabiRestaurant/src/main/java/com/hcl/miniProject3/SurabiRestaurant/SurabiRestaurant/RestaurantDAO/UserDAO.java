package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.UserEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.Users;

public interface UserDAO {

	public int addUser(Users user);

	public int editUser(Users user);

	public List<Users> getUser();

	public Users login(Users users);

	public int deleteUser(String userName);

	public void addUsername(String userName);

}
