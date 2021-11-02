package pe.edu.upc.spring.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Size;
import pe.edu.upc.spring.repository.ISizeRepository;
import pe.edu.upc.spring.service.ISizeService;

@Service
public class SizeServiceImpl implements ISizeService {

	@Autowired
	private ISizeRepository sSize;
	
	@Override
	@Transactional
	public boolean Registrar(Size size) {
		Size objSize = sSize.save(size);
		if(objSize==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idSize) {
		sSize.deleteById(idSize);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Size> listarId(int idSize) {
		return sSize.findById(idSize);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Size> listar() {
		return sSize.findAll();
	}

}
