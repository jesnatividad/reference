package com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.Exception;

import java.net.ConnectException;

/**
 * Created by Jes on 10/11/2018.
 */
public class ForexServiceConnectException extends ConnectException {
	public ForexServiceConnectException(String message) {
		super(message);
	}
}
