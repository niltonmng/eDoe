package com.eDoe.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDoe.item.description.Description;
import com.eDoe.item.description.DescriptionService;
import com.eDoe.item.enums.Status;
import com.eDoe.user.User;
import com.eDoe.user.UserDTO;
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
	
	public Item post(ItemDTO dto) throws ObjectNotFoundException{
		Item item = this.transformToItem(dto);
		return itemRepo.save(item);
	}
	
	private Item transformToItem(ItemDTO dto) throws ObjectNotFoundException {
		Description desc = descriptionService.create(new Description(dto.getDescription()));
		int quantity = dto.getQuantity();
		String tags = dto.getTags();
		User user = userService.findById(dto.getUserId());
		Status status = mudaStatus(dto.getStatus());
		return new Item(desc, quantity, tags, user, status, 0);
	}
	
	
	
	private Status mudaStatus(String status) {
		switch (status.toUpperCase()) {
			case "DOACAO": 
				return Status.DOACAO;
			case "NECESSARIO":
				return Status.NECESSARIO;
		}
		return null;
	}
	
	
	
	public Item findById(long id) {
		return itemRepo.findById(id);
	}
	
	public List<Item> findAll() {
		return this.itemRepo.findAll();
	}
	
	public void delete(long id) {
		this.itemRepo.deleteById(id);
	}

}
