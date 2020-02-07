package com.eDoe.item;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.eDoe.description.Description;
import com.eDoe.user.User;
import com.eDoe.user.enums.Status;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne // this means that we have many items to one unique description
	private Description description;
	private int quantity;
	private String tags;	
	@ManyToOne 
	private User user;
	private Status status;
	@Transient
	private int matchScore;

	
	public Item() {

	}

	public Item(Description description, int quantity, String tags, User user, Status status, int matchScore) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.tags = tags;
		this.user = user;
		this.status = status;
		this.matchScore = 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getMatchScore() {
		return matchScore;
	}

	public void setMatchScore(int matchScore) {
		this.matchScore = matchScore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
