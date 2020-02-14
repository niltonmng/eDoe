package com.eDoe.doacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDoe.item.Item;
import com.eDoe.item.ItemService;

@Service
public class DoacaoService {
	
	@Autowired
	DoacaoRepository doacaoRepository;
	
	@Autowired
	ItemService itemService;
	
	public Doacao makeDonation(long necessaryID, long donatedID) {
		Item necessaryItem = itemService.findById(necessaryID);
		Item donatedItem = itemService.findById(donatedID);
		
		if (necessaryItem == null || donatedItem == null) {
			return null;
		}
		
		if (necessaryItem.getDescription().equals(donatedItem.getDescription())) {
			int quantity = donatedQuantity(donatedItem, necessaryItem);
			Doacao doacao = new Doacao(donatedItem.getUser(), necessaryItem.getUser(), donatedItem.getDescription(), quantity);
			donatedItem.setQuantity(donatedItem.getQuantity() - quantity);
			necessaryItem.setQuantity(necessaryItem.getQuantity() - quantity);
//			updateQuantity(donatedItem);
//			updateQuantity(necessaryItem);
			return doacaoRepository.save(doacao);
		}
		return null;
	}
	
	private int donatedQuantity(Item donatedItem, Item necessaryItem) {
		if (donatedItem.getQuantity() > necessaryItem.getQuantity()) {
			return necessaryItem.getQuantity();
		} else {
			return donatedItem.getQuantity();
		}
	}
	
//	private void updateQuantity(Item item) {
//		if (item.getQuantity() < 1) {
//			itemService.delete(item.getId());
//		} else {
//			itemService.update(item);
//		}
//	}
	
	public List<Doacao> findAll() {
		return doacaoRepository.findAll();
	}
}
