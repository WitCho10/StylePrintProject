package pe.edu.upc.spring.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Administrator;
import pe.edu.upc.spring.repository.IAdministratorRepository;
import pe.edu.upc.spring.service.IAdministratorService;

@Service
public class AdministratorServiceImpl implements IAdministratorService{

	@Autowired
	private IAdministratorRepository aAdministrator;
	
	@Override
	@Transactional
	public boolean Registrar(Administrator administrator) {
		Administrator objAdministrator = aAdministrator.save(administrator);
		if(objAdministrator==null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idAdministrator) {
		aAdministrator.deleteById(idAdministrator);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Administrator> listarId(int idAdministrator) {
		return aAdministrator.findById(idAdministrator);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Administrator> listar() {
		return aAdministrator.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Administrator> buscarNombre(String nameAdministrator) {
		return aAdministrator.buscarNombre(nameAdministrator);
	}

}
