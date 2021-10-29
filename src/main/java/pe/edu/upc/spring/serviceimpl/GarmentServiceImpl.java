package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Garment;
import pe.edu.upc.spring.repository.IGarmentRepository;
import pe.edu.upc.spring.service.IGarmentService;

@Service
public class GarmentServiceImpl implements IGarmentService{
	
	@Autowired
	private IGarmentRepository gGarment;
	
	@Override
	@Transactional
	public boolean Registrar(Garment garment) {
		Garment objGarment = gGarment.save(garment);
		if(objGarment==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idGarment) {
		gGarment.deleteById(idGarment);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Garment> listarId(int idGarment) {
		return gGarment.findById(idGarment);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Garment> listar() {
		return gGarment.findAll();
	}

	
}
