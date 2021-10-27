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
	private IAdministratorRepository aAdministrator;
	
	@Override
	@Transactional
	public boolean insert(Administrator administrator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean modify(Administrator administrator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void remove(int IdAdmin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Optional<Administrator> ListId(int IdAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Administrator> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
