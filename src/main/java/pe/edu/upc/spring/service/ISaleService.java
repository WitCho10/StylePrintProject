package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Sale;

public interface ISaleService {

	public boolean Registrar(Sale sale);
	public void eliminar (int idSale);
	public Optional<Sale> listarId(int idSale);
	List<Sale> listar();
	
}
