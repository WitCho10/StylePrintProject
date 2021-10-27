package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Size;

public interface ISizeService  {
	public boolean Insertar(Size size);
	public void Eliminar(int idSize);
	public Optional<Size> ListarId(int idSize);
	 List<Size> Listar();
}