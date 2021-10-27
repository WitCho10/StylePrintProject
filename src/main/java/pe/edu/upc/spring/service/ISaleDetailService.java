package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.SaleDetail;

public interface ISaleDetailService {

	public boolean Registrar(SaleDetail saledetail);
	public void eliminar (int idSaleDetail);
	public Optional<SaleDetail> listarId(int idSaleDetail);
	List<SaleDetail> listar();
}
