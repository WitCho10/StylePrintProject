package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Garment;
import pe.edu.upc.spring.repository.IGarmentRepository;
import pe.edu.upc.spring.service.IGarmentService;

@Repository
public class GarmentServiceimpl implements IGarmentService{
	
	@Autowired
	private IGarmentRepository gGarment;
	
	@Override
	public boolean insertar(Garment garment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Garment garment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminar(int idGarment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Garment> listarId(int idGarment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Garment> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Garment> findname(String nameGarment) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
