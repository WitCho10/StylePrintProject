package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.GarmentPersonalized;
import pe.edu.upc.spring.repository.IGarmentPersonalizedRepository;
import pe.edu.upc.spring.service.IGarmentPersonalizedService;

@Service
public class GarmentPersonalizedServiceimpl implements  IGarmentPersonalizedService{

	
	@Autowired
	private IGarmentPersonalizedRepository sGarmentPersonalized;

	@Override
	@Transactional
	public boolean Registrar(GarmentPersonalized garmentpersonalized) {
		GarmentPersonalized objGarmentPersonalized=sGarmentPersonalized.save(garmentpersonalized);
		if(objGarmentPersonalized==null)
		return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int IdGarmentPersonalized) {
	sGarmentPersonalized.deleteById(IdGarmentPersonalized);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<GarmentPersonalized> listarId(int IdGarmentPersonalized) {

		return sGarmentPersonalized.findById(IdGarmentPersonalized);
	}

	@Override
	@Transactional(readOnly=true)
	public List<GarmentPersonalized> listar() {
	
		return sGarmentPersonalized.findAll();
	}
	
	

}
