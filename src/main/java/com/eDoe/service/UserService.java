package com.eDoe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.eDoe.entity.User;
import com.eDoe.repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository repo;

	
	public List<User> findAll() {
		return this.repo.findAll();
	}
	
	public Optional<User> findOne(String id) {
		return this.repo.findById(Long.parseLong(id));
	}
	
	public User post(User user){
		return this.repo.save(user);
	}
	
	public User put(User user) {
		return this.repo.save(user);
	}
	
	public Optional<User> delete(Long id) {
		Optional<User> aux = this.repo.findById(id);
		this.repo.deleteById(id);
		return aux;
	}
	
	public User findByName(String name) {
		return repo.findByName(name);
	}
	
	public User findByNameNovo(String name) {
		return repo.findByNameNovo(name);
	}
	
	public User findByNameIgnoreCase(String name) {
		return repo.findByNameIgnoreCase(name);
	}
	
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	
}
