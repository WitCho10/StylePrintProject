package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Complain;

public interface IComplainService {

	public boolean Registrar(Complain complain);
	public void eliminar (int idComplain);
	public Optional<Complain> listarId(int idComplain);
	List<Complain> listar();
	
}
