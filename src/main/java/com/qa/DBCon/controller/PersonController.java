package com.qa.DBCon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.DBCon.model.Order;
import com.qa.DBCon.repository.OrderRepository;
import com.qa.DBCon.repository.mySpringBootRepo;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired
	private mySpringBootRepo myRepo;
	
	@GetMapping("/person/{personId}/orders")
	public Page<Order> getAllOrdersByPersonId(@PathVariable (value ="person_id") Long personId, Pageable pageable)
	{
		return orderRepository.findByPersonId(personId, pageable);
	}
	
//	@PostMapping("/person/{personId}/orders")
//	public Order createComment( @PathVariable (value = "personId") Long personId,
//	@Valid@RequestBody Order Order order {
//		return myRepo.findById(personId).map(mySpringBootDataModel -> {
//			order.setPerson(mySpringBootDataModel);
//		}).orElseThrow() -> new ResourceNotFoundException("Person", "id", order));
//	}

	@PostMapping("/person/{personId}/orders")
	public Order createComment(@PathVariable (value="personId") Long personId,
			@Valid@RequestBody Order order)
	{
		return myRepo.findById(personId).map(myRepo -> {order.setPerson(myRepo);
		return orderRepo.save(order);}).orElseThrow(() -> new ResourceNotFoundException("Person", "id", order));
	}
	
	
}
