package com.eDoe.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDoe.item.description.Description;
import com.eDoe.item.description.DescriptionService;
import com.eDoe.item.enums.Status;
import com.eDoe.user.User;
import com.eDoe.user.UserService;
import com.eDoe.user.enums.Tipo;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private UserService userService;
	
	public Item postDoacao(ItemDTO dto) throws ObjectNotFoundException {
		Item item = this.transformToItem(dto);
		User user = item.getUser();
		if(!user.getTipo().equals(Tipo.DOADOR)) {
			throw new RuntimeException("User is not a donator.");
		}
		if(!item.getStatus().equals(Status.DOACAO)) {
			throw new RuntimeException("Item is not a Donation Type.");
		}
		return itemRepo.save(item);			
	}
	
	public Item postNecessario(ItemDTO dto) throws ObjectNotFoundException {
		Item item = this.transformToItem(dto);
		User user = item.getUser();
		if(!user.getTipo().equals(Tipo.RECEPTOR)) {
			throw new RuntimeException("User is not a Receptor.");
		}
		if(!item.getStatus().equals(Status.NECESSARIO)) {
			throw new RuntimeException("Item is not a Necessary Type.");
		}
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
	
	public Item put(ItemDTO dto, long id) throws ObjectNotFoundException {
		Item item = this.itemRepo.findById(id);
		Item newItem = this.transformToItem(dto);
		updateItem(item, newItem);
		return this.itemRepo.save(item);
	}

	private void updateItem(Item item, Item newItem) throws ObjectNotFoundException {
		item.setDescription(newItem.getDescription());
		item.setQuantity(newItem.getQuantity());
		item.setStatus(newItem.getStatus());
		item.setTags(newItem.getTags());
		item.setMatchScore(newItem.getMatchScore());
		item.setUser(newItem.getUser());
	}
	
	public List<Item> findAllByStatus(String status) {
		Status s = this.mudaStatus(status);
		return this.itemRepo.findAllByStatus(s);
	}
	
	public List<Item> findAllByStatusOrderByQuantityDesc(){
		return this.itemRepo.findAllByStatusOrderByQuantityDesc(Status.DOACAO);
	}
	
	public List<Item> findAllByStatusOrderByIdAsc(){
		return this.itemRepo.findAllByStatusOrderByIdAsc(Status.DOACAO);
	}

}
