package com.example.demo.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends  WebSecurityConfigurerAdapter  {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/css/**","/js/**","/libs/**","/fonts/**","/src/**","/forgotPassword","/privacy","/resetPassword","/inscription","/inscrire","/callBack").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/LoginVrai")
		.successForwardUrl("/index")
		.permitAll()
		
		.and()
		.logout()
		.logoutUrl("/LoginVrai?logout")
		.logoutSuccessUrl("/LoginVrai");
		
	}

}
