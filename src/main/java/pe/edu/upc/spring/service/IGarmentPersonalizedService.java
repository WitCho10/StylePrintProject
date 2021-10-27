package pe.edu.upc.spring.service;


import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.GarmentPersonalized;


public interface IGarmentPersonalizedService {
	public boolean Registrar(GarmentPersonalized garmentPersonalized);
	public void eliminar(int idGarmentPersonalized);
	public Optional<GarmentPersonalized> listarId(int idGarmentPersonalized);
	public Optional<GarmentPersonalized> buscarId(int idGarmentPersonalized);
	List<GarmentPersonalized> listar();
	List<GarmentPersonalized> buscarUrl(String urlimageGarmentPersonalized);
	List<GarmentPersonalized> buscarCliente(String nameCustomer);
}
