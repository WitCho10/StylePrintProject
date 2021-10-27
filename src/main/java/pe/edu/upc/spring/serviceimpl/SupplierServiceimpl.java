package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Supplier;
import pe.edu.upc.spring.repository.ISupplierRepository;
import pe.edu.upc.spring.service.ISupplierService;

@Service
public class SupplierServiceImpl implements ISupplierService{

	@Autowired
	private ISupplierRepository sSupplier;
	
	@Override
	@Transactional
	public boolean Registrar(Supplier supplier) {
		Supplier objSupplier = sSupplier.save(supplier);
		if(objSupplier==null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idSupplier) {
		sSupplier.deleteById(idSupplier);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Supplier> listarId(int idSupplier) {
		return sSupplier.findById(idSupplier);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Supplier> listar() {
		return sSupplier.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Supplier> buscarNombre(String nameSupplier) {
		return sSupplier.buscarNombre(nameSupplier);
	}
	
}
