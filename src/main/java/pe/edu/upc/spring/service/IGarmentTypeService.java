package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.GarmentType;

public interface IGarmentTypeService {

	public boolean Registar(GarmentType garmentType);
	public void Eliminar(int idGarmentType);
	public Optional<GarmentType>ListId(int idGarmentType);
	List<GarmentType> Listar();
}