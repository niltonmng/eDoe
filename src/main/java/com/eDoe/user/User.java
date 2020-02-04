package com.eDoe.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.eDoe.role.Role;
import com.eDoe.user.enums.Classe;
import com.eDoe.user.enums.Tipo;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String celular;
	private String numberIdentification;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Enumerated(EnumType.STRING)
	private Classe classe;
	
	// TALVEZ REMOVER ESTES PAPÉIS
	@ManyToMany
	private List<Role> roles;

	public User() {
	}

	public User(String name, String email, String celular, String numberIdentification, String password, Tipo tipo,
			Classe classe, List<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.celular = celular;
		this.numberIdentification = numberIdentification;
		this.password = password;
		this.tipo = tipo;
		this.classe = classe;
		this.roles = roles;
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


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getNumberIdentification() {
		return numberIdentification;
	}

	public void setNumberIdentificationo(String numberIdentification) {
		this.numberIdentification = numberIdentification;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return ("id= " + id + "\n, name= " + name + "\n, email= " + email + "\n, celular= " + celular + "\n, classe= " + classe
				+ "\n, numberIdentification= " + numberIdentification + "\n, tipo= " + tipo + "\n" + this.seeRoles()).trim();
	}
	private String seeRoles() {
		String out = "";
		for (Role role : roles) {
			out += role.toString() + " \n";
		}
		out = out.trim();
		return out;
	}
}