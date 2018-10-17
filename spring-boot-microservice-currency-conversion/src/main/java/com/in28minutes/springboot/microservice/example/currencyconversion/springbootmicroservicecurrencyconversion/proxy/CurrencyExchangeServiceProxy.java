package com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.proxy;

import com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.model.bean.CurrencyConversionBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.xml.ws.Response;

/**
 * Created by Jes on 10/11/2018.
 */
@FeignClient(name = "forex-service")
@RibbonClient(name = "forex-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
