package com.heroku.sample.herokutest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    
	private static Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest arg0, HttpServletResponse arg1, 
			AccessDeniedException arg2) throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
        	logger.info("Logged in user : "+authentication.getName()
        	+"	attempted to access the protected URL " + arg0.getRequestURI());
        	arg1.sendRedirect(arg0.getContextPath()+"/error");
        }
	}

}
