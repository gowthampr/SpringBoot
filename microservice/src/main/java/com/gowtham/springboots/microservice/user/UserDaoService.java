package com.gowtham.springboots.microservice.user;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {

	static List<User> users = new LinkedList<User>();

	static {

		users.add(new User("Gowtham",1,new Date()));
		users.add(new User("Renu",2,new Date()));
		users.add(new User("Ahana",3,new Date()));

	}

	List<User> findAll(){
		return users;
	}

	User findOne(int id){

		for(User user : users){

			if(user.getId() == id){
				return user;
			}

		}


		return null;
	}


	User save(User user){

		
		try{
			users.add(user);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}

		return user;
	}

	
	User deleteById(int id){
		
		Iterator<User> userlist = users.iterator();
		
		while(userlist.hasNext()){
			
			User user = userlist.next();
			
			if(user.getId() == id){
				
				userlist.remove();
				return user;
			}
			
		}
		
		return null;
	}
	
}
