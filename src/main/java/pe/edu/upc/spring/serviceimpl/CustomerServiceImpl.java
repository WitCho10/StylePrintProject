package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.repository.ICustomerRepository;
import pe.edu.upc.spring.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepository cCustomer;
	
	@Override
	@Transactional
	public boolean Registrar(Customer customer) {
		Customer objCustomer = cCustomer.save(customer);
		if(objCustomer==null)
			return false;
		else
			return true;
	}
	
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
	
}

