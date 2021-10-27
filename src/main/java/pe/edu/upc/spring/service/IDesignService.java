package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Design;


public interface IDesignService {

	public boolean Registrar(Design design);
	public void eliminar (int idDesign);
	public Optional<Design> listarId(int idDesign);
	List<Design> listar();
	List<Design> buscarNombre(String nameDesign);	
}
