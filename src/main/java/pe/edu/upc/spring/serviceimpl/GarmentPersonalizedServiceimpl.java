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
	
	private IGarmentPersonalizedRepository gGarmentPersonalized;

	@Override
	@Transactional
	public boolean Insertar(GarmentPersonalized garmentpersonalized) {
		
		GarmentPersonalized objGarmentPersonalized = gGarmentPersonalized.save(garmentpersonalized);
		if(objGarmentPersonalized==null)
			return false;
		else
			return true;
	
	}

	@Override
	@Transactional
	public void Eliminar(int idGarmentPersonalized) {
	
		gGarmentPersonalized.deleteById(idGarmentPersonalized);	
	}

	@Override
	@Transactional
	public Optional<GarmentPersonalized> listarId(int idGarmentPersonalized) {

		return gGarmentPersonalized.findById(idGarmentPersonalized);
	}

	@Override
	@Transactional
	public List<GarmentPersonalized> listar() {
		// TODO Auto-generated method stub
		return gGarmentPersonalized.findAll();
	}
	

	
	
}
