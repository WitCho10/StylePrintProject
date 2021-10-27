package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Garment;
import pe.edu.upc.spring.repository.IGarmentRepository;
import pe.edu.upc.spring.service.IGarmentService;


@Repository
public class GarmentServiceimpl implements IGarmentService{
	
	@Autowired
	private IGarmentRepository sGarment;

	@Override
	@Transactional
	public boolean Registrar(Garment garment) {

		Garment objGarment=sGarment.save(garment);
		if(objGarment==null)
			
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void Eliminar(int idGarment) {
		sGarment.deleteById(idGarment);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Garment> listarId(int idGarment) {
		return sGarment.findById(idGarment);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Garment> listar() {
		
		return sGarment.findAll();
	}

	}	