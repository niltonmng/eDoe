package com.eDoe.description;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/description")
public class DescriptionController {
	
	@Autowired
	private DescriptionService descService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Description>> findAll(){
		return new ResponseEntity<List<Description>>(descService.findAll(),HttpStatus.OK);
	}
	
	

}
