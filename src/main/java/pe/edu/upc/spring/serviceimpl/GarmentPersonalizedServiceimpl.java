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
	public boolean insertar(GarmentPersonalized garmentpersonalized) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(GarmentPersonalized garmentpersonalized) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public Optional<GarmentPersonalized> listarId(int idGarmentPersonalized) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<GarmentPersonalized> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
