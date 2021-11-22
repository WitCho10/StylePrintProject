package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.serviceimpl.JpaAdminDetailsService;
import pe.edu.upc.spring.serviceimpl.JpaDesignDetailsService;
//import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
//import pe.edu.upc.spring.serviceimpl.JpaAdminDetailsService;
//import pe.edu.upc.spring.serviceimpl.JpaDesignDetailsService;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private JpaAdminDetailsService adminDetailsService;
	
	@Autowired
	private JpaDesignDetailsService designDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
		
		
	//@Autowired
	//private LoginSuccessHandler successHandler;
	
	protected void configure(HttpSecurity http) throws Exception{
		try {
			http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/LoginCliente").defaultSuccessUrl("/LoginCliente",true).failureUrl("/login/error?error=true")
			.loginProcessingUrl("/login").permitAll()
			.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/bienvenido");
			//"hasRole('ROLE_ADMIN')")
			//.antMatchers("/customer").access("hasRole('ROLE_CLIENT')")
			//.antMatchers("/designer").access("hasRole('ROLE_DESIGN')")
			//.and()
			//.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/customer/bienvenido")
			//.permitAll().and().logout().logoutSuccessUrl("/logout").permitAll().;//aquí etiqueta para salir al menu principal
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

		
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		build.userDetailsService(adminDetailsService).passwordEncoder(passwordEncoder());
		build.userDetailsService(designDetailsService).passwordEncoder(passwordEncoder());
	}
	}
	
	
