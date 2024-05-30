create  database SurabiRestaurant;
use  SurabiRestaurant;
show tables;

create table user(
  email varchar(255),
    password varchar(255),
    user_name varchar(255) primary key,
    first_name varchar(255),
    last_name varchar(255),
    phone_no varchar(255)
 );
 
 create table admin(
  email varchar(255),
    password varchar(255),
    user_name varchar(255) primary key,
    first_name varchar(255),
    last_name varchar(255),
    phone_no varchar(255)
 );
 

 drop table food_items;
   create table food_items (                                 
    food_id int auto_increment,
    food_name varchar(255),
    food_price int,
    image varchar(255),
    category_name varchar(255),
    cuisine_name varchar(255),
    primary key(food_id)
    
    );
    
    
    drop table custorder;
    drop table customerorder;
	create table customerorder (                                 
      customer_name varchar(255),
	   total_price int,
      primary key(customer_name)
    );
    drop table foodorders;
    create table foodorders (  
    order_id int auto_increment   primary key,
    food_id int,
    price int,
    food_name varchar(255),
    quantity int,
    date varchar(255),
    time varchar(255),
    customer_name varchar(255)
   
  
    );
  
    insert into customerorder values("suba",0);
    delete from foodorders where order_id = 4;
    insert into foodorders values(4,9,37,"hi",1,"wsw","23-05-12","suba");
    select * from foodorders;
    update foodorders set date = "25-1-11" where order_id = 5;
    desc foodorders;
    select * from customerorder;
   
    
    insert into food_items values(1,"All Together Now",520,"All Together Now.jpg","Appeteasers","Indian");
    update food_items set image="images/All Together Now.jpg" where food_id=1;
     update food_items set image="images/Chicken Butterfly.jpg" where food_id=2;
      update food_items set image="images/chicken wings.jpg" where food_id=3;
       update food_items set image="images/Corn-On-The-Cob.jpg" where food_id=4;
        update food_items set image="images/Red Pepper Dip.jpg" where food_id=5;
         update food_items set image="images/Whole Chicken.jpg" where food_id=6;
          update food_items set image="images/Wing Roulette.jpg" where food_id=7;
	insert into food_items values(2,"Chicken Butterfly",620,"Chicken Butterfly.jpg","Appeteasers","Italian");
    insert into food_items values(3,"chicken wings",500,"chicken wings.jpg","Appeteasers","Italian");
	insert into food_items values(4,"Corn-On-The-Cob",365,"Corn-On-The-Cob.jpg","Appeteasers","Indian");
    insert into food_items values(5,"Red Pepper Dip",440,"Red Pepper Dip.jpg","Appeteasers","Indian");
	insert into food_items values(6,"Whole Chicken",700,"Whole Chicken.jpg","Appeteasers","Indian");  
	insert into food_items values(7,"Wing Roulette",890,"Wing Roulette.jpg","Appeteasers","Indian");
    insert into food_items values(8,"Grilled Chicken Tenders",200,"images/Grilled Chicken Tenders.jpg","Appeteasers","Indian");
    insert into food_items values(9,"chicken-livers-and-portuguese Roll.jpg",820,"images/chicken-livers-and-portuguese Roll.jpg","Appeteasers","Italian");
    insert into food_items values(10,"Chicken Biriyani",350,"images/Chicken Biriyani.jpg","Appeteasers","Indian");
    insert into food_items values(11,"Chicken Butterfly",620,"Chicken Butterfly.jpg","Appeteasers","Italian");
 
 
 create table data(
 id int primary key,
 user_name varchar(255)
 );
 
insert into data values(1,"suba"); 

  select * from foodorders;
  select * from user;
  select * from admin;
  select * from food_items;
  select * from data;