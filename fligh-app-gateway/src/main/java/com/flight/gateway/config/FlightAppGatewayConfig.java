package com.flight.gateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FlightAppGatewayConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.POST,"/post").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/put/**").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.GET,"/get").hasAnyRole("USER").and().csrf().disable().headers()
		.frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user123").password("{noop}password").roles("USER").and()
		.withUser("admin123").password("{noop}password").roles("ADMIN").and()
		.withUser("test123").password("{noop}password").roles("USER").and()
		.withUser("admin1").password("{noop}password").roles("ADMIN");
	}

}
