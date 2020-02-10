package com.eDoe.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eDoe.item.description.Description;
import com.eDoe.item.enums.Status;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	Item findById(long id);
	List<Item> findAllByStatus(Status status);
	List<Item> findAllByDescriptionAndStatus(Description description, Status status);
	List<Item> findAllByStatusOrderByQuantityDesc(Status status);
	List<Item> findAllByStatusOrderByIdAsc(Status doacao);
	

}
