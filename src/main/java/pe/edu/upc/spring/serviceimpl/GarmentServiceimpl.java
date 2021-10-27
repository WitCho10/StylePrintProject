package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.spring.model.Garment;
import pe.edu.upc.spring.repository.IGarmentRepository;
import pe.edu.upc.spring.service.IGarmentService;

@Service
public class GarmentServiceimpl implements IGarmentService{

	@Autowired
	private IGarmentRepository  cGarment;
	
	@Override
	public boolean Insertar(Garment garment) {
		Garment objGarment = cGarment.save(garment);
		if(objGarment==null)
			return false;
		else
			return true;
	}

	@Override
	public void Eliminar(int idGarment) {
		cGarment.deleteById(idGarment);
		
	}

	@Override
	public Optional<Garment> ListarId(int idGarment) {
	
		return cGarment.findById(idGarment);
	}

	@Override
	public List<Garment> Listar() {

		return cGarment.findAll();
	}

	@Override
	public List<Garment> findname(String nameGarment) {
	
		return cGarment.findname(nameGarment);
	}

	

	
}
