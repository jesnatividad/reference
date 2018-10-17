package com.test.service.impl;

import com.test.model.entity.Person;
import com.test.repository.TestRepository;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jes on 09/28/2018.
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testRepository;

	@Override
	public Person showName(String name) {
		return testRepository.findByFName(name);
	}

	@Override
	public Person saveName(Person person) {
		if(person!=null){
			return testRepository.save(person);
		}
		return null;
	}

	public TestServiceImpl(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	public TestServiceImpl() {
	}
}
