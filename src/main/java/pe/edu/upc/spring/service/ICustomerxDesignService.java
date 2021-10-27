package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.CustomerxDesign;

public interface ICustomerxDesignService {

	public boolean Registrar(CustomerxDesign customerxDesign);
	public void eliminar (int idCustomerxDesign);
	public Optional<CustomerxDesign> listarId(int idCustomerxDesign);
	List<CustomerxDesign> listar();
	
}
