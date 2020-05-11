package org.studyeasy.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user").access("hasRole('ROLE_USER')")
		.antMatchers("/admin").access("hasAnyRole('ROLE_ADMIN')");
		http.formLogin().loginPage("/login").failureUrl("/login?error");
		
		// REMEMBER-ME Step #1 add HTTP security for remember-me feature
		http.rememberMe().rememberMeParameter("remember-me")
		.tokenValiditySeconds(5000)
		.key("anyKey")
		.tokenRepository(tokenRepository());
		
		
	}

	//REMEMBER-ME Step #2 define a token repository
	// Add the table into the database find the required table schema using below link.
	// https://docs.spring.io/spring-security/site/docs/3.0.x/reference/appendix-schema.html
	
	private PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl tokenRepo = new JdbcTokenRepositoryImpl();
		tokenRepo.setDataSource(dataSource);
		return tokenRepo;
	}
	
	// REMEMBER-ME Step #3 update login form with remember me checkbox
	
}