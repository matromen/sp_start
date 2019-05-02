package com.bgkim.advice.base;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author bgkim
 *
 *security는 filter에서 처리 해야 함.
 */
//@ControllerAdvice("com.bgkim.controller.base") 
@ControllerAdvice
@Log4j

public class ControllerCommonsAdvice {
	//security는 기본적으로 filter에서 처리. 해당 건은 무조건 login으로 처리 함.
	@ExceptionHandler(AccessDeniedException.class)
	public String accessException(AccessDeniedException ex, Authentication authentication) {
		log.error("authentication : " + authentication);
		log.error("ex : " +  ex);
		
		if(authentication == null) {
			return "redirect:/security/login";
		}else {
			return "redirect:/security/accessError";
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex, Model model) {
		log.error("Exception .............." + ex);
		model.addAttribute("exception", ex);
		log.error(model);
		
		return "/advice/error_page";
	}
}
