package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.GarmentPosition;
import pe.edu.upc.spring.repository.IGarmentPositionRepository;
import pe.edu.upc.spring.service.IGarmentPositionService;

@Service
public class GarmentPositionServiceImpl implements IGarmentPositionService{

	@Autowired
	private IGarmentPositionRepository gpGarmentPosition;
	
	@Override
	@Transactional
	public boolean Registrar(GarmentPosition garmentposition) {
		GarmentPosition objGarmentPosition = gpGarmentPosition.save(garmentposition);
		if(objGarmentPosition==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idGarmentPosition) {
		gpGarmentPosition.deleteById(idGarmentPosition);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<GarmentPosition> listarId(int idGarmentPosition) {
		return gpGarmentPosition.findById(idGarmentPosition);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GarmentPosition> listar() {
		return gpGarmentPosition.findAll();
	}

}
