package com.test.controller.advice;

import com.test.exception.TooLargeNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Jes on 09/24/2018.
 */
@ControllerAdvice
public class DefaultControllerAdvice {
	@ExceptionHandler(value = TooLargeNumberException.class)
	public ResponseEntity<String> tooLargeNumberException(){
		return new ResponseEntity<>("Number too large", HttpStatus.CONFLICT);
	}
}
