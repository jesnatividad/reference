import com.test.model.entity.Person;
import com.test.repository.TestRepository;
import com.test.service.TestService;
import com.test.service.impl.TestServiceImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jes on 09/28/2018.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DefaultControllerTest1 {

	@Mock
	TestRepository testRepository;

	@InjectMocks
	TestServiceImpl testServiceImpl;

	List<Person> personList = new ArrayList<>();
	@Before
	public void before(){
		System.out.println("BEFORE");
	}

	@After
	public void after(){
		System.out.println("AFTER");
	}

	@BeforeClass
	public static void beforeClass(){
		System.out.println("BEFORE CLASS");
	}

	@AfterClass
	public static void afterClass(){
		System.out.println("AFTER CLASS");
	}

	@Test
	public void testSavePerson(){
		Person person = new Person();
		person.setfName("Jes");
		Person returnedPerson = new Person();
		returnedPerson.setId(1L);
		returnedPerson.setfName("Jes");
		Mockito.when(testRepository.save(person)).thenReturn(returnedPerson);
		person = testServiceImpl.saveName(person);
		System.out.println(person.toString());
		System.out.println(returnedPerson.toString());
		Assert.assertTrue(returnedPerson.getId().equals(person.getId()));
	}

	@Test
	public void testSaveNullPerson(){
		Person person = null;
		Person returnedPerson = new Person();
		returnedPerson.setId(1L);
		returnedPerson.setfName("Jes");
		Mockito.when(testRepository.save(person)).thenReturn(returnedPerson);
		person = testServiceImpl.saveName(person);
		Assert.assertNull(person);
	}
}
