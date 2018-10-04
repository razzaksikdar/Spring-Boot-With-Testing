package repo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.DBCon.DbConApplication;
import com.qa.DBCon.model.mySpringBootDataModel;
import com.qa.DBCon.repository.mySpringBootRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DbConApplication.class})
@DataJpaTest
public class RepositoryTest {
	
@Autowired
private TestEntityManager entityManager;

@Autowired
private mySpringBootRepo myRepo;

@Test
public void retriveByIdTest()
{
	mySpringBootDataModel model1 = new mySpringBootDataModel("Bob", "Space", 50);
	entityManager.persist(model1);
	entityManager.flush();
	assertTrue(myRepo.findById(model1.getId()).isPresent());
	
}


@Test
public void retriveByNameTest()
{
	mySpringBootDataModel model2 = new mySpringBootDataModel("Mark", "Marse", 38);
	entityManager.persist(model2);
	entityManager.flush();
	
	mySpringBootDataModel found = myRepo.findByName(model2.getName());
	assertEquals("Mark", found.getName());
	
//	assertTrue(myRepo.findByName(model2.getName()).isPresent());
	
//	assertTrue(myRepo.findByName(model2.getName()).isEqualTo);
	System.out.println(found);
}

}
