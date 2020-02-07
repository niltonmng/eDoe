package com.eDoe.description;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescriptionService {
	
	@Autowired
	private DescriptionRepository repo;
	
	public Description create(Description description) {
		Description desc = repo.findByDescription(description.getDescription());
		
		if(desc != null) {
			description.setId(desc.getId());
		}
		return repo.save(description);
	}
	
	public List<Description> findAll() {
		return repo.findAll();
	}

}
