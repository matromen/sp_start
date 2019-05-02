package com.bgkim.controller.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author bgkim
 * 
 * security controller 패키지 분리는 controllerAdvice 영역에서 벗어나기 위해
 * security는 filter에서 자체적으로 처리 함.
 */
@Controller
@Log4j
@RequestMapping("/security")
public class SecurityController {
	
	@GetMapping("/login")
	public void loginInput(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		
		if(logout != null) {
			model.addAttribute("logout","Logout !!");
		}
	}
	
	
	@GetMapping("/mypage/admin")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void doAdmin() {
		log.info("admin page");
	}
	
	@GetMapping("/mypage/member")
	@Secured({"ROLE_MEMBER", "ROLE_ADMIN"})
	public void doMember() {
		log.info("member page");
	}
	
	
	
	@GetMapping("/logout")
	@PreAuthorize("isAuthenticated()")
	public void logoutGet() {
		log.info("logout get");
	}
	
	@PostMapping("/logout")
	public void logoutPost() {
		log.info("logout post");
	}
	
	@RequestMapping("/accessError")
	public String accessDenied(Authentication authentication, Model model) {
		log.info("access Denied : " + authentication);
		
		model.addAttribute("msg", "AccessDenied");
		
		return "/security/accessError_page";
	}
	
}
