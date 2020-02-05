package com.eDoe.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable Long id) throws ObjectNotFoundException{
		return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
	}
	
	
	// nao postar usuários com o mesmo numero de identificacao
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> post(@RequestBody UserDTO dto){
		User user = userService.post(dto);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> put(@PathVariable Long id, @RequestBody UserDTO dto) throws ObjectNotFoundException{
		return new ResponseEntity<User>(userService.put(dto, id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.userService.delete(id);
		return new 	ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// ===================== CUSTOMIZED METHODS ===================
	
	
	@RequestMapping(value = "/identification/{numberIdentification}", method = RequestMethod.GET)
	public ResponseEntity<User> findByNumberIdentification(@PathVariable(value="numberIdentification") String numberIdentification) {
		User user = userService.findByNumberIdentification(numberIdentification);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsersByName(@PathVariable(value="name") String name) {
		return new ResponseEntity<List<User>> (userService.findByNameContainingIgnoreCase(name), HttpStatus.OK);
	}
	
}
