package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.ComplainxCustomer;


public interface IComplainxCustomerService {

	public boolean Registrar(ComplainxCustomer complainxCustomer);
	public void eliminar(int idComplainxCustomer);
	public Optional<ComplainxCustomer> listarId(int idComplainxCustomer);
	public Optional<ComplainxCustomer> buscarId(int idComplainxCustomer);
	List<ComplainxCustomer> listar();
	List<ComplainxCustomer> buscarAsunto(String affairComplainxCustomer);
	List<ComplainxCustomer> buscarCliente(String nameCustomer);
	List<ComplainxCustomer> buscarQueja(String nameComplain);

}
