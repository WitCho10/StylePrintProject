package pe.edu.upc.spring.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.upc.spring.model.Administrator;

import pe.edu.upc.spring.repository.IAdministratorRepository;


@Service
public class JpaAdminDetailsService implements UserDetailsService{

	@Autowired
	private IAdministratorRepository administratorRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Administrator administrator = administratorRepository.findByUsername(username);
		UserBuilder builder = null;
		
		if(administrator!=null)
		{
			builder=User.withUsername(username);
			builder.disabled(false);
			builder.password(administrator.getPasswordAdministrator());
			builder.authorities(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		
		return builder.build();
	}

	
	
	
}
