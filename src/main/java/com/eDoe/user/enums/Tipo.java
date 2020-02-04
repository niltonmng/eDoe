package com.eDoe.user.enums;

public enum Tipo {
	
	DOADOR("DOADOR", "Doador"), 
	RECEPTOR("Receptor", "RECEPTOR");
	
	
	private String key;
	private String name;
	
	Tipo(String key, String name) {
		this.key = key;
		this.name = name;
	}
	public static Tipo fromName(String name) {
		for(Tipo c: Tipo.values()) {
			if(c.name.equalsIgnoreCase(name)) {
				return c;
			}
		}
		
		throw new RuntimeException("Tipo " + name + " não existe!");
	}
	public static Tipo fromKey(String key) {
		for (Tipo c : Tipo.values()) {
			if(c.key.equalsIgnoreCase(key)) return c;
		}
		throw new RuntimeException("Tipo " + key + " não existe!");
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
