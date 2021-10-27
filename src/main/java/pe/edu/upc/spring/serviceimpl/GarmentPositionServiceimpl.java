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
	private IGarmentPositionRepository dGarmentPosition;

	@Override
	@Transactional
	public boolean Insertar(GarmentPosition garmentPosition) {
		GarmentPosition objGarmentPosition = dGarmentPosition.save(garmentPosition);
		if(objGarmentPosition==null)
			return false;
		else
			return true;
	}
	@Override
	@Transactional
	public void Eliminar(int idPosition) {
		dGarmentPosition.deleteById(idPosition);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<GarmentPosition> ListId(int idPosition) {
		// TODO Auto-generated method stub
		return dGarmentPosition.findById(idPosition);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GarmentPosition> listar() {
		dGarmentPosition.findAll();
		return null;
	}

}
