package com.emmanuel.plumas.p12JavaVegetAbleWEB.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class CommonController {

	protected String getUserNamePrincipal() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userLastName = "empty";
		if (principal instanceof UserDetails) {
			userLastName = ((UserDetails) principal).getUsername();
		} else {
			userLastName = principal.toString();
		}
		return userLastName;
	}
	
}
