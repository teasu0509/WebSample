package com.tlg.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tlg.exception.ResourceNotFoundException;

@ControllerAdvice
class GlobalDefaultExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/errors/sysError500");
		return mv;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView notFoundError(HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/errors/sysError404");
		return mv;
	}

}
