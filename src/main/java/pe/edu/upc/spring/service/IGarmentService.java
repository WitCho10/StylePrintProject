package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Garment;

public interface IGarmentService {
	
	public boolean Insertar(Garment garment);
	public void Eliminar(int idGarment);
	public Optional<Garment> ListarId(int idGarment);
	List<Garment> Listar();
	List<Garment>findname(String nameGarment);
	

}
