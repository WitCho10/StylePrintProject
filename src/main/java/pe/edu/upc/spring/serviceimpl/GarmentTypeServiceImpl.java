package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.GarmentType;
import pe.edu.upc.spring.repository.IGarmentTypeRepository;
import pe.edu.upc.spring.service.IGarmentTypeService;

@Service
public class GarmentTypeServiceImpl implements IGarmentTypeService{

	@Autowired
	private IGarmentTypeRepository gtGarmentType;
	
	@Override
	@Transactional
	public boolean Registrar(GarmentType garmenttype) {
		GarmentType objGarmentType = gtGarmentType.save(garmenttype);
		if(objGarmentType==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idGarmentType) {
		gtGarmentType.deleteById(idGarmentType);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<GarmentType> listarId(int idGarmentType) {
		return gtGarmentType.findById(idGarmentType);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GarmentType> listar() {
		return gtGarmentType.findAll();
	}
	
}
