package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Customer;


public interface ICustomerService {

	public boolean Registrar(Customer customer);
	public void eliminar (int idCustomer);
	public Optional<Customer> listarId(int idCustomer);
	List<Customer> listar();
	List<Customer> buscarNombre(String nameCustomer);
	public Customer findByUsername(String username);
	public Customer login(Customer bean);
	//public Customer login(String emailCustomer, String passwordCustomer);
	
}
