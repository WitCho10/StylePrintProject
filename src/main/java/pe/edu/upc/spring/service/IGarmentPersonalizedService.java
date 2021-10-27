package pe.edu.upc.spring.service;


import java.util.List;
import java.util.Optional;
import pe.edu.upc.spring.model.GarmentPersonalized;

public interface IGarmentPersonalizedService {
	public boolean Insertar(GarmentPersonalized garmentpersonalized);
	public void Eliminar(int  idGarmentPersonalized);
	public Optional<GarmentPersonalized> listarId(int idGarmentPersonalized);
	List<GarmentPersonalized> listar();
}
