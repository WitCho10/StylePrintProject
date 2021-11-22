package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.repository.ICustomerRepository;
import pe.edu.upc.spring.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ICustomerRepository cCustomer;
	

	

//	@Override
//	public Customer login(String username, String Password) {
//		Customer user = cCustomer.findByUsernameAndPassword(username, Password);
//		return user;
//	}
	
	@Override
	@Transactional
	public void eliminar(int idCustomer) {
		cCustomer.deleteById(idCustomer);
	}	
	@Override
	@Transactional(readOnly = true)
	public Optional<Customer> listarId(int idCustomer) {
		return cCustomer.findById(idCustomer);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> listar() {
		return cCustomer.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> buscarNombre(String nameCustomer) {
		return cCustomer.buscarNombre(nameCustomer);
	}
	@Override
	@Transactional
	public Customer Registrar(Customer customer) {
	customer.setPasswordCustomer(passwordEncoder.encode(customer.getPasswordCustomer()));
		return cCustomer.save(customer);
	}
	@Override
public boolean registrar(Customer customer) {
		
		String pass= customer.getPasswordCustomer();
		String passEcript = passwordEncoder.encode(pass);
		
		customer.setPasswordCustomer(passEcript);
		//customer.setPasswordCustomer();;
		Customer objCustomer = cCustomer.save(customer);
		if(objCustomer==null)
			return false;
		else
			return true;
	}
	
//	@Override
//	@Transactional(readOnly = true)
//	public Customer login(String emailCustomer, String passwordCustomer){
//		Customer getCustomer = cCustomer.buscarPorUsernameYPassword(emailCustomer, passwordCustomer);
//		return getCustomer;
//	}
}

