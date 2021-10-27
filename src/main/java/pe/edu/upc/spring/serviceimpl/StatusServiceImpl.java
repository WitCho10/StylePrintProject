package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Status;
import pe.edu.upc.spring.repository.IStatusRepository;
import pe.edu.upc.spring.service.IStatusService;

@Service
public class StatusServiceImpl implements IStatusService{

	@Autowired
	private IStatusRepository sStatus;
	
	@Override
	@Transactional
	public boolean Registrar(Status status) {
		Status objStatus = sStatus.save(status);
		if(objStatus==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idStatus) {
		sStatus.deleteById(idStatus);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Status> listarId(int idStatus) {
		return sStatus.findById(idStatus);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Status> listar() {
		return sStatus.findAll();
	}

}
