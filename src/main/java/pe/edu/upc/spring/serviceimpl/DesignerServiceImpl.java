package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Designer;
import pe.edu.upc.spring.repository.IDesignerRepository;
import pe.edu.upc.spring.service.IDesignerService;

@Service
public class DesignerServiceImpl implements IDesignerService{

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IDesignerRepository dDesigner;
	
	@Override
	@Transactional
	public boolean Registrar(Designer designer) {
		Designer objDesigner = dDesigner.save(designer);
		if(objDesigner==null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idDesigner) {
		dDesigner.deleteById(idDesigner);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Designer> listarId(int idDesigner) {
		return dDesigner.findById(idDesigner);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Designer> listar() {
		return dDesigner.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Designer> buscarNombre(String nameDesigner) {
		return dDesigner.buscarNombre(nameDesigner);
	}

	@Override
	public Designer RegistrarNuevo(Designer designer) {
		designer.setPassworDesigner(passwordEncoder.encode(designer.getPassworDesigner()));
		return  dDesigner.save(designer);
		
	}
	
}

