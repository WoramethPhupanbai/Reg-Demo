package com.example.reg.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class StudentConfiguration {

	@Autowired
	DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// Enable jdbc authentication
		@Autowired
		public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
		}
		@Bean
		public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
			JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
			jdbcUserDetailsManager.setDataSource(dataSource);
			return jdbcUserDetailsManager;
		}

		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/resources/**");
		}
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/register").permitAll().antMatchers("/welcome")
					.hasAnyRole("USER", "ADMIN").antMatchers("/getStudent").hasAnyRole("USER", "ADMIN")
					.antMatchers("/addNewStudent").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
					.loginPage("/login").permitAll().and().logout().permitAll();

			http.csrf().disable();
		}
}
