package com.eDoe.user;

import com.eDoe.user.enums.Classe;
import com.eDoe.user.enums.Tipo;

public class UserDTO {
	
	private String name;
	private String email;
	private String celular;
	private String numberIdentification;
	private String password;
	private Tipo tipo;	
	private Classe classe;
	
	
	public UserDTO(String name, String email, String celular, String numberIdentification, String password, Tipo tipo,
			Classe classe) {
		this.name = name;
		this.email = email;
		this.celular = celular;
		this.numberIdentification = numberIdentification;
		this.password = password;
		this.tipo = tipo;
		this.classe = classe;
	}
	
	
	public User transformToUser() {
		return new User(this.name, this.email, this.celular, this.numberIdentification, this.password, this.tipo, this.classe);
	}	

}
