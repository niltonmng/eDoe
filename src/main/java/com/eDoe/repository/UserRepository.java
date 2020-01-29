package com.eDoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eDoe.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByName(String name);
	
	@Query("select u from User u where u.email = ?1") // personalizamos as nossas queries
	User findByEmail(String email);
	
	@Query("select u from User u where u.name like %?1%")
	User findByNameNovo(String nome);
	
	User findByNameIgnoreCase(String name);

}
