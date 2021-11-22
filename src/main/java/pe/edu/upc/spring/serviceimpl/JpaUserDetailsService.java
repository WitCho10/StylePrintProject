package pe.edu.upc.spring.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Usuario;

import pe.edu.upc.spring.repository.IUsuarioRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	@Autowired
	private IUsuarioRepository usuarioRepository;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
		Usuario  usuario = usuarioRepository.findByUsername(useremail);
		UserBuilder builder =null;
		
		if(usuario !=null){
			builder=User.withUsername(useremail);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority("ROLE_CLIENT"));
		}
		else {
			throw new UsernameNotFoundException("Correo no encontrado");
		}
		return builder.build();
	}
}
		

