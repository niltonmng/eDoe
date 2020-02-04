package com.eDoe.user.enums;

public enum Classe {
	
	PESSOA_FISICA("PESSOA_FISICA", "PESSOA FISICA"),
	IGREJA("IGREJA", "Igreja"),
	ORGAO_PUBLICO_MUNICIPAL("ORGAO_PUBLICO_MUNICIPAL", "ORGAO PUBLICO MUNICIPAL"),
	ORGAO_PUBLICO_ESTADUAL("ORGAO_PUBLICO_ESTADUAL", "ORGAO PUBLICO ESTADUAL"),
	ORGAO_PUBLICO_FEDERAL("ORGAO_PUBLICO_FEDERAL", "ORGAO PUBLICO FEDERAL"),
	ONG("ONG", "Ong"),
	ASSOCIACAO("ASSOCIACAO", "Associacao"),
	SOCIEDADE("SOCIEDADE", "Sociedade");
	
	private String key;
	private String name;
	
	Classe(String key, String name) {
		this.key = key;
		this.name = name;
	}
	public static Classe fromName(String name) {
		for(Classe c: Classe.values()) {
			if(c.name.equalsIgnoreCase(name)) {
				return c;
			}
		}
		
		throw new RuntimeException("Classe " + name + " não existe!");
	}
	public static Classe fromKey(String key) {
		for (Classe c : Classe.values()) {
			if(c.key.equalsIgnoreCase(key)) return c;
		}
		throw new RuntimeException("Classe " + key + " não existe!");
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
