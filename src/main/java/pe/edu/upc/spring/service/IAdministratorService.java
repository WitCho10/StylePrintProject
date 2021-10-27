package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Administrator;

public interface IAdministratorService {

	public boolean Insertar(Administrator administrator);
	public void Eliminar(int IdAdmin);
	public Optional<Administrator>ListId(int IdAdmin);
	List<Administrator> listar();

}
