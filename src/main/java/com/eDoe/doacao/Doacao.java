package com.eDoe.doacao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.eDoe.item.Item;
import com.eDoe.item.description.Description;
import com.eDoe.user.User;

@Entity
public class Doacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User usuarioDoador;
	
	@ManyToOne
	private User usuarioReceptor;	
	
	@ManyToOne
	private Description descricao;
	
	private int quantity;
	
	public Doacao() {
		
	}

	public Doacao(User usuarioDoador, User usuarioReceptor, Description descricao, int quantity) {
		this.usuarioDoador = usuarioDoador;
		this.usuarioReceptor = usuarioReceptor;
		this.quantity = quantity;
		this.descricao = descricao;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUsuarioDoador() {
		return usuarioDoador;
	}

	public void setUsuarioDoador(User usuarioDoador) {
		this.usuarioDoador = usuarioDoador;
	}

	public User getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(User usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}

	public Description getDescricao() {
		return descricao;
	}

	public void setDescricao(Description descricao) {
		this.descricao = descricao;
	}


}