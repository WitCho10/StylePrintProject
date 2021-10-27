package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.GarmentType;

public interface IGarmentTypeService {

	public boolean Registrar(GarmentType garmentType);
	public void eliminar (int idGarmentType);
	public Optional<GarmentType> listarId(int idGarmentType);
	List<GarmentType> listar();
}
