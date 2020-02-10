package com.eDoe.item.enums;

public enum Status {
	
	DOACAO("Doacao", "DOACAO"), 
	NECESSARIO("NECESSARIO", "Necessario");
	
	
	private String key;
	private String name;
	
	Status(String key, String name) {
		this.key = key;
		this.name = name;
	}
	
	public static Status fromName(String name) {
		for(Status c: Status.values()) {
			if(c.name.equalsIgnoreCase(name)) {
				return c;
			}
		}
		
		throw new RuntimeException("Status " + name + " não existe!");
	}
	public static Status fromKey(String key) {
		for (Status c : Status.values()) {
			if(c.key.equalsIgnoreCase(key)) return c;
		}
		throw new RuntimeException("Status " + key + " não existe!");
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
