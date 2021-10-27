package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Administrator;


public interface IAdministratorService {

	public boolean Registrar(Administrator administrator);
	public void eliminar (int idAdministrator);
	public Optional<Administrator> listarId(int idAdministrator);
	List<Administrator> listar();
	List<Administrator> buscarNombre(String nameAdministrator);

}
