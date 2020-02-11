package com.eDoe.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eDoe.item.enums.Status;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findAll(){
		return new ResponseEntity<List<Item>> (itemService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> findById(@PathVariable Long id) throws ObjectNotFoundException {
		Item item = itemService.findById(id);
		return new ResponseEntity<Item> (item, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Item> create(@RequestBody ItemDTO dto) throws ObjectNotFoundException {
		Item item = itemService.post(dto);
		return new ResponseEntity<Item> (item, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> create(@PathVariable Long id){
		this.itemService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody ItemDTO dto) throws ObjectNotFoundException{
		Item item = this.itemService.put(dto, id);
		return new ResponseEntity<Item>(item, HttpStatus.OK);			
	}
	
//	@RequestMapping(value = "/{status}", method = RequestMethod.GET)
//	public ResponseEntity<List<Item>> findAllByStatus(@PathVariable String status) throws ObjectNotFoundException {
//		return new ResponseEntity<List<Item>> (itemService.findAllByStatus(status), HttpStatus.OK);
//	}
	
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findAllByStatusOrderByQuantityDesc() throws ObjectNotFoundException {
		return new ResponseEntity<List<Item>> (itemService.findAllByStatusOrderByQuantityDesc(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findAllByStatusOrderByIdAsc() throws ObjectNotFoundException {
		return new ResponseEntity<List<Item>> (itemService.findAllByStatusOrderByIdAsc(), HttpStatus.OK);
	}

	
	
}
