package pe.edu.upc.spring.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.model.Role;
import pe.edu.upc.spring.repository.ICustomerRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	
	@Autowired
	private ICustomerRepository customerRepository;
	
	

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String emailCustomer) throws UsernameNotFoundException {
		
		Customer customer = customerRepository.findByEmailCustomer(emailCustomer);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//UserBuilder builder = null;
		for(Role role: customer.getRol()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return new User(customer.getEmailCustomer(),customer.getPasswordCustomer(),customer.getEnabled(),true,true,true,authorities);
		//return new User(customer.getEmailCustomer(),customer.getPasswordCustomer(),authorities);
		//return new User(customer.getEmailCustomer(),customer.getPasswordCustomer(),true,true,authorities);
//		if(customer!=null)
//		{
//			builder=User.withUsername(emailCustomer);
//			builder.disabled(false);
//			builder.password(customer.getPasswordCustomer());
//			builder.authorities(new SimpleGrantedAuthority("ROLE_CLIENT"));
//			
//		}else {
//			throw new UsernameNotFoundException("Usuario no encontrado");
//		}
//		
//		
//		return builder.build();
		
	}

	
	
	
}
