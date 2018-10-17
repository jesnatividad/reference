package com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.model.service;

import com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.model.entity.ExchangeValue;
import com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.model.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by Jes on 10/11/2018.
 */
@Service
public class ConversionExchangeService {

	@Autowired
	ConversionRepository conversionRepository;

	@Autowired
	Environment environment;
	public ExchangeValue retrieveExchangeValue(String from, String to) {
		ExchangeValue exchangeValue =conversionRepository.findByFromAndTo(from, to);
		if(exchangeValue!=null){
			exchangeValue.setPort(Integer.parseInt(environment.getProperty("server.port")));
			return exchangeValue;
		}

		return null;
	}
}
