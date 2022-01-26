package com.fis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fis.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        // Disable CSRF
	        http.csrf().disable()
	                // Only admin can perform HTTP delete operation
	                .authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
	                // any authenticated user can perform all other operations
	                .antMatchers("/employee/**").hasAnyRole("ADMIN", "USER").and().httpBasic()
	                // Permit all other request without authentication
	                .and().authorizeRequests().anyRequest().permitAll()
	                // We don't need sessions to be created.
	                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    }
	 
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	    }
	/* @Bean
	    public PasswordEncoder passwordEncoder() {
		 
	        return new BCryptPasswordEncoder(60);
	    }*/
	 
	 private PasswordEncoder getPasswordEncoder() {
	        return new PasswordEncoder() {
	            @Override
	            public String encode(CharSequence charSequence) {
	                return charSequence.toString();
	            }

	            @Override
	            public boolean matches(CharSequence charSequence, String s) {
	                return true;
	            }
	        };
	    }

}
