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
	public boolean Insert(Supplier supplier) {
		
		Supplier objSupplier=sSupplier.save(supplier);
		if(objSupplier==null)
		return false;
			else
		return true;
	}

	@Override
	@Transactional
	public boolean Modify(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void Remove(int idSupplier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Supplier> ListId(int idSupplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Supplier> List() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Supplier> searchSupplier(String nameSupplier) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
