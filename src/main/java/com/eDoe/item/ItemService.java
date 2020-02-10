package com.eDoe.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDoe.item.description.DescriptionService;
import com.eDoe.user.User;
import com.eDoe.user.UserService;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private UserService userService;
	
	
	// parei aqui // criamos o item, e lhe setamos um user e uma descricao
	// está errado, temos que passar um ItemDTO para buscar o user pelo valor passado no DTO do item, e a partir daí construir um User 
	// que esteja no item, e nao passar o id do user pelo caminho do item.
	public Item post(Item item, Long id) throws ObjectNotFoundException {
		User user = userService.findById(id);
		item.setUser(user);
		descriptionService.create(item.getDescription());
		return itemRepo.save(item);
	}
	
	public Item findById(long id) {
		return itemRepo.findById(id);
	}
	
	public List<Item> findAll() {
		return this.itemRepo.findAll();
	}

}
