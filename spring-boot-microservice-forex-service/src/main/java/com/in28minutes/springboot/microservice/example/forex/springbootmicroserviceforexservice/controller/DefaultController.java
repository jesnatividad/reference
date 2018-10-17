package com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.controller;

import com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.model.entity.ExchangeValue;
import com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.model.service.ConversionExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jes on 10/11/2018.
 */
@RestController
public class DefaultController {

	@Autowired
	ConversionExchangeService conversionExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to){
		return conversionExchangeService.retrieveExchangeValue(from, to);
	}
}
