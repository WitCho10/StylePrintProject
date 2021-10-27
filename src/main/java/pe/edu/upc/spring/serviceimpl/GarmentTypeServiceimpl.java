package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.GarmentType;
import pe.edu.upc.spring.repository.IGarmentTypeRepository;
import pe.edu.upc.spring.service.IGarmentTypeService;

public class GarmentTypeServiceimpl implements IGarmentTypeService {

	@Autowired
	private IGarmentTypeRepository cGarmentType;
	
	@Override
	@Transactional
	public boolean Registar(GarmentType garmentType) {
		GarmentType objGarmentType = cGarmentType.save(garmentType);
		if(objGarmentType==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void Eliminar(int idGarmentType) {
		cGarmentType.deleteById(idGarmentType);
		
	}

	@Override
	@Transactional
	public Optional<GarmentType> ListId(int idGarmentType) {
		// TODO Auto-generated method stub
		return cGarmentType.findById(idGarmentType);
	}

	@Override
	@Transactional
	public List<GarmentType> Listar() {
		// TODO Auto-generated method stub
		return cGarmentType.findAll();
	}

}
