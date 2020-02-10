package com.eDoe.item;

import com.eDoe.item.description.Description;
import com.eDoe.item.enums.Status;
import com.eDoe.user.User;

public class ItemDTO {
	
	private Description description;
	private int quantity;
	private String tags;
	private User user;
	private String status;
	private long userId;
	
	
	public ItemDTO(Description description, int quantity, String tags, User user, String status, long userId) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.tags = tags;
		this.user = user;
		this.status = status;
		this.userId = userId;
	}
	
	public Item transformToItem() {
		return new Item(description, quantity, tags, user, this.mudaStatus(status), 0);
	}
	
	public Status mudaStatus(String status) {
		switch (status.toUpperCase()) {
			case "DOACAO": 
				return Status.DOACAO;
			case "NECESSARIO":
				return Status.NECESSARIO;
		}
		return null;
	}


	public Description getDescription() {
		return description;
	}


	public void setDescription(Description description) {
		this.description = description;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}

}
