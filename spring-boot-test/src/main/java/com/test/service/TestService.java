package com.test.service;

import com.test.model.entity.Person;

/**
 * Created by Jes on 09/28/2018.
 */
public interface TestService {

	Person showName(String name);
	Person saveName(Person person);
}
