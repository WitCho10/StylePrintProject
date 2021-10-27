package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Design;
import pe.edu.upc.spring.repository.IDesignRepository;
import pe.edu.upc.spring.service.IDesignService;

@Service
public class DesignServiceImpl implements IDesignService{

	@Autowired
	private IDesignRepository dDesign;
	
	@Override
	@Transactional
	public boolean Registrar(Design design) {
		Design objDesign = dDesign.save(design);
		if(objDesign==null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idDesign) {
		dDesign.deleteById(idDesign);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Design> listarId(int idDesign) {
		return dDesign.findById(idDesign);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Design> listar() {
		return dDesign.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Design> buscarNombre(String nameDesign) {
		return dDesign.buscarNombre(nameDesign);
	}
	
}
