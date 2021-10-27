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
public class GarmentPositionServiceimpl implements IGarmentPositionService{

	@Autowired
	private IGarmentPositionRepository cGarmentPosition;

	@Override
	@Transactional
	public boolean Registar(GarmentPosition garmentPosition) {
		
		GarmentPosition objGarmentPosition = cGarmentPosition.save(garmentPosition);
		if(objGarmentPosition==null)
			return false;
		else
			return true;
	
	}

	@Override
	@Transactional
	public void Eliminar(int IdGarmentPosition) {
		cGarmentPosition.deleteById(IdGarmentPosition);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<GarmentPosition> ListId(int IdGarmentPosition) {
	
		return cGarmentPosition.findById(IdGarmentPosition);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GarmentPosition> Listar() {
		return cGarmentPosition.findAll();
	}
	


}
