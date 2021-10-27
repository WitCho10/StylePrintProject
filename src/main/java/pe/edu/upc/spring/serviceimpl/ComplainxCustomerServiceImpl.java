package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.ComplainxCustomer;
import pe.edu.upc.spring.repository.IComplainxCustomerRepository;
import pe.edu.upc.spring.service.IComplainxCustomerService;

@Service
public class ComplainxCustomerServiceImpl implements IComplainxCustomerService{

	
	@Autowired
	private IComplainxCustomerRepository ccComplainxCustomer;
	
	@Override
	@Transactional
	public boolean Registrar(ComplainxCustomer complainxCustomer) {
		ComplainxCustomer objComplainxCustomer = ccComplainxCustomer.save(complainxCustomer);
		if(objComplainxCustomer==null)
		{
			return false;
		}else
		{
			return true;
		}

	}

	@Override
	@Transactional
	public void eliminar(int idComplainxCustomer) {
		ccComplainxCustomer.deleteById(idComplainxCustomer);
		
	}

	
	@Override
	@Transactional(readOnly=true)
	public Optional<ComplainxCustomer> listarId(int idComplainxCustomer) {
		return ccComplainxCustomer.findById(idComplainxCustomer);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<ComplainxCustomer> buscarId(int idComplainxCustomer) {
		return ccComplainxCustomer.findById(idComplainxCustomer);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ComplainxCustomer> listar() {
		return ccComplainxCustomer.findAll();
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<ComplainxCustomer> buscarAsunto(String affairComplainxCustomer) {
		
		return ccComplainxCustomer.buscarAsunto(affairComplainxCustomer);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ComplainxCustomer> buscarCliente(String nameCustomer) {
		return ccComplainxCustomer.buscarCliente(nameCustomer);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ComplainxCustomer> buscarQueja(String nameComplain) {
		return ccComplainxCustomer.buscarQueja(nameComplain);
	}

}
