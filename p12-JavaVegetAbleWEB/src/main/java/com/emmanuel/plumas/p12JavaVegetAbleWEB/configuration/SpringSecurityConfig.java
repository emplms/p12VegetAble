package com.emmanuel.plumas.p12JavaVegetAbleWEB.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.emmanuel.plumas.p12JavaVegetAbleWEB.security.CustomUserDetailsService;



	@Configuration
	@EnableWebSecurity
	public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

		@Autowired
		@Qualifier("CustomUserDetailsService")
		private CustomUserDetailsService customUserDetailsService;
		
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Override
		protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.authorizeRequests().antMatchers("/","/user/createUser","/provisions").permitAll();
			
			//Redirection vers la page d'accueil après le logout
			http.logout().logoutSuccessUrl("/");
			
			// Authentication needed for the other request
			http
				.authorizeRequests()
					.antMatchers("/users","/provisionbyuseridentifiant", "/provisionsByUserIdentifiant").authenticated()
				.and()
					.formLogin();

		}
	}

