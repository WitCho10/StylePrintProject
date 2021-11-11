package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
import pe.edu.upc.spring.serviceimpl.JpaAdminDetailsService;
import pe.edu.upc.spring.serviceimpl.JpaDesignDetailsService;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private JpaAdminDetailsService adminDetailsService;
	
	@Autowired
	private JpaDesignDetailsService designDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	protected void configure(HttpSecurity http) throws Exception{
		try {
			http.authorizeRequests()
			.antMatchers("/administrator").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/customer").access("hasRole('ROLE_CLIENT')")
			.antMatchers("/designer").access("hasRole('ROLE_DESIGN')").and()
			.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido")
			.permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("");//aquí etiqueta para salir al menu principal
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		
	}
	
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		build.userDetailsService(adminDetailsService).passwordEncoder(passwordEncoder);
		build.userDetailsService(designDetailsService).passwordEncoder(passwordEncoder);
	}
	
	
}
