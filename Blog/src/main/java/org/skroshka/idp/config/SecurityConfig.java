package org.skroshka.idp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// ------
	// @Autowired
	// private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	DataSource dataSource;

	@Value("${spring.admin.username}")
	private String adminUsername;

	@Value("${spring.admin.username}")
	private String adminPassword;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	// -----

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * http.csrf().disable().authorizeRequests().antMatchers("/",
		 * "/index").permitAll().antMatchers("/admin/**")
		 * .hasAnyRole("ADMIN").antMatchers("/user/**",
		 * "/newPost/**").hasAnyRole("USER").anyRequest()
		 * .authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl(
		 * "/index").permitAll().and()
		 * .logout().permitAll().and().exceptionHandling().accessDeniedHandler(
		 * accessDeniedHandler);
		 */

		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher(" **/login")).and().authorizeRequests()
				.antMatchers("/index").hasRole("USER").and().formLogin().defaultSuccessUrl("/index").loginPage("/login")
				.and().logout().permitAll();

		// http.authorizeRequests().antMatchers("/",
		// "/index").permitAll().anyRequest().authenticated().and().formLogin()
		// .loginPage("/login").permitAll().and().logout().permitAll();
	}

	// ----

	/*
	 * @Bean public SecurityWebFilterChain
	 * springSecurityFilterChain(ServerHttpSecurity http) { return
	 * http.authorizeExchange().anyExchange().permitAll().and().build(); // return
	 * http.build(); }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
