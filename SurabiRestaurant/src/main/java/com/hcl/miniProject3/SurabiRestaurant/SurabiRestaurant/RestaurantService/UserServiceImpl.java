package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO.UserDAO;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.UserEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userdao;

	@Override
	public int login(Users user) throws Exception {
		
		System.out.println("calling dao");
	    Users users = userdao.login(user);
		System.out.println("username = "+user.getUserName());
		System.out.println(users);
	//	int counter = 0;
		
		if(users==null){
			System.out.println("No user Found");
//			throw new Exception("InValid userName and Password");
			return 0;
			
		}
			if(user.getUserName().equals(users.getUserName()) && user.getPassword().equals(users.getPassword())) {
				
				return 1;
			
	}
		
		else {
//			throw new Exception("InValid userName and Password ");
			return 0;
			//return -1;
		}
		
		
	}

	@Override
	public List<Users> getUsers() {
		return userdao.getUser();
		
	}

	@Override
	public String deleteUser(String userName) {
	int resp=	 userdao.deleteUser(userName);
			
			
		return null;
	}
	@Override
	public String editUser(Users user) {
		 userdao.editUser(user);
			
			
		return null;
	}

	@Override
	public String addUser(Users users) {
		
		userdao.addUser(users);
		
		return null;
	}

	@Override
	public void addUsername(String userName) {
		userdao.addUsername(userName);
	}

	


	
}
