package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Status;

public interface IStatusService {

	public boolean Registrar(Status estado);
	public void eliminar (int idEstado);
	public Optional<Status> listarId(int idEstado);
	List<Status> listar();
	
}
