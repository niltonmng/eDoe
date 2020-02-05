package com.eDoe.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDoe.user.enums.Classe;
import com.eDoe.user.enums.Tipo;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(Long id) throws ObjectNotFoundException {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("User not found!"));
	}
	
	public User post(UserDTO dto){
		User user = dto.transformToUser();
		return repo.save(user);
	}
	
	public User put(UserDTO dto, Long id) throws ObjectNotFoundException{
		User newUser = findById(id);
		User fromDto = dto.transformToUser();
		this.updateData(newUser, fromDto);
		return repo.save(newUser);
	}
	
	public User putNumberIdentification(UserDTO dto, String numberIdentification) throws ObjectNotFoundException {
		User newUser = this.findByNumberIdentification(numberIdentification);
		User fromDto = dto.transformToUser();
		this.updateData(newUser, fromDto);
		return repo.save(newUser);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		newObj.setCelular(obj.getCelular());
		//newObj.setNumberIdentificationo(obj.getNumberIdentification()); a person must not change its identification number, meanwhile.
		newObj.setPassword(obj.getPassword());
		newObj.setTipo(obj.getTipo());
		newObj.setClasse(obj.getClasse());
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
	// Metodos extras utilizados para pesquisa com o @Query no UserRepository.
	
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
	
	public User findByNumberIdentification(String numberIdentification) {
		return repo.findByNumberIdentification(numberIdentification);
	}
	
	public List<User> findByNameContainingIgnoreCase(String name){
		return repo.findByNameContainingIgnoreCase(name);
	}

}
