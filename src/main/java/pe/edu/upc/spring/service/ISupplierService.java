package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Supplier;

public interface ISupplierService {

	public boolean Insert(Supplier supplier);
	public boolean Modify(Supplier supplier);
	public void Remove(int idSupplier);
	public Optional<Supplier>ListId(int idSupplier);
	List<Supplier>List();
	List<Supplier>searchSupplier(String nameSupplier);
	
}
