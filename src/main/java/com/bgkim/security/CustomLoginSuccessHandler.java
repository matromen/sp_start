package com.bgkim.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		log.info("Login Success");
		
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
		
		log.info("Role Name : " + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/security/mypage/admin");
			
			return;
		}else {
			response.sendRedirect("/security/mypage/member");
			
			return;
		}
		
	}

}
