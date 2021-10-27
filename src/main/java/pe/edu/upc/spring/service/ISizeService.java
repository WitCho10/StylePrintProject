package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Size;

public interface ISizeService  {
	
	public boolean Registrar(Size size);
	public void eliminar (int idSize);
	public Optional<Size> listarId(int idSize);
	List<Size> listar();
}