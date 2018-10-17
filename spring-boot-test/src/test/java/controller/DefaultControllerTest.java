package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.Application;
import com.test.controller.DefaultController;
import com.test.model.entity.Person;
import com.test.service.TestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
/**
 * Created by Jes on 09/28/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
		classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-integrationtest.properties")
public class DefaultControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	TestService testService;

	JacksonTester<Person> jacksonTester;

	@Before
	public void setup(){
		
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void givenPersonFname_whenExist_thenReturnFname() throws Exception{
		Person jesPerson = new Person();
		jesPerson.setfName("Jes");
		MockHttpServletResponse response= mockMvc.perform(get("/hello?name="+jesPerson.getfName())
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		System.out.println(response.getContentAsString());
		System.out.println(response.getStatus());
	}

	@Test
	public void givenPersonFname_whenNotExist_thenReturnNone() throws Exception{
		Person jesPerson = new Person();
		jesPerson.setfName("Jes");
		given(testService.showName("Jess")).willReturn(jesPerson);
		mockMvc.perform(get("/hello?name="+jesPerson.getfName())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(""));
	}

	@Test
	public void givenPerson_whenSave_thenReturnPersonWithId() throws Exception{

		MockHttpServletResponse response= mockMvc.perform(
				post("/save?name=Jake")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn()
				.getResponse();
		System.out.println(response.getStatus());
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}
}
