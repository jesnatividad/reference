package service;

import com.test.model.entity.Person;
import com.test.repository.TestRepository;
import com.test.service.TestService;
import com.test.service.impl.TestServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Jes on 09/28/2018.
 */
@RunWith(SpringRunner.class)
public class TestServiceTest {

	@TestConfiguration
	static class TestServiceImplTestContextConfiguration{

		@Bean
		public TestService testService(){
			return new TestServiceImpl();
		}
	}

	@Autowired
	private TestService testService;

	@MockBean
	private TestRepository testRepository;

	@Before
	public void init(){
		Person jesPerson = new Person();
		jesPerson.setId(1L);
		jesPerson.setfName("Jes");
		Mockito.when(testService.showName("Jes")).thenReturn(jesPerson);
	}

	@Test
	public void whenFnameExist_returnPerson(){
		String fName = "Jes";
		Person found = testService.showName("Jes");
		Assert.assertEquals(fName,found.getfName());
	}

	@Test
	public void whenFnameNotExist_returnNull(){
		Person notFound = testService.showName("Jake");
		Assert.assertNull(notFound);
	}

}
