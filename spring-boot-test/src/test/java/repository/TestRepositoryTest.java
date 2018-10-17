package repository;

import com.test.Application;
import com.test.model.entity.Person;
import com.test.repository.TestRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jes on 09/28/2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Application.class)
public class TestRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private TestRepository testRepository;


	public  void saveInitialData(){
		Person jesPerson = new Person();
		Person jakePerson = new Person();
		jesPerson.setfName("jes");
		jakePerson.setfName("jake");
		testEntityManager.persist(jakePerson);
		testEntityManager.persist(jesPerson);
		testEntityManager.flush();

	}


	@Test public void  whenSave_thenReturnPersonWithId(){
		Person newPerson = new Person();
		newPerson.setfName("Yolo");
		newPerson = testRepository.save(newPerson);
		System.out.println(newPerson.getId());
		Assert.assertNotNull(newPerson.getId());
	}

	@Test
	public void whenFindFname_thenReturnPerson() {
		saveInitialData();
		//when
		Person found = testRepository.findByFName("jake");
		testRepository.findAll()
				.forEach(person -> {
					System.out.println(person.toString());
				});
		//then
		Assert.assertNotNull(found);
	}
}
