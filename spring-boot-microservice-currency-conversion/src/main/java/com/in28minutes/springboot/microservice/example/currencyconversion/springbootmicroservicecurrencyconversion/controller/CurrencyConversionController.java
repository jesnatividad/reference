package com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.controller;

import com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.Exception.ForexServiceConnectException;
import com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.model.bean.CurrencyConversionBean;
import com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jes on 10/11/2018.
 */
@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversionBean> convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		CurrencyConversionBean currencyConversionBean = currencyExchangeServiceProxy.retrieveExchangeValue(from,to);

		logger.info("{}",currencyConversionBean);

		return new ResponseEntity<>(new CurrencyConversionBean(currencyConversionBean.getId(), from, to, currencyConversionBean.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort()),HttpStatus.OK);
	}
}
