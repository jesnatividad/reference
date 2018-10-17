package com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.model.repository;

import com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.model.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jes on 10/11/2018.
 */

@Repository
public interface ConversionRepository extends JpaRepository<ExchangeValue,Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
