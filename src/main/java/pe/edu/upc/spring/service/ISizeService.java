package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Size;

public interface ISizeService  {
	public boolean Insert(Size size);
	public Optional<Size> listarId(int idSize);
	 	List<Size> Listar();
	 	List<Size> SearchName(String NameSize);
}