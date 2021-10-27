package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Garment;

public interface IGarmentService {
	
	public boolean Registrar(Garment garment);
	public void eliminar (int idGarment);
	public Optional<Garment> listarId(int idGarment);
	List<Garment> listar();
	

}
