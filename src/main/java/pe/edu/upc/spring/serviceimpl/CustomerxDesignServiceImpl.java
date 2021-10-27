package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.CustomerxDesign;
import pe.edu.upc.spring.repository.ICustomerxDesignRepository;
import pe.edu.upc.spring.service.ICustomerxDesignService;

@Service
public class CustomerxDesignServiceImpl implements ICustomerxDesignService{

	@Autowired
	private ICustomerxDesignRepository cdCustomerxDesign;
	
	@Override
	@Transactional
	public boolean Registrar(CustomerxDesign customerxDesign) {
		CustomerxDesign objCustomerxDesign = cdCustomerxDesign.save(customerxDesign);
		if(objCustomerxDesign==null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idCustomerxDesign) {
		cdCustomerxDesign.deleteById(idCustomerxDesign);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CustomerxDesign> listarId(int idCustomerxDesign) {
		return cdCustomerxDesign.findById(idCustomerxDesign);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerxDesign> listar() {
		return cdCustomerxDesign.findAll();
	}


}
