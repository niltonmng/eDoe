package com.eDoe.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.eDoe.entity.User;
import com.eDoe.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	UserRepository repo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<User> users = repo.findAll();
		
		if(users.isEmpty()) {
			this.createUser("Nilton", "nilton@mail.com", "12345");
			this.createUser("Joao", "joao@mail.com", "12345");
			this.createUser("Maria", "maria@mail.com", "12345");
		}
		
		User j = repo.getOne(Long.parseLong("2"));
		System.out.println(j.toString());
		User m = repo.findByName("Maria");
		System.out.println(m.toString());
		User n = repo.findByEmail("nilton@mail.com");
		System.out.println(n.toString());
		User x = repo.findByNameNovo("Jo");
		System.out.println(x.toString());
		User y = repo.findByNameIgnoreCase("nilton");
		System.out.println(y.toString());
		
	}
	
	
	public void createUser(String name, String email, String password) {
		User user = new User(name, email, password);
		repo.save(user);
	}
 
}
