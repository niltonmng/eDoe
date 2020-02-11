package com.eDoe.item;

import javassist.tools.rmi.ObjectNotFoundException;

public class ItemDTO {

	private String description;
	private int quantity;
	private String tags;
	private String status;
	private long userId;

	public ItemDTO(String description, int quantity, String tags, String status, long userId) throws ObjectNotFoundException {
		super();
		this.description = description;
		this.quantity = quantity;
		this.tags = tags;
		this.status = status;
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
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
