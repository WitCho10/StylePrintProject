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
	public boolean insert(GarmentPosition garmentPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean modify(GarmentPosition garmentPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void remove(int IdAdmin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Optional<GarmentPosition> ListId(int idPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<GarmentPosition> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
