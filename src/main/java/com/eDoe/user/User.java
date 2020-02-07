package com.eDoe.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Tipo tipo;	
	private Classe classe;
	
	public User() {
	}

	public User(String name, String email, String celular, String numberIdentification, String password, Tipo tipo,
			Classe classe) {
		super();
		this.name = name;
		this.email = email;
		this.celular = celular;
		this.numberIdentification = numberIdentification;
		this.password = password;
		this.tipo = tipo;
		this.classe = classe;
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
		result = prime * result + ((numberIdentification == null) ? 0 : numberIdentification.hashCode());
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
		if (numberIdentification == null) {
			if (other.numberIdentification != null)
				return false;
		} else if (!numberIdentification.equals(other.numberIdentification))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return (this.getName() + "/" + this.getNumberIdentification() +
				", " + this.getEmail() + ", " + this.getCelular() + ", status: " + this.getTipo()).trim();
	}
}