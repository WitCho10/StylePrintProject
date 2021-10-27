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
public class SizeServiceimpl implements ISizeService {

	@Autowired
	private ISizeRepository sSize;
	
	@Override
	@Transactional(readOnly=true)
	public boolean Insert(Size size) {
		Size objSize=sSize.save(size);
		if(objSize==null)
			return false;
		else 
			return true;
	}
	
	public Optional<Size> listarId(int idSize) {
	
		return null;
	}
	@Transactional(readOnly=true)
	@Override
	public List<Size> Listar() {

		return sSize.findAll();
	}
	@Transactional(readOnly=true)
	@Override
	public List<Size> SearchName(String NameSize) {
	
		return sSize.SearchName(NameSize);
	}

}
