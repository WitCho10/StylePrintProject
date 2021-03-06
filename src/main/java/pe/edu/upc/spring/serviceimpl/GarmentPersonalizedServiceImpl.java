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
public class GarmentPersonalizedServiceImpl implements  IGarmentPersonalizedService{

	@Autowired
	private IGarmentPersonalizedRepository gpGarmentPersonalized;
	
	@Override
	@Transactional
	public boolean Registrar(GarmentPersonalized garmentpersonalized) {
		GarmentPersonalized objGarmentPersonalized = gpGarmentPersonalized.save(garmentpersonalized);
		if(objGarmentPersonalized==null)
		{
			return false;
		}else
		{
			return true;
		}

	}

	@Override
	@Transactional
	public void eliminar(int idGarmentPersonalized) {
		gpGarmentPersonalized.deleteById(idGarmentPersonalized);
		
	}

	
	@Override
	@Transactional(readOnly=true)
	public Optional<GarmentPersonalized> listarId(int idGarmentPersonalized) {
		return gpGarmentPersonalized.findById(idGarmentPersonalized);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<GarmentPersonalized> buscarId(int idGarmentPersonalized) {
		return gpGarmentPersonalized.findById(idGarmentPersonalized);
	}

	@Override
	@Transactional(readOnly=true)
	public List<GarmentPersonalized> listar() {
		return gpGarmentPersonalized.findAll();
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<GarmentPersonalized> buscarUrl(String urlimageGarmentPersonalized) {
		
		return gpGarmentPersonalized.buscarUrl(urlimageGarmentPersonalized);
	}

	@Override
	@Transactional(readOnly=true)
	public List<GarmentPersonalized> buscarCliente(String nameCustomer) {
		return gpGarmentPersonalized.buscarCliente(nameCustomer);
	}

}
