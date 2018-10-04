package com.qa.DBCon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.DBCon.exception.ResourceNotFoundException;
import com.qa.DBCon.model.mySpringBootDataModel;
import com.qa.DBCon.repository.mySpringBootRepo;



@RestController
@RequestMapping("/api")
public class DBConController {
	
//	@Autowired
//	mySpringBootRepo repos;
//	@Autowired
//	mySpringBootRepo Repo;
	@Autowired
	mySpringBootRepo Repo;

	// method to create a person 
	@PostMapping("/person")
	private mySpringBootDataModel createPerson(@Valid @RequestBody mySpringBootDataModel mSDM) {
		return Repo.save(mSDM);
	}
	
	@GetMapping("/person/{id}")
	public mySpringBootDataModel getPersonbyID(@PathVariable(value="id")Long personID){
		
		return Repo.findById(personID).orElseThrow(()->new ResourceNotFoundException("mySpringBootDataModel", "id", personID));
	}
	
	@GetMapping("/person")
	public List<mySpringBootDataModel> getAllPeople()
	{
		return Repo.findAll();
	}
	
	@PutMapping("/person/{id}")
	public mySpringBootDataModel updatePerson(@PathVariable(value="id")Long personID,
			@Valid@RequestBody mySpringBootDataModel personDetails)
	{
		mySpringBootDataModel mSDM = Repo.findById(personID).orElseThrow(()->new ResourceNotFoundException("mySpringBootDataModel", "id", personID));
		
		mSDM.setName(personDetails.getName());
		mSDM.setAddress(personDetails.getAddress());
		mSDM.setAge(personDetails.getAge());
		
		mySpringBootDataModel updateData = Repo.save(mSDM);
		return updateData;
	}
	

	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value="id")Long personID)
	{
		mySpringBootDataModel mSDM = Repo.findById(personID).orElseThrow(()->new ResourceNotFoundException("mySpringBootDataModel", "id", personID));
		
		Repo.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	
}
