package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.GarmentPosition;



public interface IGarmentPositionService {

	public boolean Registrar(GarmentPosition garmentPosition);
	public void eliminar (int idGarmentPosition);
	public Optional<GarmentPosition> listarId(int idGarmentPosition);
	List<GarmentPosition> listar();
}
