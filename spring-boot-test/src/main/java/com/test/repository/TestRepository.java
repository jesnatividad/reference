package com.test.repository;

import com.test.model.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Jes on 09/28/2018.
 */

@Repository
public interface TestRepository extends JpaRepository<Person,Long> {

	Person findByFName(String fName);
}
