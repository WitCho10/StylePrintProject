package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Designer;


public interface IDesignerService {

	public boolean Registrar(Designer designer);
	public void eliminar (int idDesigner);
	public Optional<Designer> listarId(int idDesigner);
	List<Designer> listar();
	List<Designer> buscarNombre(String nameDesigner);
}
