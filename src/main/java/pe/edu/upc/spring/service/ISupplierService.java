package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.Supplier;

public interface ISupplierService {

	public boolean Registrar(Supplier supplier);
	public void eliminar (int idSupplier);
	public Optional<Supplier> listarId(int idSupplier);
	List<Supplier> listar();
	List<Supplier> buscarNombre(String nameSupplier);
	
}
