package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.GarmentPosition;



public interface IGarmentPositionService {


	public boolean Registar(GarmentPosition garmentPosition);
	public void Eliminar(int IdGarmentPosition);
	public Optional<GarmentPosition>ListId(int IdGarmentPosition);
	List<GarmentPosition> Listar();
}
