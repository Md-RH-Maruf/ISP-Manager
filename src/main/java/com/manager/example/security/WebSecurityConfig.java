package com.manager.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); 
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/","/register","/login","/forgot-password","/registerNewUser","/request-for-connection","/support/complain").permitAll()
			.antMatchers("/inventory/","/js/**", "/css/**", "/img/**", "/scss/**", "/vendor/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.loginProcessingUrl("/perform_login")
			.defaultSuccessUrl("/dashboard", true)
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();
	}
	
	
	
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() { // TODO
	 * Auto-generated method stub List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("maruf").password("123")
	 * .roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 */

}
