package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantDAO;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.RestaurantService.UserServiceImpl;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.DataEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.FoodItemEntity;
//import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.CustomerOrderEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.entity.FoodOrderEntity;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodItem;
import com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant.model.FoodOrder;

@Repository(value = "CustomerOrderDAO")
public class CustomerOrderDAOImpl  implements CustomerOrderDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public int orderFoodItem(FoodOrder foodOrder) {
		boolean foodStatus= true;
		System.out.println(" food order in Dao");
		
		String query = "select c from FoodOrderEntity c where customerName=?1";
		Query query1 = entityManager.createQuery(query);
		query1.setParameter(1, foodOrder.getUserName());
		System.out.println(query + " in DAO");
		
		List<FoodOrderEntity> foodOrders= query1.getResultList();
		System.out.println("resut obtained from db");
		if(!(foodOrders.isEmpty())){
			for(FoodOrderEntity foodOrderentity : foodOrders) {
				if(foodOrder.getFoodId() == foodOrderentity.getFoodId()) {
					String updatequery = "update FoodOrderEntity set quantity = ?1 where orderId =?2";
					Query query2 = entityManager.createQuery(updatequery);	
					query2.setParameter(1, foodOrderentity.getQuantity()+1);
					query2.setParameter(2,foodOrderentity.getOrderId());
					foodStatus= false;
					return query2.executeUpdate();
				}
			}
		}
	if(foodStatus) {
			FoodOrderEntity foodEnt = new FoodOrderEntity();
			foodEnt.setFoodId(foodOrder.getFoodId());
			foodEnt.setFoodName(foodOrder.getFoodName());
			foodEnt.setPrice(foodOrder.getPrice());
			foodEnt.setQuantity(foodOrder.getQuantity());
			LocalDate dateObj = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String date = dateObj.format(formatter);
	        foodEnt.setDate(date); //setting date
	        Format f = new SimpleDateFormat("HH.mm.ss");
	        String strResult = f.format(new Date());
	        foodEnt.setTime(strResult);
	        foodEnt.setQuantity(1);
			foodEnt.setCustomerName(foodOrder.getUserName());
			entityManager.persist(foodEnt);
			
		}
		return 0;
		
		
	}
	@Override
	public List<FoodOrder>  getFoodItemtodayMyBill(String Username) {
		System.out.println(" food order in Dao");
		String query = "select c from FoodOrderEntity c where customerName=?1";
		Query query1 = entityManager.createQuery(query);
		System.out.println("query create");
		
		query1.setParameter(1,Username);
//		System.out.println(query + " in DAO");
		
		List<FoodOrderEntity> foodOrders= query1.getResultList();

		LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = dateObj.format(formatter);
	        System.out.println(date);
	        System.out.println(foodOrders.size());
		List<FoodOrder> foodOrderList = new ArrayList<FoodOrder>();
		for(FoodOrderEntity foodOrder:foodOrders ) {
			System.out.println(foodOrder.getDate());
		      if(date.equals(foodOrder.getDate())) {
		    	  System.out.println("same day");
		    	  FoodOrder foodItem = new FoodOrder();
		    	  foodItem.setUserName(Username);
					foodItem.setFoodId(foodOrder.getFoodId());
					foodItem.setFoodName(foodOrder.getFoodName());
					foodItem.setPrice(foodOrder.getPrice());
					foodItem.setQuantity(foodOrder.getQuantity());
					foodItem.setOrderId(foodOrder.getOrderId());
					
					foodItem.setDate(foodOrder.getDate());
					foodOrderList.add(foodItem);
		      }
		
		
		}
		return foodOrderList;
		
}
	@Override
	public List<FoodOrder>  getFoodItemMonthlyBill() {
		System.out.println(" food order in Dao");
		String query = "select c from FoodOrderEntity c ";
		Query query1 = entityManager.createQuery(query);
		
//		System.out.println(query + " in DAO");
		
		List<FoodOrderEntity> foodOrders= query1.getResultList();

		LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = dateObj.format(formatter);
        
		String[] currentdatar = date.split("-");
		Integer currentmonth = Integer.parseInt(currentdatar[1]);
	        System.out.println(foodOrders.size());
		List<FoodOrder> foodOrderList = new ArrayList<FoodOrder>();
		for(FoodOrderEntity foodOrder:foodOrders ) {
			String dat = foodOrder.getDate();
			String[] datarr = dat.split("-");
			Integer DBmonthvalue = Integer.parseInt(datarr[1]);
			System.out.println(foodOrder.getDate());
			
		      if(DBmonthvalue==currentmonth) {
		    	  
		    	  System.out.println("same day");
		    	  FoodOrder foodItem = new FoodOrder();
		    	  foodItem.setUserName(foodOrder.getCustomerName());
					foodItem.setFoodId(foodOrder.getFoodId());
					foodItem.setFoodName(foodOrder.getFoodName());
					foodItem.setPrice(foodOrder.getPrice());
					foodItem.setQuantity(foodOrder.getQuantity());
					foodItem.setOrderId(foodOrder.getOrderId());
					
					foodItem.setDate(foodOrder.getDate());
					foodOrderList.add(foodItem);
		      }
		
		
		}
		return foodOrderList;
		
}

@Override
public List<FoodOrder> getFoodItemtodayBill() {
	System.out.println(" food order in Dao");
	String query = "select c from FoodOrderEntity c ";
	Query query1 = entityManager.createQuery(query);
	System.out.println("query create");

	List<FoodOrderEntity> foodOrders = query1.getResultList();

	LocalDate dateObj = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String date = dateObj.format(formatter);
	System.out.println(date);
	System.out.println(foodOrders.size());
	List<FoodOrder> foodOrderList = new ArrayList<FoodOrder>();
	for (FoodOrderEntity foodOrder : foodOrders) {
		System.out.println(foodOrder.getDate());
		System.out.println("today date obtained");
		if (date.equals(foodOrder.getDate())) {
			System.out.println("same day");
			FoodOrder foodItem = new FoodOrder();
			foodItem.setUserName(foodOrder.getCustomerName());
			foodItem.setFoodId(foodOrder.getFoodId());
			foodItem.setFoodName(foodOrder.getFoodName());
			foodItem.setPrice(foodOrder.getPrice());
			foodItem.setQuantity(foodOrder.getQuantity());
			foodItem.setOrderId(foodOrder.getOrderId());

			foodItem.setDate(foodOrder.getDate());
			foodOrderList.add(foodItem);
		}

	}
	return foodOrderList;

}
@Override
public String getUsername() {
	DataEntity da = entityManager.find(DataEntity.class, 1);
	
	return da.getUserName();
}
@Override
public int deleteFoodOrdered(FoodOrder foodOrder) {
	String query = "delete from FoodOrderEntity where orderId=?1";
	
	Query query1 = entityManager.createQuery(query);
	query1.setParameter(1, foodOrder.getOrderId());
	return query1.executeUpdate();
}
}

