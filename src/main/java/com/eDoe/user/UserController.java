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
	
	// USE "X-WWW-FORM-URLENCODED" FORM ON POSTMAN TO PASS USER INFORMATION
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> post(@RequestBody UserDTO dto){
		return new ResponseEntity<User>(userService.post(dto), HttpStatus.OK);
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
	
}