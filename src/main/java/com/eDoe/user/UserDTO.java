package com.eDoe.user;

import com.eDoe.user.enums.Classe;
import com.eDoe.user.enums.Tipo;

public class UserDTO {
	
	private String name;
	private String email;
	private String celular;
	private String numberIdentification;
	private String password;
	private String tipo;	
	private String classe;
	
	
	public UserDTO(String name, String email, String celular, String numberIdentification, String password, String tipo,
			String classe) {
		this.name = name;
		this.email = email;
		this.celular = celular;
		this.numberIdentification = numberIdentification;
		this.password = password;
		this.tipo = tipo;
		this.classe = classe;
	}
	
	
	public User transformToUser() {
		return new User(this.name, this.email, this.celular, this.numberIdentification, this.password, mudaTipo(this.tipo), mudaClasse(this.classe));
	}	
	
	
	public Tipo mudaTipo(String tipo) {
		switch (tipo.toUpperCase()) {
			case "DOADOR": 
				return Tipo.DOADOR;
			case "RECEPTOR":
				return Tipo.RECEPTOR;
		}
		return null;
	}
	
	public Classe mudaClasse(String classe) {
		switch (classe) {
			case "PESSOA_FISICA": 
				return Classe.PESSOA_FISICA;
			case "IGREJA":
				return Classe.IGREJA;
			case "ORGAO_PUBLICO_MUNICIPAL":
				return Classe.ORGAO_PUBLICO_MUNICIPAL;
			case "ORGAO_PUBLICO_ESTADUAL":
				return Classe.ORGAO_PUBLICO_ESTADUAL;
			case "ORGAO_PUBLICO_FEDERAL":
				return Classe.ORGAO_PUBLICO_FEDERAL;
			case "ONG":
				return Classe.ONG;
			case "ASSOCIACAO":
				return Classe.ASSOCIACAO;
			case "SOCIEDADE":
				return Classe.SOCIEDADE;
		}
		return null;
	}

}
