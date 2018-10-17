package com.test.controller;

import com.test.exception.TooLargeNumberException;
import com.test.model.entity.Person;
import com.test.service.TestService;
import javafx.collections.transformation.SortedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Jes on 09/24/2018.
 */
@RestController
public class DefaultController {

	@Value("${server.port}")
	Integer port;

	@Autowired
	TestService testService;

	@GetMapping("/test")
	public Integer testPort()
	{
		Integer a = 6;
		if(a >5){
			throw new TooLargeNumberException();
		}
		return  port;
	}

	@GetMapping("/hello")
	public Person hello(@RequestParam String name){
		return testService.showName(name);
	}

	@PostMapping("/save")
	public ResponseEntity<Person> savePerson(@RequestParam String name){
		Person person = testService.saveName(new Person(0L,name));
		return new ResponseEntity<>(person,HttpStatus.CREATED);
	}

	@GetMapping("/test/{num}")
	public ResponseEntity<Person> test(@PathVariable int num){
		Person person = new Person();
		if(num>2){
			throw new TooLargeNumberException();
		}
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
}
