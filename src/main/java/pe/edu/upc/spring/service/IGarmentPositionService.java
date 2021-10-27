package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.GarmentPosition;



public interface IGarmentPositionService {


	public boolean Insertar(GarmentPosition garmentPosition);
	public void Eliminar(int idPosition);
	public Optional<GarmentPosition>ListId(int idPosition);
	List<GarmentPosition> listar();
}
