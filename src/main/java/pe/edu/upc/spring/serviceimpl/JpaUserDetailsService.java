package pe.edu.upc.spring.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.repository.ICustomerRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	
	@Autowired
	private ICustomerRepository customerRepository;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer = customerRepository.findByUsername(username);
		UserBuilder builder = null;
		
		if(customer!=null)
		{
			builder=User.withUsername(username);
			builder.disabled(false);
			builder.password(customer.getPasswordCustomer());
			builder.authorities(new SimpleGrantedAuthority("ROLE_CLIENT"));
			
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		
		return builder.build();
	}

	
	
	
}
