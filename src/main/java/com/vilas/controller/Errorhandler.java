package com.vilas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class Errorhandler 
{
	public static final Logger logger = LogManager.getLogger(Errorhandler.class);
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, HttpServletResponse resp, Exception ex)
	{	
		logger.error("vvv Vilas Error exceptionhandler controller... ");
		
		ModelAndView mv = new ModelAndView();		
		mv.addObject("error_msg", ex.getLocalizedMessage());
		mv.addObject("exception_url", req.getRequestURL());
		logger.debug("Vilas Exception Occured URL -"+req.getRequestURL()+"  "+ex.getStackTrace());
		mv.setViewName("error");
		return mv;
		
		
	}

}
