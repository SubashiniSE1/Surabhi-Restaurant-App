package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.DataEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.FoodItemEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.UserEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.Users;



@Repository(value = "userDaoImpl")
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Users> getUser() {
		String query = "select ue from UserEntity ue";
		
		List<Users> userList = new ArrayList<Users>();
		Query query1 = entityManager.createQuery(query);
		List<UserEntity> userEntityList = query1.getResultList();
		for (UserEntity userent : userEntityList) {
			Users user = new Users();
			user.setEmail(userent.getEmail());
			user.setFirstName(userent.getFirstName());
			user.setLastName(userent.getLastName());
			user.setPassword(userent.getPassword());
			user.setPhoneNo(userent.getPhoneNo());
			user.setUserName(userent.getUserName());
			userList.add(user);

		}

		return userList;
	}

	@Override
	public int addUser(Users user) {

		UserEntity ue = new UserEntity();
		ue.setUserName(user.getUserName());
		ue.setPassword(user.getPassword());
		ue.setEmail(user.getEmail());
		ue.setFirstName(user.getFirstName());
		ue.setLastName(user.getLastName());
		ue.setPhoneNo(user.getPhoneNo());
		entityManager.persist(ue);

		System.out.println("persist");
		return 1;
	}

	@Override
	public Users login(Users users) {
		UserEntity ue = entityManager.find(UserEntity.class, users.getUserName());
		if (ue == null) {
			return null;

		} else {
			Users user = new Users();
			user.setUserName(ue.getUserName());
			user.setPassword(ue.getPassword());

			return user;

		}

	}

	String userName;
	String firstName;
	String lastName;
	String email;
	String password;
	String phoneNo;

	@Override
	public int editUser(Users user) {
		// TODO Auto-generated method stub
		String query = " update UserEntity set firstName=?1 ,lastName=?2,email=?3,password=?4,phoneNo=?5 where userName=?6";
		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, user.getFirstName());
		query1.setParameter(2, user.getLastName());
		query1.setParameter(3, user.getEmail());
		query1.setParameter(4, user.getPassword());
		query1.setParameter(5, user.getPhoneNo());
		query1.setParameter(6, user.getUserName());
		System.out.println(query1);
		return query1.executeUpdate();

	}

	@Override
	public int deleteUser(String userName) {
		String query = "delete from UserEntity where userName=?1";

		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, userName);
		return query1.executeUpdate();

	}

	@Override
	public void addUsername(String userName) {
		DataEntity da = entityManager.find(DataEntity.class, 1);
		da.setUserName(userName);
		System.out.println(da.getUserName());
		System.out.println(da.getId());
		String sql = "update DataEntity set userName=?1 where id=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, userName);
		int id = 1;
		query.setParameter(2, id);
		query.executeUpdate();
	}

}


