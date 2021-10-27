package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Supplier;

public interface ISupplierService {

	public boolean Insertar(Supplier supplier);
	public void Eliminar(int idSupplier);
	public Optional<Supplier>ListId(int idSupplier);
	List<Supplier>List();
	
}
