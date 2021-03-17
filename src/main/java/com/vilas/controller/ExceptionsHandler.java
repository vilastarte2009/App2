package com.vilas.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vilas.exceptions.EmpNotFound;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(EmpNotFound.class)
	public ResponseEntity<Object> empNotFound(Exception ex, WebRequest request)
	{
		System.out.println("Employee not found eeee");		
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Emp not found");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView arithmeticException(ArithmeticException ex, WebRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("error_msg", ex.getLocalizedMessage());
		
		mv.setViewName("error1");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView genricException(Exception ex, WebRequest request)
	{
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("error_msg", ex.getLocalizedMessage());
		
		mv.setViewName("error1");
		
		return mv;
	}

}
