package pe.edu.upc.spring.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.upc.spring.model.Designer;
import pe.edu.upc.spring.repository.IDesignerRepository;

@Service
public class JpaDesignDetailsService implements UserDetailsService{

	

	
	@Autowired
	private IDesignerRepository designerRepository;

	@Override
	public UserDetails loadUserByUsername(String emialDesigner) throws UsernameNotFoundException {
		
		Designer designer = designerRepository.findByEmialDesigner(emialDesigner);
		UserBuilder builder = null;
		
		if(designer!=null)
		{
			builder=User.withUsername(emialDesigner);
			builder.disabled(false);
			builder.password(designer.getPassworDesigner());
			builder.authorities(new SimpleGrantedAuthority("ROLE_DESIGN"));
			
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		
		return builder.build();
	}

	
	
	
}
