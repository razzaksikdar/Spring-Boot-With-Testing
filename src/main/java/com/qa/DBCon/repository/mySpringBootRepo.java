package com.qa.DBCon.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.DBCon.model.mySpringBootDataModel;;

@Repository 
public interface mySpringBootRepo extends JpaRepository<mySpringBootDataModel, Long>{

public mySpringBootDataModel findByName(String name);



	



	
	
}