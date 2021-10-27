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
public class AdministratorServiceimpl implements IAdministratorService{

	@Autowired
	private IAdministratorRepository sAdministrator;
	
	@Override
	@Transactional
	public boolean Insertar(Administrator administrator) {
		Administrator objAdministrator=sAdministrator.save(administrator);
		if(objAdministrator==null)
			return false;
		else
			return true;
	}

	public void Eliminar(int IdAdmin) {
		sAdministrator.deleteById(IdAdmin);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Administrator> ListId(int IdAdmin) {
		return sAdministrator.findById(IdAdmin);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Administrator> listar() {
		return sAdministrator.findAll();
	}

}
