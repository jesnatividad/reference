package com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.controller;

import com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.Exception.ForexServiceConnectException;
import com.netflix.client.ClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * Created by Jes on 10/11/2018.
 */
@ControllerAdvice(assignableTypes = CurrencyConversionController.class)
public class CurrencyConversionControllerAdvice {
	@ExceptionHandler({ConnectException.class,ClientException.class,SocketTimeoutException.class })
	public ResponseEntity<String> forexServiceConnectException(){
		return new ResponseEntity<>("Can't connect to Forex Service",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
