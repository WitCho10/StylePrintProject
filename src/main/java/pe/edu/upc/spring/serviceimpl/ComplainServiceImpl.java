package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Complain;
import pe.edu.upc.spring.repository.IComplainRepository;
import pe.edu.upc.spring.service.IComplainService;

@Service
public class ComplainServiceImpl implements IComplainService{

	@Autowired
	private IComplainRepository sComplain;
	
	@Override
	@Transactional
	public boolean Registrar(Complain complain) {
		Complain objComplain = sComplain.save(complain);
		if(objComplain==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idComplain) {
		sComplain.deleteById(idComplain);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Complain> listarId(int idComplain) {
		return sComplain.findById(idComplain);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Complain> listar() {
		return sComplain.findAll();
	}

}
